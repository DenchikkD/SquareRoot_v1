package com.denni.webtest.controller.messages;

/**
 * Created by Onlin on 16.11.2016.
 */
public class ViewMessage {

    private Double coefA;
    private Double coefB;
    private Double coefC;
    private Double discriminant;
    private Double rootOne;
    private Double rootTwo;

    public ViewMessage() {
        this.discriminant = 0d;
        this.rootOne = 0d;
        this.rootTwo = 0d;
    }

    public Double getCoefA() {
        return coefA;
    }

    public void setCoefA(Double coefA) {
        this.coefA = coefA;
    }

    public Double getCoefB() {
        return coefB;
    }

    public void setCoefB(Double coefB) {
        this.coefB = coefB;
    }

    public Double getCoefC() {
        return coefC;
    }

    public void setCoefC(Double coefC) {
        this.coefC = coefC;
    }

    public Double getDiscriminant() {
        return discriminant;
    }

    public void setDiscriminant(Double discriminant) {
        this.discriminant = discriminant;
    }

    public Double getRootOne() {
        return rootOne;
    }

    public void setRootOne(Double rootOne) {
        this.rootOne = rootOne;
    }

    public Double getRootTwo() {
        return rootTwo;
    }

    public void setRootTwo(Double rootTwo) {
        this.rootTwo = rootTwo;
    }

    @Override
    public String toString() {
        return "ViewMessage{" +
                "coefA=" + coefA +
                ", coefB=" + coefB +
                ", coefC=" + coefC +
                ", discriminant=" + discriminant +
                ", rootOne=" + rootOne +
                ", rootTwo=" + rootTwo +
                '}';
    }
}
