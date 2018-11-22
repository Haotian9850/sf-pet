package com.haotian9850.sfpetclinic.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass   //base class to JPA, will be inherited by other classes
public class BaseEntity implements Serializable {

    @Id //auto-increment field in MySQL
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //box type of long: recommended for Hibernate usage


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
