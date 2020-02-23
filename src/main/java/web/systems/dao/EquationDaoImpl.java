package web.systems.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.systems.entity.EquationEntity;

@Repository
public class EquationDaoImpl implements EquationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addEmployee(EquationEntity employee) {
        this.sessionFactory.getCurrentSession().save(employee);
    }
}