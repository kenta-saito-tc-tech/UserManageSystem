package com.example.usermanagesystem;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
    private IntegerProperty id;
    private StringProperty company;
    private StringProperty name;
    private IntegerProperty score;

    public Person(int anId, String aCompany, String aName, int aScore) {
        id = new SimpleIntegerProperty(anId);
        company = new SimpleStringProperty(aCompany);
        name = new SimpleStringProperty(aName);
        score = new SimpleIntegerProperty(aScore);
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public void setCompany(String company) {
        this.company.set(company);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setScore(int score) {
        this.score.set(score);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty companyProperty() {
        return company;
    }

    public IntegerProperty scoreProperty() {
        return score;
    }

    public void deleteAll(){
        id.setValue(null);
        company.setValue(null);
        name.setValue(null);
        score.setValue(null);
    }


}
