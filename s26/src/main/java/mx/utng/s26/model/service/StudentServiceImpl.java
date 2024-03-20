package mx.utng.s26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.s26.model.dao.IStudentDao;
import mx.utng.s26.model.entity.Student;
/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class StudentServiceImpl implements IStudentService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IStudentDao studentDao;

    @Transactional(readOnly = true)
    @Override
    public List<Student> list() {
        return studentDao.list();
    }

    @Transactional
    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Transactional(readOnly = true)
    @Override
    public Student getById(Long id) {
        return studentDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        studentDao.delete(id);
    }
    
}
