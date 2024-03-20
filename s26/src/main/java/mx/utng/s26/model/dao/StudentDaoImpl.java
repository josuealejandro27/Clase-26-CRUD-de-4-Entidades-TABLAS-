package mx.utng.s26.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.s26.model.entity.Student;

@Repository
public class StudentDaoImpl implements IStudentDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> list() {
        return em.createQuery("from Student").getResultList();
    }

    @Override
    public void save(Student student) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(student.getId() != null && student.getId()>0){
            em.merge(student);
        }else{
            //Registro nuevo al usar persist
            em.persist(student);
        }
    }

    @Override
    public Student getById(Long id) {
        return em.find(Student.class, id);
    }

    @Override
    public void delete(Long id) {
      Student student = getById(id);
      em.remove(student);
    }
    

}