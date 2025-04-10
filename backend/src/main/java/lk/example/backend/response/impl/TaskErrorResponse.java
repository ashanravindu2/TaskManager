package lk.example.backend.response.impl;


import lk.example.backend.response.TaskResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskErrorResponse implements TaskResponse {
    private int errorCode;
    private String errorMessage;
}
