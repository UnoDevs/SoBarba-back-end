package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.mapper.TaskMapper;
import io.unodevs.SoBarba.model.Task;
import io.unodevs.SoBarba.model.dto.TaskDTO;
import io.unodevs.SoBarba.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.unodevs.SoBarba.service.util.ValidateEntityService.validateOptional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskMapper taskMapper;

    public List<TaskDTO> findAll() {
        return taskMapper.toTaskDTOList(taskRepository.findAll());
    }

    public TaskDTO findById(Long id) {
        return taskMapper.toTaskDTO(validateOptional(taskRepository.findById(id)));
    }

    public TaskDTO create(TaskDTO task) {
        Task responseData = taskRepository.save(taskMapper.toTask(task));
        return taskMapper.toTaskDTO(responseData);
    }

    public TaskDTO updateById(TaskDTO task, Long id) {
        TaskDTO taskDTOData = findById(id);

        taskDTOData.setName(task.getName());
        taskDTOData.setPrice(task.getPrice());
        taskDTOData.setTimeConclusion(task.getTimeConclusion());
        taskDTOData.setActive(task.getActive());
        taskDTOData.setDescription(task.getDescription());


        taskRepository.save(taskMapper.toTask(taskDTOData));
        return taskDTOData;
    }

    public void delete(Long id) {
        Task taskDeleted = taskMapper.toTask(findById(id));
        taskRepository.deleteById(id);
    }

}
