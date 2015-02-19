/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.controller;

import com.supinfo.entity.Car;
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
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author 15729_000
 */
@ManagedBean
@RequestScoped
public class DetailCarController {

    @EJB
    PositionService positionService;
    @EJB
    CarService carService;
    private DataModel positionModel = new ListDataModel();

    /**
     * Creates a new instance of DetailCarController
     */
    public DetailCarController() {
    }

    public DataModel getPositionModel() {
        positionModel.setWrappedData(getPositions());
        return positionModel;
    }

    public void setPositionModel(DataModel positionModel) {
        this.positionModel = positionModel;
    }

    public List<Positon> getPositions() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Long id = Long.parseLong(request.getParameter("id"));
        Car car = carService.FindTheCar(id);
        List<Positon> positions = positionService.PositionOfCar(car);
        int num = positions.size();
        if (num > 10)
            positions = positions.subList(num - 10, num);
        return positions;
    }
}
