package mx.utng.s26.model.dao;

import java.util.List;

import mx.utng.s26.model.entity.Student;


public interface IStudentDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Student> list();

    //Guardar un estudiante
    void save(Student student);

    //Obterner un estudiante en especifico a partir del id
    Student getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}
