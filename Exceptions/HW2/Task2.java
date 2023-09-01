package HW2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    public static void main(String [] args) {
        process();
    }
    public static void process(){
        int d = 0;
        int i = 0;
        int[] intArray = {8, 2, 4, 5, 6, 3, 5, 5, 7, 9};
        Boolean work = true;
        while (work){
            Scanner in = new Scanner(System.in);
            try {
                printArray(intArray);
                System.out.println("Введите порядковый номер значения, которе будем делить");
                i = in.nextInt();
                System.out.println("Введите делитель:");
                d = in.nextInt();
                double catchedRes1 = intArray[i - 1] / d;
                System.out.println("catchedRes1 = " + catchedRes1);
                work = false;
                in.close();
            }
            catch (ArithmeticException e) {
                System.out.println("Catching exception: " + e + " Попытка поделить на 0");
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Catching exception: " + e + " Выход за рамки массива");
            }
            catch (InputMismatchException e) {
                System.out.println("Catching exception: " + e + " Необходимо ввести число");
            }
        }
    }
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println("\n");
    }
}
