package ru.geekbrains.lesson3;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Task1 {

    /**
     *     1.  Создайте класс исключения, который будет выбрасываться при делении на
     *         0. Исключение должно отображать понятное для пользователя сообщение
     *         об ошибке.
     *     2.  Создайте класс исключений, которое будет возникать при обращении к
     *         пустому элементу в массиве ссылочного типа. Исключение должно
     *         отображать понятное для пользователя сообщение об ошибке
     *     3.  Создайте класс исключения, которое будет возникать при попытке открыть
     *         несуществующий файл. Исключение должно отображать понятное для
     *         пользователя сообщение об ошибке.
     *
     *     4.* Продемонстрировать работу каждого исключения.
     */


    public static void main(String[] args) {

        try {
            test1();
        }
        catch (DivisionByZeroException e){
            System.out.println(e.getMessage());
        }

        try
        {
            test2(new String[] {"AA", "BB", null, "DD"}, 2);
        }
        catch (NullElementArrayException e){
            System.out.printf("%s по индексу %d\n", e.getMessage(), e.getIndex());
        }

        try {
            test3("D:/AAA/AA.txt");
        }
        catch (MyFileNotFoundException e){
            System.out.printf("%s\nНаименование файла: %s\n", e.getMessage(), e.getFileName());
        }

    }

    static void test1(){
        try {
            int a = 10 / 0;
        }
        catch (ArithmeticException e){
            throw new DivisionByZeroException("Ошибка деления числа на 0.");
        }
    }

    static void test2(String[] array, int index){
        try {
            if (array[index] == null)
                throw new NullElementArrayException("Элемент массива не проинициализирован", index);
            System.out.printf("Значение элемента массива: %s\n", array[index]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    static void test3(String fileName) throws MyFileNotFoundException{
        try
        {
            FileReader fileReader = new FileReader(fileName);
        }
        catch (FileNotFoundException e){
            throw new MyFileNotFoundException("Файл не найден", fileName);
        }

    }

}

class NullElementArrayException extends NullPointerException{

    private final int index;

    public int getIndex() {
        return index;
    }

    public NullElementArrayException(String s, int index) {
        super(s);
        this.index = index;
    }
}

class DivisionByZeroException extends ArithmeticException{

    public DivisionByZeroException(String s) {
        super(s);
    }
}

class MyFileNotFoundException extends Exception{

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public MyFileNotFoundException(String message, String fileName) {
        super(message);
        this.fileName = fileName;
    }
}
















