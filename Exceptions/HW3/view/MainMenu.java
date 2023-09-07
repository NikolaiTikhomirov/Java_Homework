package view;

import view.commands.AddPerson;
import view.commands.Command;
import view.commands.Finish;
import view.commands.GetPersonList;
import view.commands.SaveChanges;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;
    private View view;

    public MainMenu(View view) {
        this.view = view;
        commandList = new ArrayList<>();
        commandList.add(new AddPerson(view));
        commandList.add(new GetPersonList(view));
        commandList.add(new SaveChanges(view));
        commandList.add(new Finish(view));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    public void execute(int numCommand){
        commandList.get(numCommand - 1).execute();
    }

    public int size(){
        return commandList.size();
    }
}
