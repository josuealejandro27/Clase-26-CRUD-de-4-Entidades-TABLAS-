package mx.utng.s26.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.s26.model.entity.Professor;

@Repository
public class ProfessorDaoImpl implements IProfessorDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Professor> list() {
        return em.createQuery("from Professor").getResultList();
    }

    @Override
    public void save(Professor professor) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(professor.getId() != null && professor.getId()>0){
            em.merge(professor);
        }else{
            //Registro nuevo al usar persist
            em.persist(professor);
        }
    }

    @Override
    public Professor getById(Long id) {
        return em.find(Professor.class, id);
    }

    @Override
    public void delete(Long id) {
      Professor professor = getById(id);
      em.remove(professor);
    }
    

}