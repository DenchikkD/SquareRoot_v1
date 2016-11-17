package com.denni.webtest.domain;

import com.denni.webtest.controller.messages.ViewMessage;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Onlin on 15.11.2016.
 */
@Entity
@Table(name = "root")
public class ResultRoot {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "coefA")
    private Double coefA;

    @Column(name = "coefB")
    private Double coefB;

    @Column(name = "coefC")
    private Double coefC;

    @Column(name = "rootOne")
    private Double rootOne;

    @Column(name = "rootTwo")
    private Double rootTwo;

    public ResultRoot() {
    }

    public ResultRoot(Double coefA, Double coefB, Double coefC, Double rootOne, Double rootTwo) {
        this.coefA = coefA;
        this.coefB = coefB;
        this.coefC = coefC;
        this.rootOne = rootOne;
        this.rootTwo = rootTwo;
    }

    public ResultRoot(@NotNull ViewMessage viewMessage) {
        this.coefA = viewMessage.getCoefA();
        this.coefB = viewMessage.getCoefB();
        this.coefC = viewMessage.getCoefC();
        this.rootOne = viewMessage.getRootOne();
        this.rootTwo = viewMessage.getRootTwo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "ResultRoot{" +
                "id=" + id +
                ", coefA=" + coefA +
                ", coefB=" + coefB +
                ", coefC=" + coefC +
                ", rootOne=" + rootOne +
                ", rootTwo=" + rootTwo +
                '}';
    }
}
