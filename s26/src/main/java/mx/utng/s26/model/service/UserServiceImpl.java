package mx.utng.s26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.s26.model.dao.IUserDao;
import mx.utng.s26.model.entity.User;


/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class UserServiceImpl implements IUserService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IUserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public List<User> list() {
        return userDao.list();
    }

    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
    
}
