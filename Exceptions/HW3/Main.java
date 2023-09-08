import model.Model;
import model.fileHandler.FileHandler;
import model.fileHandler.PersonFileHandler;
import model.fileHandler.PersonWritable;
import model.fileHandler.Writable;
import presenter.Presenter;
import view.Console;
import view.View;

public class Main {
    public static void main(String[] args) {

        Writable writable = new FileHandler();
        PersonWritable personWritable = new PersonFileHandler();
        View view = new Console();
        Model model = new Model(writable, personWritable);
        new Presenter(view, model);
        view.start();
    }
}
