package presenter;

import java.time.LocalDate;

import model.Gender;
import model.Model;
import view.View;

public class Presenter {
    private View view;
    private Model model;

    public Presenter(View view, Model model){
        this.view = view;
        this.model = model;
        view.setPresenter(this);
    }

    public void addPerson(String name, LocalDate date, Integer phone, Gender gender){
        model.addPerson(name, date, phone, gender);
    }

    public void getPersonList(){
        view.print(model.getPersonList());
    }

    public void saveChanges() {
        model.saveChanges();
    }
}
