package model.fileHandler;

import java.io.FileReader;
import java.io.FileWriter;
import model.Person;

public class PersonFileHandler implements PersonWritable{
    private String personFileDir = "Exceptions/HW3/model/";

    @Override
    public void save(Person person) {
        try (FileWriter fileWriter = new FileWriter(personFileDir + person.getName().substring(0, person.getName().indexOf(' ')) + ".txt", true)){
            fileWriter.append(person.getInfo() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Сохранить не удалось");
        }
    }

    @Override
    public Object read(Person person) {
        try (FileReader fileReader = new FileReader(personFileDir + person.getName().substring(0, person.getName().indexOf(' ')) + ".txt");){
            return fileReader.toString();
        } catch (Exception e) {
            PersonFileHandler writable = new PersonFileHandler();
            writable.save(person);
            return person;
        }
    }
}
