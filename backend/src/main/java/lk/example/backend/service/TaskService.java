package lk.example.backend.service;

import lk.example.backend.dto.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    void createTask(TaskDTO task);

    void updateTask(TaskDTO task);

    TaskDTO getTaskById(Long id);

    List<TaskDTO> getAllTasks();

    void deleteTask(Long id);
}
