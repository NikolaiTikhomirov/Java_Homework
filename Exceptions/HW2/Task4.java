package HW2;

import java.util.Scanner;

public class Task4 {
    public static void main (String [] args) {
        System.out.println(userInput());
    }
    public static String userInput() {
        String res = "";
        root: while (res.equals("")){
            Scanner in = new Scanner(System.in);
            try {
                System.out.println("Напишите что-нибудь");
                res = in.nextLine();
                if (res.equals("")){
                    System.out.println("Строка не должна быть пустой");
                    continue root;
                }
                in.close();
            } catch (Exception e) {
                System.out.println("Что-то пошло не так");
            }
        }
        return res;
    }
}
