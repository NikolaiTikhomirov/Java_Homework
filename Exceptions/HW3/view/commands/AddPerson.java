package view.commands;

import view.View;

public class AddPerson implements Command {
    private View view;

    public AddPerson(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Добавить персону";
    }

    @Override
    public void execute() {
        view.addPerson();
    }
}
