/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.controller;

import com.supinfo.entity.Car;
import com.supinfo.entity.Customer;
import com.supinfo.service.CarService;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 15729_000
 */
@ManagedBean
@RequestScoped
public class NewCarController {
    @EJB
    CarService carService;
    private String name;
    private String brand;

    /**
     * Creates a new instance of NewCarController
     */
    public NewCarController() {
    }

    public String addNewCar() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Customer customer = (Customer) session.getAttribute("customer");
        Car car = new Car();
        car.setBrand(brand);
        car.setCustomer(customer);
        car.setFirstIntoService(new Date().getYear()+1900);
        car.setName(name);
        carService.NewCar(car);
        return "success";
    }

    public CarService getCarService() {
        return carService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
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

 
    
}
