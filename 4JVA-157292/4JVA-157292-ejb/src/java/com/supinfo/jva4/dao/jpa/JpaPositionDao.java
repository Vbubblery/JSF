/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.jva4.dao.jpa;

import com.supinfo.entity.Car;
import com.supinfo.entity.Positon;
import com.supinfo.jva4.dao.PositionDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 15729_000
 */
@Stateless
public class JpaPositionDao implements PositionDao{
@PersistenceContext
    private EntityManager em;
    @Override
    public Positon AddNewPositon(Positon position) {
       em.persist(position);
       return position;
    }

    @Override
    public List<Positon> PositonOfCar(Car car) {
        return (List<Positon>) em.createQuery("select p from Positon p where p.car = :car").setParameter("car", car)
                .setHint("my-jpa-implementation.dont-query-grid", true).getResultList();
    }
    
}
