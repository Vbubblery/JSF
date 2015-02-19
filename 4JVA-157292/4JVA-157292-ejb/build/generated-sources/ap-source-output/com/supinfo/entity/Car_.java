package com.supinfo.entity;

import com.supinfo.entity.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-20T01:15:36")
@StaticMetamodel(Car.class)
public class Car_ { 

    public static volatile SingularAttribute<Car, Long> id;
    public static volatile SingularAttribute<Car, String> name;
    public static volatile SingularAttribute<Car, String> brand;
    public static volatile SingularAttribute<Car, Integer> firstIntoService;
    public static volatile SingularAttribute<Car, Customer> customer;
    public static volatile SingularAttribute<Car, Float> y;
    public static volatile SingularAttribute<Car, Float> x;

}