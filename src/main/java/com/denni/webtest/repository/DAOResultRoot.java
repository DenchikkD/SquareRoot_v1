package com.denni.webtest.repository;

import com.denni.webtest.domain.ResultRoot;

import java.util.List;

/**
 * Created by Onlin on 16.11.2016.
 */
public interface DAOResultRoot {

    void save(ResultRoot resultRoot);

    ResultRoot findByRootCoefAAndRootCoefBAndRootCoefC(Double coefA, Double coefB, Double coefC);

    List<ResultRoot> findAll();

}
