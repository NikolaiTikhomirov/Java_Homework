package HW2;

import java.util.Scanner;

public class Task1{

    // Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
    // и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, 
    // вместо этого, необходимо повторно запросить у пользователя ввод данных.

    public static void main (String [] args) {
        System.out.println(userInput());
    }
    public static float userInput() {
        float res = 0;
        Boolean work = true;
        while (work){
            Scanner in = new Scanner(System.in);
            try {
                System.out.println("Введите число");
                res = in.nextFloat();
                work = false;
                in.close();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Вы ввели не корректные данные");
            }
        }
        return res;
    }

}