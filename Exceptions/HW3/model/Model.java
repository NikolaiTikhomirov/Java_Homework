package model;

import java.time.LocalDate;

import model.fileHandler.Writable;

public class Model {
    private PersonList<String, Person> personList;
    private String personListPath;
    private Writable writable;

    public Model(Writable writable) {
        personListPath = "Exceptions/HW3/model/personList.txt";
        this.writable = writable;
        personList = (PersonList<String, Person>) writable.read(personListPath);
    }

    public void addPerson(String name, LocalDate date, Integer phone, Gender gender) {
        Person person = new Person(name, date, phone, gender);
        personList.addPerson(person);
    }

    public String getPersonList() {
        return personList.getInfo();
    }

    public void saveChanges() {
        writable.save(personList, personListPath);
    }

}
