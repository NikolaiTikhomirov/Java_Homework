package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.Gender;
import presenter.Presenter;
import view.exceptions.UserInterDateException;
import view.exceptions.UserInterGenderException;
import view.exceptions.UserInterLengthException;
import view.exceptions.UserInterNameException;
import view.exceptions.UserInterPhoneException;

public class Console implements View{

    private static final String INPUT_ERROR = "Введенные данные некорректны, попробуйте еще раз";
    private Presenter presenter;
    private Scanner scanner;
    private Boolean work;
    private MainMenu mainMenu;

    
    public Console(){
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
    
    @Override
    public void start() {
        System.out.println("Доброго времени суток");;
        while (work) {
            printMenu();
            execute();
        }
    }
    
    @Override
    public void finish() {
        System.out.println("До скорых встреч");
        scanner.close();
        work = false;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void addPerson(){
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
                        if (element.equals("m") || element.equals("f"))
                        genderTemp = element;
                    } catch (Exception e){e.printStackTrace();}
                }
                if (genderTemp == null) throw new UserInterGenderException("Неверно указан пол");
                Gender gender = Gender.valueOf(genderTemp);
                listPersonData.remove(genderTemp);


                String fio = "";
                for (String element : listPersonData) {
                    if (element.length() < 2)
                        throw new UserInterNameException("Некорректное имя персоны.", element);
                    fio += element + " ";
                }
                presenter.addPerson(fio, date, phone, gender);
            }
            catch (UserInterLengthException e){
                System.out.println("Вы ввели больше или меньше данных, чем требуется - " + e.getData() + "\n");
                continue root;
            }
            catch (UserInterNameException e){
                System.out.println("Некорректное ФИО - " + e.getData() + "\n");
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
                e.printStackTrace();
                System.out.println(INPUT_ERROR);
                continue root;
            }
            addWork = false;
        }
    }
    
    @Override
    public void getPersonList() {
        presenter.getPersonList();
    }

    private void printMenu(){
        System.out.println(mainMenu.print());
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                mainMenu.execute(numCommand);
            }
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= mainMenu.size()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    @Override
    public void saveChanges() {
        presenter.saveChanges();
    }

}
