package view.exceptions;

public class UserInterNameException extends UserInterExceptions{

    private final String data;

    public String getData() {
        return data;
    }

    public UserInterNameException(String message, String data) {
        super(message);
        this.data = data;
    }
}
