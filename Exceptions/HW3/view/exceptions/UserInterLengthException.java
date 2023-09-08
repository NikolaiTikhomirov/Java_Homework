package view.exceptions;

public class UserInterLengthException extends UserInterExceptions{

    private final String data;

    public String getData() {
        return data;
    }

    public UserInterLengthException(String message, String data) {
        super(message);
        this.data = data;
    }
}
