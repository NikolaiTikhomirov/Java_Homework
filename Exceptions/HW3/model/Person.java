package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable, PersonListInterface{

    private String name;
    private LocalDate date;
    private Integer phone;
    private Gender gender;

    public Person(String name, LocalDate date, Integer phone, Gender gender){
        this.name = name;
        this.date = date;
        this.phone = phone;
        this.gender = gender;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public LocalDate getDate(){
        return date;
    }

    @Override
    public Integer getPhone(){
        return phone;
    }

    @Override
    public Gender getGender(){
        return gender;
    }


    public String toString() {
        String n = "";
        String d = "";
        String p = "";
        String g = "";
        if (name != null) n = this.getName();
        if (date != null) d = String.valueOf(this.getDate());
        if (phone != null) p = String.valueOf(this.getPhone());
        if (gender != null) g = String.valueOf(this.getGender());
        return "Имя: " + n + " Дата рождения: " + d + " телефон: " + p + " пол: " + g;
    }

    public String getInfo() {
        String n = "";
        String d = "";
        String p = "";
        String g = "";
        if (name != null) n = this.getName();
        if (date != null) d = String.valueOf(this.getDate());
        if (phone != null) p = String.valueOf(this.getPhone());
        if (gender != null) g = String.valueOf(this.getGender());
        return n + " " + d + " " + p + " " + g;
    }
}