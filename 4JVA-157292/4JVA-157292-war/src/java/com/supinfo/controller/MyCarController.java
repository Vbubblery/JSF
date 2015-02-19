/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.controller;

import com.supinfo.entity.Car;
import com.supinfo.entity.Customer;
import com.supinfo.entity.Positon;
import com.supinfo.service.CarService;
import com.supinfo.service.PositionService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 15729_000
 */
@ManagedBean
@RequestScoped
public class MyCarController {

    @EJB
    CarService carService;
    @EJB
    PositionService positionService;
    private DataModel carModel = new ListDataModel();
    private float lng;
    private float lat;

    /**
     * Creates a new instance of MyCarController
     */
    public MyCarController() {
    }

    public void removeCar() {
        carService.RemoveCar((Car) carModel.getRowData());
    }

    public List<Car> getCars() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Customer c = (Customer) session.getAttribute("customer");
        return carService.CustomerCar(c);
    }

    public String upDateGps() {
        Car car = (Car) carModel.getRowData();
        Positon p = new Positon();
        car.setX(lng);
        car.setY(lat);      
        carService.UpdateCar(car);
        p.setX(lng);
        p.setY(lat);
        p.setCar(car);
        positionService.AddNewPosition(p);
        return "success";
    }

    public DataModel getCarModel() {
        carModel.setWrappedData(getCars());
        return carModel;
    }

    public void setCarModel(DataModel carModel) {
        this.carModel = carModel;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }
    
}
