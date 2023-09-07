import model.Model;
import model.fileHandler.FileHandler;
import model.fileHandler.Writable;
import presenter.Presenter;
import view.Console;
import view.View;

public class Main {
    public static void main(String[] args) {

        Writable writable = new FileHandler();
        View view = new Console();
        Model model = new Model(writable);
        new Presenter(view, model);
        view.start();
    }
}
