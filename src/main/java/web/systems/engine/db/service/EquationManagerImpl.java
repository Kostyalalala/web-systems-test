package web.systems.engine.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.systems.engine.db.dao.EquationDAO;
import web.systems.engine.db.entity.EquationEntity;

@Service
public class EquationManagerImpl implements EquationManager {

    @Autowired
    private EquationDAO equationDAO;

    @Override
    @Transactional
    public void addEquation(EquationEntity equationEntity) {
        equationDAO.addEquation(equationEntity);
    }

    @Override
    @Transactional
    public EquationEntity getById(Integer id) {
        EquationEntity equationEntity = equationDAO.getById(id);
        return equationEntity;
    }
}
