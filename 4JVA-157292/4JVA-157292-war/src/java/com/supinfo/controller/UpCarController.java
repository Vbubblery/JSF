/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.controller;

import com.supinfo.entity.Car;
import com.supinfo.service.CarService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author 15729_000
 */
@ManagedBean
@RequestScoped
public class UpCarController {

    @EJB
    CarService carService;
    private Long id;
    private String name;
    private String brand;

    /**
     * Creates a new instance of UpCarController
     */
    public UpCarController() {

    }
    public void init()
    {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Car car = carService.FindTheCar(Long.parseLong(request.getParameter("item")));
        this.id = car.getId();
        this.name = car.getName();
        this.brand = car.getBrand();
    }
    public String updateCar() {
        Car car = carService.FindTheCar(this.id);
        car.setName(this.name);
        car.setBrand(this.brand);
        carService.UpdateCar(car);
        return "success";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
