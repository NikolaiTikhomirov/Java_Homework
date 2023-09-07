package view.exceptions;

public class UserInterPhoneException extends UserInterExceptions{

    private final String data;

    public String getData() {
        return data;
    }

    public UserInterPhoneException(String message, String data) {
        super(message);
        this.data = data;
    }
}
