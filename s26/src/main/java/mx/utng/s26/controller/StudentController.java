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
import mx.utng.s26.model.entity.Student;
import mx.utng.s26.model.service.IStudentService;

@Controller
@SessionAttributes("student")
public class StudentController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IStudentService studentService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/student/list","/student","/student/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Estudiantes");
    model.addAttribute("students", studentService.list());
    return "slist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/student/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Estudiantes");
        model.addAttribute("student", new Student());
        return "sform";
    }

    @GetMapping("/student/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Student student = null;
        if (id>0) {
            student = studentService.getById(id);
        }else{
            return "redirect:slist";
        }

        model.addAttribute("title", "Editar Estudiante");
        model.addAttribute("student", student);
        return "sform";
    }


    @PostMapping ("/student/form")
    public String save(@Valid Student student, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Estudiantes");
            return "sform";
        }

        studentService.save(student);
        return "redirect:/student/list";
    }

    @GetMapping("/student/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            studentService.delete(id);
        }
        return "redirect:/student/list";
    }

}

