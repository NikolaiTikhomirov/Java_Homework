package model.fileHandler;

import model.Person;

public interface PersonWritable {
    void save(Person person);
    Object read(Person person);
}
