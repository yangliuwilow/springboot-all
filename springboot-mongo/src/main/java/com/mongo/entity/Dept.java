package com.mongo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @description:
 * @author: willow
 * @time: 2019/9/13 21:18
 */
@Document(collection = "dept")
public class Dept implements Serializable {

    private  Integer id;
    private  String name;
    private  String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
