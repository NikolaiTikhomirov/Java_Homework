package view.exceptions;

public class UserInterGenderException extends UserInterExceptions{

    private final String data;

    public String getData() {
        return data;
    }

    public UserInterGenderException(String message, String data) {
        super(message);
        this.data = data;
    }
}
