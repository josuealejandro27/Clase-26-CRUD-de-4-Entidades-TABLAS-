package mx.utng.s26.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;
import mx.utng.s26.model.entity.Building;
import mx.utng.s26.model.service.IBuildingService;

@Controller
@SessionAttributes("building")
public class BuildingController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IBuildingService buildingService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/building/list","/building","/building/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Edificios");
    model.addAttribute("buildings", buildingService.list());
    return "blist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/building/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Edificios");
        model.addAttribute("building", new Building());
        return "bform";
    }

    @GetMapping("/building/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Building building = null;
        if (id>0) {
            building = buildingService.getById(id);
        }else{
            return "redirect:blist";
        }

        model.addAttribute("title", "Editar Edificio");
        model.addAttribute("building", building);
        return "bform";
    }


    @PostMapping ("/building/form")
    public String save(@Valid Building building, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Edificios");
            return "bform";
        }

        buildingService.save(building);
        return "redirect:/building/list";
    }

    @GetMapping("/building/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            buildingService.delete(id);
        }
        return "redirect:/building/list";
    }

}

