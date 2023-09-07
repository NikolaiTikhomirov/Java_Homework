package view.exceptions;

public class UserInterDateException extends UserInterExceptions{

    private final String data;

    public String getData() {
        return data;
    }

    public UserInterDateException(String message, String data) {
        super(message);
        this.data = data;
    }
}
