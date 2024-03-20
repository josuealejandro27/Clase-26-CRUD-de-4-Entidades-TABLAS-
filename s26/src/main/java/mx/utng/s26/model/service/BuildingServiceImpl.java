package mx.utng.s26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.s26.model.dao.IBuildingDao;
import mx.utng.s26.model.entity.Building;
/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class BuildingServiceImpl implements IBuildingService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IBuildingDao buildingDao;

    @Transactional(readOnly = true)
    @Override
    public List<Building> list() {
        return buildingDao.list();
    }

    @Transactional
    @Override
    public void save(Building building) {
        buildingDao.save(building);
    }

    @Transactional(readOnly = true)
    @Override
    public Building getById(Long id) {
        return buildingDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        buildingDao.delete(id);
    }
}
