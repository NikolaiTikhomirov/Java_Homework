package view;

import java.time.LocalDate;
import java.util.Scanner;

import model.Gender;
import presenter.Presenter;

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
                System.out.println("Введите имя");
                String name = scanner.nextLine();
                System.out.println("Введите дату рождения в формате гггг-мм-чч");
                LocalDate date = LocalDate.parse(scanner.nextLine());
                System.out.println("Введите номер телефона(только цифры)");
                Integer phone = Integer.parseInt(scanner.nextLine());
                System.out.println("Укажите пол (f or m)");
                Gender gender = Gender.valueOf(scanner.nextLine());
                presenter.addPerson(name, date, phone, gender);
            } catch (Exception e) {
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
