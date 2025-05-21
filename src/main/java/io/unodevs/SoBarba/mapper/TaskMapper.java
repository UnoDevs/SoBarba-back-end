package io.unodevs.SoBarba.mapper;

import io.unodevs.SoBarba.model.Task;
import io.unodevs.SoBarba.model.dto.TaskDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toTask(TaskDTO dto);
    @Mapping(source = "category.id",target = "categoryId")
    TaskDTO toTaskDTO(Task entity);
    List<Task> toTaskList(List<TaskDTO> dtos);
    List<TaskDTO> toTaskDTOList(List<Task> entities);
}
