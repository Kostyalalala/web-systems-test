package web.systems.engine.DB.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.systems.engine.DB.entity.EquationEntity;

@Repository
public class EquationDaoImpl implements EquationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addEquation(EquationEntity equationEntity) {
        this.sessionFactory.getCurrentSession().save(equationEntity);
    }
}