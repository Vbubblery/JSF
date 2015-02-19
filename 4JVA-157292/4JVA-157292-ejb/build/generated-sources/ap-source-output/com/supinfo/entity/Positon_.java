package com.supinfo.entity;

import com.supinfo.entity.Car;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-20T01:15:36")
@StaticMetamodel(Positon.class)
public class Positon_ { 

    public static volatile SingularAttribute<Positon, Long> id;
    public static volatile SingularAttribute<Positon, Car> car;
    public static volatile SingularAttribute<Positon, Float> y;
    public static volatile SingularAttribute<Positon, Float> x;

}