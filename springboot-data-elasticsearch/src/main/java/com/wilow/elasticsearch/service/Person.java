package com.wilow.elasticsearch.service;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

//需要注释es的索引和类型
@Document(indexName = "elastic_search_project",type ="person" )
public class Person  implements Serializable  {

    public Integer id;
    public String name;
    public String phone;
    public String address;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
