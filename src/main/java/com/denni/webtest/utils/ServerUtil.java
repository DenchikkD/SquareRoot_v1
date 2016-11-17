package com.denni.webtest.utils;

import com.denni.webtest.controller.messages.ViewMessage;
import org.springframework.stereotype.Component;

/**
 * Created by Onlin on 16.11.2016.
 */
@Component
public class ServerUtil {

    public ServerUtil() {
    }

    public ViewMessage calculateRoots(ViewMessage viewMessage) {
        calculateDiscriminant(viewMessage);
        if (viewMessage.getDiscriminant() < 0) {
            return viewMessage;
        } else {
            if (viewMessage.getDiscriminant().equals(0)) {
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
