package web.systems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.systems.dao.EquationDAO;
import web.systems.entity.EquationEntity;

@Service
public class EquationManagerImpl implements EquationManager {

    @Autowired
    private EquationDAO employeeDAO;

    @Override
    @Transactional
    public void addEmployee(EquationEntity employee) {
        employeeDAO.addEmployee(employee);
    }

    public void setEmployeeDAO(EquationDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
}
