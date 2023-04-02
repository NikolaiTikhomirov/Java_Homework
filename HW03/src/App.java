import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.Integer;


public class App {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("2");
        strings.add("string");
        strings.add("40");
        strings.add("-5");
        strings.add("my_string");
        strings.add("4");
        strings.add("-7");
        System.out.println(strings);
        System.out.println(removeEvenNumber(strings)); // [string, -5, my_string, -7]
        System.out.println(removeIntegers(strings)); // [string, my_string]
    }
    
    static List<String> removeEvenNumber(List<String> numbers) {
        // TODO: 31.03.2023 Удалить все четные элементы из списка
        Iterator<String> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            try {
                if (Integer.parseInt(next) % 2 == 0) iterator.remove();
            } catch (NumberFormatException e) {}
        }
        return numbers;
    }
    
    
    static List<String> removeIntegers(List<String> stringsOnly) {
        // TODO: 31.03.2023 Удалить строки, которые являются целыми числами
        Iterator<String> iterator = stringsOnly.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            try {
                Object a = Integer.parseInt(next);
                if (a instanceof Integer) iterator.remove();
            } catch (NumberFormatException e) {}
        }
        return stringsOnly;
    }
}
