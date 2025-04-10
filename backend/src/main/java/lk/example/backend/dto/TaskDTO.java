package lk.example.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDTO {
    private Long id;

    @NotBlank(message = "Task name is required")
    @Size(min = 3, max = 50, message = "Task title must be between 3 and 50 characters")
    private String title;

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    private String description;

    @NotNull(message = "Status is required")
    private String status;

    private String createdAt;

    @NotNull(message = "User ID is required")
    private Long userId;
}
