import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        
    System.out.println(isCorrectParentheses("()")); // true
    System.out.println(isCorrectParentheses("(")); // false
    System.out.println(isCorrectParentheses("())")); // false
    System.out.println(isCorrectParentheses("((()))")); // true
    System.out.println(isCorrectParentheses("()[]{}<>")); // true
    System.out.println(isCorrectParentheses("([)]")); // false
    System.out.println(isCorrectParentheses("][]")); // false
    System.out.println(isCorrectParentheses("[]{<()[]<>>}")); // true
}

/**
 * Дана последовательность скобочек. Проверить, что она является корректной.
 */
    static boolean isCorrectParentheses(String parentheses) {
    // TODO: 07.04.2023 Вписать решение!
    // Нужно завести маппинг скобочек либо ( -> ), либо ) -> ( и так для каждой пары
    // Нужно использовать Deque.
    // Открывающуюся скобку вносим в Deque (insertFirst)
    // Если встретилась закрывающаяся скобка, то (Deque#pollFirst) и сравниваем ее с встретившейся

    char[] parenthesesArray = parentheses.toCharArray();
    if (parenthesesArray.length % 2 != 0) return false;
    
    Map<Character, Character> staplesMap = new HashMap<>();
    staplesMap.put('(', ')');
    staplesMap.put('{', '}');
    staplesMap.put('[', ']');
    staplesMap.put('<', '>');

    Deque<Character> openElement = new ArrayDeque<>();
    
    for (int i = 0; i < parenthesesArray.length; i++) {
        if (staplesMap.containsKey(parenthesesArray[i])) {
            openElement.push(staplesMap.get(parenthesesArray[i]));
            }
        else {
            try {
                if (openElement.pollFirst().equals(parenthesesArray[i]));
                else return false;
            } catch (Exception e) {
                return false;
            }
        }
    }
    // if (openElement.size() != 0) return false;
    return true;
    }
}
