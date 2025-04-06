package io.unodevs.SoBarba.mapper;

import io.unodevs.SoBarba.model.Task;
import io.unodevs.SoBarba.model.dto.TaskDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toTask(TaskDTO dto);
    TaskDTO toTaskDTO(Task entity);
}
