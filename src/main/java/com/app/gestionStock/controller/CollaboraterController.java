/**
 * 
 */
package com.app.gestionStock.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.gestionStock.dto.CollaboraterDTO;
import com.app.gestionStock.dto.DeliveryCollaboraterDTO;
import com.app.gestionStock.dto.MaskDTO;
import com.app.gestionStock.dto.SimpleDeliveryDTO;
import com.app.gestionStock.model.Category;
import com.app.gestionStock.model.Collaborater;
import com.app.gestionStock.model.Delivery;
import com.app.gestionStock.model.DeliveryId;
import com.app.gestionStock.model.Mask;
import com.app.gestionStock.service.CategoryServiceImpl;
import com.app.gestionStock.service.CollaboraterServiceImpl;
import com.app.gestionStock.service.DeliveryServiceImpl;
import com.app.gestionStock.service.MaskServiceImpl;

/**
 * @author mohamed
 *
 */
@Controller
@RequestMapping
public class CollaboraterController {

	@Autowired
	CollaboraterServiceImpl collaboraterService;

	@Autowired
	CategoryServiceImpl categorieService;

	@Autowired
	DeliveryServiceImpl deliveryService;

	@Autowired
	MaskServiceImpl maskService;

	@GetMapping("/")
	public String index(Model model) {
		return "home";
	}

	@GetMapping("/admin/delivery")
	public String delivery(DeliveryCollaboraterDTO deliveryCollaboraterDTO, Model model) {
		List<Category> categories = categorieService.getAllCategories();
		model.addAttribute("categories", categories);
		return "delivery";
	}
	

	
	
	@GetMapping("/confirm")
	public String confirm(Model model, @RequestParam(name = "id") Integer id) {
		model.addAttribute("collab", collaboraterService.findCollaboraterById(id).get());
		return "confirm";
	}

	@GetMapping("/home")
	public String home(Model model) {
		List<DeliveryCollaboraterDTO> dt = getDeliveryCollab();
		model.addAttribute("deliveries", dt);
		return "home";
	}

	private List<DeliveryCollaboraterDTO> getDeliveryCollab() {
		List<Object[]> deliv = deliveryService.getAllDelivery();
		List<DeliveryCollaboraterDTO> dt = new ArrayList<DeliveryCollaboraterDTO>();

		deliv.forEach(d -> {
			DeliveryCollaboraterDTO dtt = new DeliveryCollaboraterDTO();

			for (int i = 0; i < d.length; i++) {
				dtt.setRegisteredNumber(d[0].toString());
				dtt.setLastName(d[1].toString());
				dtt.setFirstName(d[2].toString());
				dtt.setBirthDate((LocalDate) d[3]);

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDateTime time = LocalDateTime.from(LocalDate.parse(d[4].toString(), formatter).atStartOfDay());

				dtt.setCreationDateTime(time);
				dtt.setEmail(d[5].toString());
				dtt.setCategory((String) d[6]);
				dtt.setQuantite((Integer) d[7]);
				dtt.setGel((boolean) d[8]);
			}
			dt.add(dtt);
		});
		return dt;
	}


