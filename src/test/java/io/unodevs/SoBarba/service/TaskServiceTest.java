package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.dto.TaskDTO;
import io.unodevs.SoBarba.mapper.TaskMapper;
import io.unodevs.SoBarba.model.Category;
import io.unodevs.SoBarba.model.Task;
import io.unodevs.SoBarba.repository.CategoryRepository;
import io.unodevs.SoBarba.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private TaskMapper taskMapper;

    @InjectMocks
    private TaskService taskService;

    private Task task;
    private TaskDTO taskDTO;
    private Category category;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        task = new Task();
        task.setId(1L);
        task.setName("Corte de cabelo");

        taskDTO = new TaskDTO();
        taskDTO.setId(1L);
        taskDTO.setName("Corte de cabelo");
        taskDTO.setCategoryId(1L);

        category = new Category();
        category.setId(1L);
        category.setName("Cabelos");
        category.setTasks(new ArrayList<>());
    }

    @Test
    void findAllReturnsTaskDTOList() {
        when(taskRepository.findAllWithCategory()).thenReturn(Collections.singletonList(task));
        when(taskMapper.toTaskDTOList(anyList())).thenReturn(Collections.singletonList(taskDTO));

        var result = taskService.findAll();

        assertEquals(1, result.size());
        assertEquals("Corte de cabelo", result.get(0).getName());
    }

    @Test
    void findByIdReturnsTaskDTO() {
        when(taskRepository.findByIdWithCategory(1L)).thenReturn(Optional.of(task));
        when(taskMapper.toTaskDTO(task)).thenReturn(taskDTO);

        var result = taskService.findById(1L);

        assertEquals(1L, result.getId());
        assertEquals("Corte de cabelo", result.getName());
    }

    @Test
    void createSuccessfullyCreatesTask() {
        when(taskMapper.toTask(taskDTO)).thenReturn(task);
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        when(taskMapper.toTaskDTO(task)).thenReturn(taskDTO);

        var result = taskService.create(taskDTO);

        verify(taskRepository).save(task);
        verify(categoryRepository).save(category);
        assertEquals(taskDTO.getName(), result.getName());
    }

    @Test
    void updateByIdUpdatesTaskCorrectly() {
        when(taskRepository.findByIdWithCategory(1L)).thenReturn(Optional.of(task));
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        when(taskMapper.toTaskDTO(task)).thenReturn(taskDTO);

        var result = taskService.updateById(taskDTO, 1L);

        verify(taskRepository).save(task);
        verify(categoryRepository).save(category);
        assertEquals("Corte de cabelo", result.getName());
    }

    @Test
    void deleteDeletesTaskById() {
        when(taskRepository.findByIdWithCategory(1L)).thenReturn(Optional.of(task));
        when(taskMapper.toTaskDTO(task)).thenReturn(taskDTO);
        when(taskMapper.toTask(taskDTO)).thenReturn(task);

        taskService.delete(1L);

        verify(taskRepository).deleteById(1L);
    }
}
