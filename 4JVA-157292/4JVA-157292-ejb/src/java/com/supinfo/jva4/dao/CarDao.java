/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.jva4.dao;

import com.supinfo.entity.Car;
import com.supinfo.entity.Customer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 15729_000
 */
@Local
public interface CarDao {
    public Car AddCar(Car car);
    public List<Car> AllCars();
    public List<Car> CustomerCars(Customer customer);
    public void RemoveCar(Car car);
    public Car FindTheCar(Long id);
    public void UpdateCar(Car car);
}
