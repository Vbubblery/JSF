/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.service;

import com.supinfo.entity.Car;
import com.supinfo.entity.Customer;
import com.supinfo.jva4.dao.CarDao;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 15729_000
 */
@Stateless
public class CarService {
    @EJB
    CarDao carDao;
    public Car NewCar(Car car)
    {
        return carDao.AddCar(car);
    }
    public List<Car> AllCars()
    {
        return carDao.AllCars();
    }
    public List<Car> CustomerCar(Customer customer)
    {
        return carDao.CustomerCars(customer);
    }
    public void RemoveCar(Car car)
    {
        carDao.RemoveCar(car);
    }
    public Car FindTheCar(Long id)
    {
        return carDao.FindTheCar(id);
    }
    public void UpdateCar(Car car)
    {
        carDao.UpdateCar(car);
    }
}
