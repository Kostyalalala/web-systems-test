package web.systems.engine.db.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.systems.engine.db.entity.EquationEntity;

@Repository
public class EquationDaoImpl implements EquationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addEquation(EquationEntity equationEntity) {
        this.sessionFactory.getCurrentSession().save(equationEntity);
        this.sessionFactory.getCurrentSession().flush();
    }

    @Override
    public EquationEntity getById(Integer id) {
        return (EquationEntity) sessionFactory.getCurrentSession().load(EquationEntity.class, id);
    }
}