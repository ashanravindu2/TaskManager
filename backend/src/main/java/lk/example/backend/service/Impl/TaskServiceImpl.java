package lk.example.backend.service.Impl;



import jakarta.transaction.Transactional;
import lk.example.backend.dto.TaskDTO;
import lk.example.backend.exception.DataPersistFailedException;
import lk.example.backend.exception.TaskNotFoundException;
import lk.example.backend.model.Task;
import lk.example.backend.model.TaskStatus;
import lk.example.backend.repository.TaskRepository;
import lk.example.backend.service.TaskService;
import lk.example.backend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    private final Mapping mapping;

    @Override
    public void createTask(TaskDTO task) {
        try {
            Task taskEntity = mapping.map(task, Task.class);
            taskEntity.setCreatedAt(LocalDateTime.now());
            System.out.println("Task Entity: " + taskEntity);
            taskRepository.save(taskEntity);
        } catch (Exception e) {
            throw new DataPersistFailedException("Failed to persist task data", 400);
        }
    }


    @Override
        @Transactional
        public void updateTask(TaskDTO task) {
            Optional<Task> taskEntity = taskRepository.findById(task.getId());
            if (taskEntity.isPresent()) {
                Task taskToUpdate = taskEntity.get();
                taskToUpdate.setTitle(task.getTitle());
                taskToUpdate.setDescription(task.getDescription());
                taskToUpdate.setStatus(TaskStatus.valueOf(task.getStatus()));
            } else {
                throw new TaskNotFoundException("Task not found", 404);
            }
        }

    @Override
    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found", 404));
        return mapping.map(task, TaskDTO.class);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(task -> mapping.map(task, TaskDTO.class))
                .toList();
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found", 404));
        taskRepository.delete(task);
    }

}
