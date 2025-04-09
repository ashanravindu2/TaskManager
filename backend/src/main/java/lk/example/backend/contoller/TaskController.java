package lk.example.backend.contoller;

import jakarta.validation.Valid;
import lk.example.backend.dto.TaskDTO;
import lk.example.backend.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
public class TaskController {

    @Autowired
    private TaskService taskService;
    /**
     * Create a new task.
     *
     * @param task the task to create
     * @return the created task
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTask(@Valid @RequestBody TaskDTO task) {
        taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    /**
     * Update an existing task.
     *
     * @param task the task to update
     * @return the updated task
     */
    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<Void> updateTask(@Valid @RequestBody TaskDTO task, @PathVariable Long id) {
        task.setId(id);
        taskService.updateTask(task);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    /**
     * Get a task by ID.
     *
     * @param id the ID of the task
     * @return the task
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> getTask(@PathVariable Long id) {
        TaskDTO task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }
}
