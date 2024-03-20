package mx.utng.s26.model.dao;

import java.util.List;

import mx.utng.s26.model.entity.Professor;


public interface IProfessorDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar profesores
    List<Professor> list();

    //Guardar un profesor
    void save(Professor professor);

    //Obterner un profesor en especifico a partir del id
    Professor getById(Long id);

    //Eliminar un profesor por el id
    void delete(Long id);
}
