package mx.utng.s26.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.s26.model.entity.Building;

@Repository
public class BuildingDaoImpl implements IBuildingDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Building> list() {
        return em.createQuery("from Building").getResultList();
    }

    @Override
    public void save(Building building) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(building.getId() != null && building.getId()>0){
            em.merge(building);
        }else{
            //Registro nuevo al usar persist
            em.persist(building);
        }
    }

    @Override
    public Building getById(Long id) {
        return em.find(Building.class, id);
    }

    @Override
    public void delete(Long id) {
      Building building = getById(id);
      em.remove(building);
    }
    

}