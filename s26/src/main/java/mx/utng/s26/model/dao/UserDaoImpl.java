package mx.utng.s26.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.s26.model.entity.User;

@Repository
public class UserDaoImpl implements IUserDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<User> list() {
        return em.createQuery("from User").getResultList();
    }

    @Override
    public void save(User user) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(user.getId() != null && user.getId()>0){
            em.merge(user);
        }else{
            //Registro nuevo al usar persist
            em.persist(user);
        }
    }

    @Override
    public User getById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void delete(Long id) {
      User user = getById(id);
      em.remove(user);
    }
    

}