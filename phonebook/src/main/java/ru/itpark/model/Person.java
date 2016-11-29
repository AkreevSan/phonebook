package ru.itpark.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="person")
public class Person implements Serializable {
    private static final long serialVersionUID = 24112016L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name ='" + name + '\'' +
                ", address ='" + address + '\'' +
                ", phone ='" + phone + '\'' +
                '}';
    }



}