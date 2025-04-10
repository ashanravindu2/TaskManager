package lk.example.backend.exception;

public class UserAlreadyExits extends RuntimeException {
    public UserAlreadyExits(String message) {
        super(message);
    }

    public UserAlreadyExits(String message, Throwable cause) {
        super(message, cause);
    }
}
