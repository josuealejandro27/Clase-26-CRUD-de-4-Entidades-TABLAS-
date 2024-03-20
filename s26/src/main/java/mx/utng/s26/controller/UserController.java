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
import mx.utng.s26.model.entity.User;
import mx.utng.s26.model.service.IUserService;

@Controller
@SessionAttributes("user")
public class UserController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IUserService userService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"", "/", "/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Usuarios");
    model.addAttribute("users", userService.list());
    return "list";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Usuarios");
        model.addAttribute("user", new User());
        return "form";
    }

    @GetMapping("/form/{id}")
    public String update(@PathVariable Long id,Model model){
        User user = null;
        if (id>0) {
            user = userService.getById(id);
        }else{
            return "redirect:list";
        }

        model.addAttribute("title", "Editar Usuario");
        model.addAttribute("user", user);
        return "form";
    }


    @PostMapping ("/form")
    public String save(@Valid User user, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de usuarios");
            return "form";
        }

        userService.save(user);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            userService.delete(id);
        }
        return "redirect:/list";
    }

}

