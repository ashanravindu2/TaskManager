package lk.example.backend.exception;

import lombok.Getter;

@Getter
public class DataPersistFailedException extends RuntimeException {
    private final int errorCode;
    public DataPersistFailedException(String message , int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public DataPersistFailedException(String message , Throwable cause , int errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
