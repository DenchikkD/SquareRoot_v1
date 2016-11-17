package com.denni.webtest.service;

import com.denni.webtest.domain.ResultRoot;
import com.denni.webtest.repository.DAOResultRoot;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Onlin on 16.11.2016.
 */
@Service

public class SiteServiceImpl implements SiteService {

    public SiteServiceImpl() {
    }

    @Autowired
    DAOResultRoot daoResultRoot;

    @Transactional
    @Override
    public void save(ResultRoot resultRoot) {
        daoResultRoot.save(resultRoot);
    }

    @Transactional(readOnly = true)
    @Override
    public ResultRoot findByRootCoefAAndRootCoefBAndRootCoefC(Double coefA, Double coefB, Double coefC) {
        return daoResultRoot.findByRootCoefAAndRootCoefBAndRootCoefC(coefA, coefB, coefC);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ResultRoot> findAll() {
        return daoResultRoot.findAll();
    }
}
