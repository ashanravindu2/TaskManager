package lk.example.backend.exception;

import lombok.Getter;

@Getter
public class TaskNotFoundException extends RuntimeException {
    private final int errorCode;
    public TaskNotFoundException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public TaskNotFoundException(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
