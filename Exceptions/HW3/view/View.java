package view;

import presenter.Presenter;

public interface View {
    void print(String text);
    void start();
    void setPresenter(Presenter presenter);
    void addPerson();
    void getPersonList();
    void saveChanges();
    void finish();
}
