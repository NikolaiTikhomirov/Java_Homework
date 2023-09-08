import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.Gender;
import view.exceptions.UserInterDateException;
import view.exceptions.UserInterGenderException;
import view.exceptions.UserInterLengthException;
import view.exceptions.UserInterNameException;
import view.exceptions.UserInterPhoneException;

public class Test {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean addWork;
            addWork = true;
            root: while (addWork){
                try {
                    System.out.println("Введите данные персоны через пробел в произвольном порядке (ФИО дата рождения номер телефона пол)");
                    String personData = scanner.nextLine();
                    List<String> listPersonData = new ArrayList<String>(Arrays.asList(personData.split(" ")));
                    if (listPersonData.size() != 6)
                        throw new UserInterLengthException("Вы ввели меньше или больше данных, чем требуется", personData);
                    
                    
                    LocalDate date = null;
                    for (String element : listPersonData) {
                        try {
                            date = LocalDate.parse(element);
                        } catch (Exception e){}
                    }
                    if (date == null) throw new UserInterDateException("Неверный формат даты.");
                    listPersonData.remove(date.toString());
                    // System.out.println(listPersonData.toString());


                    Integer phone = null;
                    for (String element : listPersonData) {
                        try {
                            phone = Integer.parseInt(element);
                        } catch (Exception e){}
                    }
                    if (phone == null) throw new UserInterPhoneException("Неверный формат номера телефона");
                    listPersonData.remove(phone.toString());


                    String genderTemp = null;
                    for (String element : listPersonData) {
                        try {
                            if (element.equals("m") & element.equals("f"))
                            genderTemp = element;
                        } catch (Exception e){}
                    }
                    if (genderTemp == null) throw new UserInterGenderException("Неверно указан пол");
                    Gender gender = Gender.valueOf(genderTemp);
                    listPersonData.remove(genderTemp);


                    String fio = "";
                    for (String element : listPersonData) {
                        if (personData.length() < 2)
                            throw new UserInterNameException("Некорректное имя персоны.", personData);
                        fio = fio + " " + element;
                    }
                    System.out.println(fio + date + phone + gender);
                }
                catch (UserInterLengthException e){
                    System.out.println("Вы ввели больше или меньше данных, чем требуется - " + e.getData() + "\n");
                    continue root;
                }
                catch (UserInterNameException e){
                    System.out.println("Слишком короткое имя - " + e.getData() + "\n");
                    continue root;
                }
                catch(UserInterDateException e){
                    System.out.println("Неверный формат даты\n");
                    continue root;
                }
                catch(UserInterPhoneException e){
                    System.out.println("Неверный формат номера телефона\n");
                    continue root;
                }
                catch(UserInterGenderException e){
                    System.out.println("Неверно указан пол\n");
                    continue root;
                }
                catch (Exception e) {
                    System.out.println(e);
                    continue root;
                }
                addWork = false;
            }
        }
    }
}
