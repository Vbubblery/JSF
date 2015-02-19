/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.service;

import com.supinfo.entity.Car;
import com.supinfo.entity.Positon;
import com.supinfo.jva4.dao.PositionDao;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 15729_000
 */
@Stateless
public class PositionService {
    @EJB
    PositionDao positionDao;
    public Positon AddNewPosition(Positon position)
    {
        return positionDao.AddNewPositon(position);
    }
    public List<Positon> PositionOfCar(Car car)
    {
        return positionDao.PositonOfCar(car);
    }
}
