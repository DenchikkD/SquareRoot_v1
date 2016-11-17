package com.denni.webtest.repository;

import com.denni.webtest.domain.ResultRoot;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Onlin on 16.11.2016.
 */
@Repository
public class DAOResultRootImpl implements DAOResultRoot {

    @Autowired
    SessionFactory sessionFactory;

    public DAOResultRootImpl() {
    }

    @Override
    public void save(ResultRoot resultRoot) {
        sessionFactory.getCurrentSession().saveOrUpdate(resultRoot);
    }

    @Override
    public ResultRoot findByRootCoefAAndRootCoefBAndRootCoefC(Double coefA, Double coefB, Double coefC) {
        return (ResultRoot) sessionFactory.getCurrentSession().createCriteria(ResultRoot.class)
                .add(Restrictions.eq("coefA", coefA))
                .add(Restrictions.eq("coefB", coefB))
                .add(Restrictions.eq("coefC", coefC)).uniqueResult();
    }

    @Override
    public List<ResultRoot> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(ResultRoot.class)
        .addOrder(Order.desc("id")).list();
    }
}
