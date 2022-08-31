package cl.cokke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cl.cokke.dto.TutorialDTO;
import cl.cokke.services.TutorialServices;

@Controller
@RequestMapping("tutoriales")
public class TutorialController {
	
	@Autowired
	private TutorialServices tutorialService;
	
	@GetMapping
	public ModelAndView tutoriales() {
		ModelAndView modelAndView = new ModelAndView("tutoriales");
		modelAndView.addObject("tutoriales", tutorialService.findAll());
		
		return modelAndView;
	}
	
	//metodo para deplegar la vista crear tutorial
	@GetMapping("/crear")
	public ModelAndView crear() {
		ModelAndView modelAndView = new ModelAndView("crear-tutorial");
		modelAndView.addObject("tutorial", new TutorialDTO());
		return modelAndView;
	}
	
	//metodo para crear el registro de tutorial enviado desde la vista
	@PostMapping("/crear")
	public RedirectView crear(@ModelAttribute("tutorial") TutorialDTO tutorialDTO) {
		
		tutorialService.save(tutorialDTO);
		
		return new RedirectView("/tutoriales");
	}

	@GetMapping("/editar")
	public ModelAndView editar(@RequestParam Long id ) {
		ModelAndView modelAndView = new ModelAndView("editar-tutorial");
		modelAndView.addObject("tutorial", new TutorialDTO());
		modelAndView.addObject("tutorialVO", tutorialService.findById(id));
		return modelAndView;
	}
	
	@PostMapping("/editar")
	public RedirectView editar(@ModelAttribute("tutorial") TutorialDTO tutorialDTO) {
		
		tutorialService.update(tutorialDTO);
		
		return new RedirectView("/tutoriales");
	}
	
	
	@GetMapping("/eliminar")
	public RedirectView eliminar(@RequestParam Long id ) {
		
		if (tutorialService.findById(id).getId() != null) {
			tutorialService.delete(id);
		}	
		return new RedirectView("/tutoriales");
	}
	
	
}
