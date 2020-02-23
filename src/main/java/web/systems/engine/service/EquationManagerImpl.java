package web.systems.engine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.systems.engine.DB.dao.EquationDAO;
import web.systems.engine.DB.entity.EquationEntity;

@Service
public class EquationManagerImpl implements EquationManager {

    @Autowired
    private EquationDAO equationDAO;

    @Override
    @Transactional
    public void addEquation(EquationEntity equationEntity) {
        equationDAO.addEquation(equationEntity);
    }

    public void setEmployeeDAO(EquationDAO equationDAO) {
        this.equationDAO = equationDAO;
    }
}
