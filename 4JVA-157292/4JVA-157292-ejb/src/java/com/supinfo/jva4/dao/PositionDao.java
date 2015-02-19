/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.jva4.dao;

import com.supinfo.entity.Car;
import com.supinfo.entity.Positon;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 15729_000
 */
@Local
public interface PositionDao {
    public Positon AddNewPositon(Positon position);
    public List<Positon> PositonOfCar(Car car);
    
}
