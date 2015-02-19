/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.controller;

import com.supinfo.entity.Car;
import com.supinfo.entity.Customer;
import com.supinfo.service.CarService;
import com.supinfo.service.CustomerService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author 15729_000
 */
@ManagedBean
@RequestScoped
public class IndexController {
@EJB
CustomerService customerService;
@EJB
CarService carService;
private int numberCustomer;
private int numberCar;
    /**
     * Creates a new instance of IndexController
     */
    public IndexController() {
    }
    public void init(){
        List<Customer> customers = customerService.retrieveAllCustomers();
        this.numberCustomer = customers.size();
        List<Car> cars = carService.AllCars();
        this.numberCar = cars.size();
    }

    public int getNumberCustomer() {
        return numberCustomer;
    }

    public void setNumberCustomer(int numberCustomer) {
        this.numberCustomer = numberCustomer;
    }

    public int getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(int numberCar) {
        this.numberCar = numberCar;
    }
    
}
