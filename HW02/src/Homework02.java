import java.nio.file.Files;
import java.nio.file.Path;

public class Homework02 {
    public static void main(String[] args) throws Exception {
        
        System.out.println(buildString(7, 'a', 'b'));

        createFile("file.txt");
        addTextInFile(100, "TEXT", Path.of("file.txt"));
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


// Создать файл file.txt. Если файл уже создан, ничего делать не надо.
// Записать в файл слово TEXT 100 раз: TEXTTEXTTEXTTEXTTEXTTEXT...

    static void createFile(String fileName){
        Path path = Path.of(fileName);
        try {
            Files.createFile(path);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("File already exist");
        }
    }
    static void addTextInFile(int n, String text, Path path){
        StringBuilder res = new StringBuilder();
        if (Files.exists(path)){
            for (int i = 0; i < n; i++) res.append(text);
            String resres = res.toString();
            try {
                Files.writeString(path, resres);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("It something wrong");
            }
        }
        else System.out.println("File is not exist");
    }
}