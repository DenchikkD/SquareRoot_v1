package com.denni.webtest.utils;

import com.denni.webtest.controller.messages.ViewMessage;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Onlin on 16.11.2016.
 */
@Component
public class ServerUtil {
    public static final Pattern PUTTERN_OF_COEFFICIENT = Pattern.compile("^-?[0-9]{1,3}\\.[0-9]{0,17}$");

    public ServerUtil() {
    }

    public boolean checkParameter(Double parameter, Pattern pattern) {
        if (parameter.equals(0.0)) {
            return false;
        } else {
            return pattern.matcher(String.valueOf(parameter)).matches();
        }
    }
    public boolean checkParameterWithZero(Double parameter, Pattern pattern) {
            return pattern.matcher(String.valueOf(parameter)).matches();
    }

    public ViewMessage calculateRoots(ViewMessage viewMessage) {
        calculateDiscriminant(viewMessage);
        System.out.println(viewMessage.getDiscriminant());
        if (viewMessage.getDiscriminant() < 0) {
            return viewMessage;
        } else {
            if (viewMessage.getDiscriminant().equals(0.0)) {
                calculateRootsIfDiscriminantEqualsZero(viewMessage);
            } else {
                calculateRootsIfDiscriminantGreaterThanZero(viewMessage);
            }
        }
        return viewMessage;
    }

    private ViewMessage calculateDiscriminant(ViewMessage viewMessage) {
        viewMessage.setDiscriminant(Math.pow(viewMessage.getCoefB(), 2)
                - 4 * viewMessage.getCoefA() * viewMessage.getCoefC());
        return viewMessage;
    }

    private ViewMessage calculateRootsIfDiscriminantEqualsZero(ViewMessage viewMessage) {
        viewMessage.setRootOne(-viewMessage.getCoefB() / (2 * viewMessage.getCoefA()));
        viewMessage.setRootTwo(viewMessage.getRootOne());
        return viewMessage;
    }

    private ViewMessage calculateRootsIfDiscriminantGreaterThanZero(ViewMessage viewMessage) {
        System.out.println(Math.sqrt(viewMessage.getDiscriminant()));
        System.out.println((-viewMessage.getCoefB() + Math.sqrt(viewMessage.getDiscriminant())));

        viewMessage.setRootOne((-viewMessage.getCoefB() + Math.sqrt(viewMessage.getDiscriminant())) /
                (2 * viewMessage.getCoefA()));

        viewMessage.setRootTwo((-viewMessage.getCoefB() - Math.sqrt(viewMessage.getDiscriminant())) /
                (2 * viewMessage.getCoefA()));

        return viewMessage;
    }
}
