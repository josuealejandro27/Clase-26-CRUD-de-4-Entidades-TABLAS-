package mx.utng.s26.model.dao;

import java.util.List;

import mx.utng.s26.model.entity.User;

public interface IUserDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar usuarios
    List<User>list();

    //Guardar un usuario
    void save(User user);

    //Obterner un usuario en especifico a partir del id
    User getById(Long id);

    //Eliminar un usuario por el id
    void delete(Long id);
}
