import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // Приложение, которое:
        // Принимает от пользователя и запоминает строки
        // Если пользователь ввел print, то выводим все предыдущие строки в обратном порядке
        // Если введено revert, то удаляем последнюю введеную строку
        // Если введено exit, то завершаем программу

        // java
        // c++
        // python
        // c#
        // print
        // < [c#, python, c++, java]
        // revert
        // print
        // < [python, c++, java]
        // exit

        Scanner sc = new Scanner(System.in);
        List<String> storage = new LinkedList<>();
        String input;
        root: while (!(input = sc.nextLine()).equals("exit")) {
            String userInter = input;
            if ("revert".equals(userInter)){
                if (storage.size() < 1){
                    System.out.println("It's empty");
                    continue root;
                }
                storage.remove(storage.size() - 1);
            }
            else if ("reverse".equals(userInter)) Collections.reverse(storage);
            else if ("print".equals(userInter)) {
                // Вывод строкой, но, вероятно, это будет ресурсозатратно, при больших объемах
                // List<String> newStorage = new LinkedList<>(storage);
                // Collections.reverse(newStorage);
                // System.out.println(newStorage);

                // Вывод поэлементно, но работать будет быстрее
                ListIterator<String> listIterator = storage.listIterator(storage.size());
                while (listIterator.hasPrevious()) System.out.println(listIterator.previous());
            }
            else storage.add(input);
        }
    }
}
