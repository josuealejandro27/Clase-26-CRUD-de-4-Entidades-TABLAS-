package mx.utng.s26.model.dao;

import java.util.List;

import mx.utng.s26.model.entity.Building;


public interface IBuildingDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Building> list();

    //Guardar un estudiante
    void save(Building building);

    //Obterner un estudiante en especifico a partir del id
    Building getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}
