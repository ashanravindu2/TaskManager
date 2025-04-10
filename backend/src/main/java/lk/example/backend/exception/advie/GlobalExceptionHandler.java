package lk.example.backend.exception.advie;


import lk.example.backend.exception.DataPersistFailedException;
import lk.example.backend.exception.TaskNotFoundException;
import lk.example.backend.exception.UserAlreadyExits;
import lk.example.backend.exception.UserNotFoundException;
import lk.example.backend.jwtmodels.JwtAuthResponse;
import lk.example.backend.response.TaskResponse;
import lk.example.backend.response.impl.TaskErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Handle DataPersistFailedException.
     *
     * @param ex the exception
     * @return the response entity with error message
     */
    @ExceptionHandler(DataPersistFailedException.class)
    public ResponseEntity<TaskResponse> handleDataPersistFailed(DataPersistFailedException ex) {
        TaskResponse response = new TaskErrorResponse(ex.getErrorCode(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    /**
     * Handle TaskNotFoundException.
     *
     * @param ex the exception
     * @return the response entity with error message
     */
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<TaskResponse> handleTaskNotFoundException(TaskNotFoundException ex) {
        TaskResponse response = new TaskErrorResponse(ex.getErrorCode(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    /**
     * Handle MethodArgumentNotValidException.
     *
     * @param ex the exception
     * @return the response entity with error message
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<TaskResponse> handleValidationException(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.joining("; "));

        TaskResponse response = new TaskErrorResponse(400, message);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    /**
     * Handle UserNotFoundException.
     *
     * @param ex the exception
     * @return the response entity with error message
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<JwtAuthResponse> handleUserNotFoundException(UserNotFoundException ex) {
        JwtAuthResponse response = JwtAuthResponse.builder()
                .token(ex.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    /**
     * Handle UserAlreadyExits.
     *
     * @param ex the exception
     * @return the response entity with error message
     */
    @ExceptionHandler(UserAlreadyExits.class)
    public ResponseEntity<JwtAuthResponse> handleUserAlreadyExits(UserAlreadyExits ex) {
        JwtAuthResponse response = JwtAuthResponse.builder()
                .token(ex.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
