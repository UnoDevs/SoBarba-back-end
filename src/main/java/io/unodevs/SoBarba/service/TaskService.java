package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.model.Task;
import io.unodevs.SoBarba.repository.TaskRepository;
import io.unodevs.SoBarba.service.util.ValidateEntityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static io.unodevs.SoBarba.service.util.ValidateEntityService.validateOptional;

@org.springframework.stereotype.Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        return validateOptional(taskRepository.findById(id));
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public Task update(Task task, Long id) {

        Task taskUpdated = validateOptional(
            taskRepository.findById(id).map(val -> {
                val.setName(task.getName());
                val.setDescription(task.getDescription());
                val.setPrice(task.getPrice());
                val.setTimeConclusion(task.getTimeConclusion());
                val.setIsActive(task.isActive());
                return val;
            })
        );
        taskRepository.save(taskUpdated);

        return taskUpdated;

    }

    public Task delete(Long id) {
        Task taskDeleted = validateOptional(taskRepository.findById(id));
        taskRepository.deleteById(id);
        return taskDeleted;
    }

}
