public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println(buildString(7, 'a', 'b'));
    }

// Дано четное число N (>0) и символы c1 и c2.
// Написать метод, который вернет строку длины N, которая состоит из чередующихся символов c1 и c2, начиная с c1.
// Пример. (n = 6, c1='a', c2='b') -> "ababab"
// (n = 8, c1='x', c2='y') -> "xyxyxyxy"

    static String buildString(int n, char c1, char c2) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n / 2 - 1; i++) res.append(c1).append(c2);
        res.append(c1);
        if (n % 2 == 0) res.append(c2);
        else res.append(c2).append(c1);
        String resres = res.toString();
        return resres;
    }
}


