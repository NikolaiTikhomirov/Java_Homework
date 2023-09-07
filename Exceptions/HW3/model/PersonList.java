package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import model.PersonList;

public class PersonList<String, T extends PersonListInterface> implements Serializable, Iterable<T>{
    private HashMap<String, Person> personList;

    public PersonList(){
        personList = new HashMap<String, Person>();
    }

    public void addPerson(Person person){
        if (personList.containsKey(person.getName())){
            // person.setQuantity(person.getQuantity() + personList.get(person.getName()).getQuantity());
            // personList.put((String) person.getName(), person);
        }
        else{
            personList.put((String) person.getName(), person);
        }
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for (var pair: personList.entrySet()) {
            stringBuilder.append(pair.getValue());
            stringBuilder.append("\n");
        }
        return (String) stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return ((Iterable<T>) personList).iterator();
    }

    public Person getPerson(String name){
        return personList.get(name);
    }

    public Collection<Person> getValues(){
        return personList.values();
    }

    public void removePerson(String name){
        personList.remove(name);
    }

    public Integer size(){
        return personList.size();
    }
}
