package model;

import java.time.LocalDate;

import model.fileHandler.PersonWritable;
import model.fileHandler.Writable;

public class Model {
    private PersonList<String, Person> personList;
    private String personListPath;
    private Writable writable;
    PersonWritable personWritable;

    public Model(Writable writable, PersonWritable personWritable) {
        personListPath = "Exceptions/HW3/model/personList.txt";
        this.writable = writable;
        this.personWritable = personWritable;
        personList = (PersonList<String, Person>) writable.read(personListPath);
    }

    public void addPerson(String name, LocalDate date, Integer phone, Gender gender) {
        Person person = new Person(name, date, phone, gender);
        personList.addPerson(person);
        personWritable.save(person);
    }

    public String getPersonList() {
        return personList.getInfo();
    }

    public void saveChanges() {
        writable.save(personList, personListPath);
    }

}
