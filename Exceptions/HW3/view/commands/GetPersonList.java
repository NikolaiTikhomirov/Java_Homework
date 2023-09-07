package view.commands;

import view.View;

public class GetPersonList implements Command {
    private View view;

    public GetPersonList(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Посмотреть список персон";
    }

    @Override
    public void execute() {
        view.getPersonList();
    }
}
