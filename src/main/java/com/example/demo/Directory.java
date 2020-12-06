package com.example.demo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name = "directory")
public class Directory {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    public int id;
    public String name;
    public String tel;
    public String email;
    public String address;
    public String QQ;

    public Directory(String name, String tel, String email, String address, String QQ) {
        this.name=name;
        this.tel=tel;
        this.email=email;
        this.address=address;
        this.QQ = QQ;
    }

    public Directory() {

    }
}
