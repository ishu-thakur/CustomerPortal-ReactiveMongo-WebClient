package com.reactivemongo.ReactiveApi.mappers;

import com.reactivemongo.ReactiveApi.dto.EmployeeDto;
import com.reactivemongo.ReactiveApi.model.Employee;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface mapper {

    mapper INSTANCE = Mappers.getMapper(mapper.class);
//**********************************CONVERTING********************************************
    Employee dtoToEntity(EmployeeDto dto);

    EmployeeDto entityToDto(Employee employee);
//**********************************PARITAL UPDATE*****************************************
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void updateEmployeeFromDto(EmployeeDto employeeDTO, @MappingTarget Employee employee);
}
