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
import mx.utng.s26.model.entity.Professor;
import mx.utng.s26.model.service.IProfessorService;

@Controller
@SessionAttributes("professor")
public class ProfessorController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IProfessorService professorService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/professor/list","/professor","/professor/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Profesores");
    model.addAttribute("professors", professorService.list());
    return "plist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/professor/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Profesores");
        model.addAttribute("professor", new Professor());
        return "pform";
    }

    @GetMapping("/professor/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Professor professor = null;
        if (id>0) {
            professor = professorService.getById(id);
        }else{
            return "redirect:plist";
        }

        model.addAttribute("title", "Editar Profesor");
        model.addAttribute("professor", professor);
        return "pform";
    }


    @PostMapping ("/professor/form")
    public String save(@Valid Professor professor, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de profesores");
            return "pform";
        }

        professorService.save(professor);
        return "redirect:/professor/list";
    }

    @GetMapping("/professor/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            professorService.delete(id);
        }
        return "redirect:/professor/list";
    }

}