	/**
	 * Ajoute un nouveau collaborateur dans la base de données H2. Si le client
	 * existe déjà, on retourne un code indiquant que la création n'a pas abouti.
	 * 
	 * @param deliveryCollaboraterDTO
	 * @return
	 */
	@PostMapping(value = "/admin/delivery")
	public String createNewDelivery(@Valid DeliveryCollaboraterDTO deliveryCollaboraterDTO, BindingResult bindingResult,
			Model model) {
		List<Category> categories = categorieService.getAllCategories();
		model.addAttribute("categories", categories);
		if (bindingResult.hasErrors()) {
			return "delivery";
		}
		Collaborater existingCollaborater = collaboraterService
				.findCollaboraterByRegisteredNumber(deliveryCollaboraterDTO.getRegisteredNumber());
		if (existingCollaborater != null) {
			model.addAttribute("collabExist", "collabExist");
			return "delivery";
			// return new ResponseEntity<CollaboraterDTO>(HttpStatus.CONFLICT);
		}	

		CollaboraterDTO clbt = new CollaboraterDTO();
		clbt.setRegisteredNumber(deliveryCollaboraterDTO.getRegisteredNumber());
		clbt.setLastName(deliveryCollaboraterDTO.getLastName());
		clbt.setFirstName(deliveryCollaboraterDTO.getFirstName());
		clbt.setBirthDate(deliveryCollaboraterDTO.getBirthDate());
		clbt.setId(deliveryCollaboraterDTO.getId());
		clbt.setEmail(deliveryCollaboraterDTO.getEmail());

		Collaborater collaboraterRequest = mapCollaboraterDTOToCollaborater(clbt);
		collaboraterRequest.setCreationDate(LocalDate.now());
		Collaborater collaboraterResponse = collaboraterService.saveCollaborater(collaboraterRequest);

		if (collaboraterResponse != null) {
			SimpleDeliveryDTO dlv = new SimpleDeliveryDTO();
			dlv.setCollaboraterId(collaboraterResponse.getId());
			dlv.setGel(deliveryCollaboraterDTO.isGel());
			dlv.setQuantite(deliveryCollaboraterDTO.getQuantite());
			dlv.setMaskId(
					categorieService.findCategoryByCode(deliveryCollaboraterDTO.getCategory().toString()).getId());

			Delivery cat = mapDeliveryDTOToDelivery(dlv);
			Delivery caRespt = deliveryService.saveDelivery(cat);
			if (caRespt != null) {
				// CollaboraterDTO customerDTO =
				// mapCollaboraterToCollaboraterDTO(collaboraterResponse);
				updateStock(deliveryCollaboraterDTO.getCategory().toString(), deliveryCollaboraterDTO.getQuantite());
				return "redirect:/confirm?id=" + collaboraterResponse.getId();
				// return new ResponseEntity<CollaboraterDTO>(customerDTO, HttpStatus.CREATED);
			} else {
				model.addAttribute("errorInsert", "errorInsert");
				return "delivery";
				// return new ResponseEntity<CollaboraterDTO>(HttpStatus.NOT_MODIFIED);
			}
		} else {
			model.addAttribute("errorInsert", "errorInsert");
			return "delivery";
			// return new ResponseEntity<CollaboraterDTO>(HttpStatus.NOT_MODIFIED);
		}
	}

	private void updateStock(String codeMask, Integer qt) {
		Mask mask = maskService.findMaskByCode(codeMask);
		Integer quantity = mask.getTotal() - qt;
		mask.setTotal(quantity);
		maskService.updateMask(mask);
	}

	@GetMapping("/stock")
	public String stockMask(MaskDTO maskDTO, Model model) {
		List<Mask> masks = maskService.getAllWithCategory();
		model.addAttribute("masks", masks);
		return "stock";
	}

	@GetMapping("/admin/editStock")
	public String editMask(@RequestParam String id, MaskDTO maskDTO, Model model) {
		Optional<Mask> masks = maskService.findMaskById(Integer.valueOf(id));
		model.addAttribute("mask", mapMaskToMaskDTO(masks.get()));
		return "editStock";
	}

	@PostMapping("/admin/saveStock")
	public String saveMask(MaskDTO maskDTO, Model model) {
		System.out.println(maskDTO.getId());
		Mask mask = maskService.findMaskById(Integer.valueOf(maskDTO.getId())).get();
		mask.setTotal(maskDTO.getTotal());
		maskService.updateMask(mask);
		List<Mask> masks = maskService.getAllWithCategory();
		model.addAttribute("masks", masks);
		return "stock";
	}



	/**
	 * Transforme un POJO CollaboraterDTO en entity Collaborater
	 * 
	 * @param collaboraterDTO
	 * @return
	 */
	private Collaborater mapCollaboraterDTOToCollaborater(CollaboraterDTO collaboraterDTO) {
		ModelMapper mapper = new ModelMapper();
		Collaborater customer = mapper.map(collaboraterDTO, Collaborater.class);
		return customer;
	}

	/**
	 * Transforme un POJ DeliveryDTO en entity Delivery
	 * 
	 * @param deliveryDTO
	 * @return
	 */
	private Delivery mapDeliveryDTOToDelivery(SimpleDeliveryDTO deliveryDTO) {
		Delivery delivery = new Delivery();
		Optional<Mask> mask = maskService.findMaskById(deliveryDTO.getMaskId());
		Optional<Collaborater> collaborater = collaboraterService.findCollaboraterById(deliveryDTO.getCollaboraterId());

		DeliveryId loanId = new DeliveryId(collaborater.get(), mask.get());
		delivery.setPk(loanId);
		delivery.setGel(deliveryDTO.isGel());
		delivery.setQuantity(deliveryDTO.getQuantite());
		return delivery;
	}



	/**
	 * Transform entity Mask to POJO MaskDTO
	 * 
	 * @param delivery
	 * @return
	 */
	private MaskDTO mapMaskToMaskDTO(Mask mask) {
		ModelMapper mapper = new ModelMapper();
		MaskDTO maskDTO = mapper.map(mask, MaskDTO.class);
		return maskDTO;
	}
}
