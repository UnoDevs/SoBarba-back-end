package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.mapper.TaskMapper;
import io.unodevs.SoBarba.model.Category;
import io.unodevs.SoBarba.model.Task;
import io.unodevs.SoBarba.model.dto.TaskDTO;
import io.unodevs.SoBarba.repository.CategoryRepository;
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
    private CategoryRepository categoryRepository;
    @Autowired
    private TaskMapper taskMapper;

    public List<TaskDTO> findAll() {
        return taskMapper.toTaskDTOList(taskRepository.findAllWithCategory());
    }

    public TaskDTO findById(Long id) {
        return taskMapper.toTaskDTO(validateOptional(taskRepository.findByIdWithCategory(id)));
    }

    public TaskDTO create(TaskDTO dto) {
        Task task = taskMapper.toTask(dto);

        Category category = validateOptional(categoryRepository.findById(dto.getCategoryId()));
        category.addTask(task);

        taskRepository.save(task);
        categoryRepository.save(category);

        TaskDTO response = taskMapper.toTaskDTO(task);
        response.setCategoryId(category.getId());

        return response;
    }

    public TaskDTO updateById(TaskDTO dto, Long id) {
        Task task = validateOptional(taskRepository.findByIdWithCategory(id));

        task.setName(dto.getName());
        task.setPrice(dto.getPrice());
        task.setTimeConclusion(dto.getTimeConclusion());
        task.setActive(dto.getActive());
        task.setDescription(dto.getDescription());

        if(dto.getCategoryId() != null){
            Category category = validateOptional(categoryRepository.findById(dto.getCategoryId()));
            category.addTask(task);
            categoryRepository.save(category);
        }
        taskRepository.save(task);

        return taskMapper.toTaskDTO(task);

    }

    public void delete(Long id) {
        Task taskDeleted = taskMapper.toTask(findById(id));
        taskRepository.deleteById(id);
    }

}
