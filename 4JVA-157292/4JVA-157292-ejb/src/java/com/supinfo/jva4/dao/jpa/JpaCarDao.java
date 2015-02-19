/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.jva4.dao.jpa;

import com.supinfo.entity.Car;
import com.supinfo.entity.Customer;
import com.supinfo.entity.Positon;
import com.supinfo.jva4.dao.CarDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 15729_000
 */
@Stateless
public class JpaCarDao implements CarDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Car AddCar(Car car) {
        em.persist(car);
        return car;
    }

    @Override
    public List<Car> AllCars() {
        return (List<Car>) em.createQuery("select c from Car c ")
                .setHint("my-jpa-implementation.dont-query-grid", true).getResultList();
    }

    @Override
    public List<Car> CustomerCars(Customer customer) {
        return (List<Car>) em.createQuery("select c from Car c where c.customer = :customer").setParameter("customer", customer)
                .setHint("my-jpa-implementation.dont-query-grid", true).getResultList();
    }

    @Override
    public void RemoveCar(Car car) {
        Car c = em.merge(car);
        List<Positon> ps = em.createQuery("select p from Positon p where p.car = :car")
                .setParameter("car", car).setHint("my-jpa-implementation.dont-query-grid", true).getResultList();
        for (Positon p : ps) {
            em.remove(p);
        }
        em.remove(c);
    }

    @Override
    public Car FindTheCar(Long id) {
        return em.find(Car.class, id);
    }

    @Override
    public void UpdateCar(Car car) {
        em.merge(car);
    }
}
