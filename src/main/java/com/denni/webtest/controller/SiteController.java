package com.denni.webtest.controller;

/**
 * Created by Onlin on 15.11.2016.
 */

import com.denni.webtest.controller.messages.ViewMessage;
import com.denni.webtest.domain.ResultRoot;
import com.denni.webtest.service.SiteService;
import com.denni.webtest.utils.ServerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class SiteController extends DispatcherServlet {
    private static final String INDEX_PAGE = "../../index";
    private static final String ROOTS_PAGE = "rootsPage";

    @Autowired
    SiteService siteService;

    @Autowired
    ServerUtil serverUtil;

    public SiteController() {
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public ModelAndView calculate(ModelAndView model, ViewMessage viewMessage) {
        String modelView = ROOTS_PAGE;
        modelView = checkCoefficients(model, modelView, viewMessage);
        if (modelView.equals(ROOTS_PAGE)) {
            ResultRoot resultRoot = siteService.findByRootCoefAAndRootCoefBAndRootCoefC(viewMessage.getCoefA(), viewMessage.getCoefB(), viewMessage.getCoefC());
            if (resultRoot == null) {
                serverUtil.calculateRoots(viewMessage);
                if (viewMessage.getDiscriminant() < 0) {
                    model.addObject("no_roots", "No Roots");
                }else {
                    siteService.save(new ResultRoot(viewMessage));
                    model.addObject("result_root", viewMessage);
                }
            } else {
                model.addObject("result_root", resultRoot);
            }
            model.addObject("all_root", siteService.findAll());
        }
        model.setViewName(modelView);
        return model;
    }

    private String checkCoefficients(ModelAndView model, String modelView, ViewMessage viewMessage) {
        if (viewMessage.getCoefA()==null||!serverUtil.checkParameter(viewMessage.getCoefA(),ServerUtil.PUTTERN_OF_COEFFICIENT)) {
            modelView = INDEX_PAGE;
            model.addObject("response_message", "Enter a value for the specified format");
        }
        if (viewMessage.getCoefB()==null||!serverUtil.checkParameterWithZero(viewMessage.getCoefB(),ServerUtil.PUTTERN_OF_COEFFICIENT)) {
            modelView = INDEX_PAGE;
            model.addObject("response_message", "Enter a value for the specified format");
        }
        if (viewMessage.getCoefC()==null||!serverUtil.checkParameterWithZero(viewMessage.getCoefC(),ServerUtil.PUTTERN_OF_COEFFICIENT)) {
            modelView = INDEX_PAGE;
            model.addObject("response_message", "Enter a value for the specified format");
        }
        return modelView;
    }


}

