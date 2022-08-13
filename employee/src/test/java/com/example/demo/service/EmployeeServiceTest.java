package com.example.demo.service;

import com.example.demo.controller.to.EmployeeTo;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.Dto.SimpleEmployeeTo;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



@SpringBootTest
class EmployeeServiceTest {
    @MockBean
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeServiceImpl employeeService;

        @Test
        void addEmployee() {
            EmployeeTo expectedSimpleEmployeeTo = new EmployeeTo(1L, "testName", "testLastName",
                    "test@gmail.com", 25, 1800, 1,"my");
            EmployeeEntity expectedEmployeeEntity = new EmployeeEntity(1L, "testName", "testLastName",
                    "test@gmail.com", 25, 1800, 1);
            when(employeeRepository.save(any())).thenReturn((expectedEmployeeEntity));

            EmployeeTo response= employeeService.addEmployee(expectedSimpleEmployeeTo, "my");
            assertThat(response).usingRecursiveComparison()
                    .isEqualTo(expectedSimpleEmployeeTo);

            ArgumentCaptor<EmployeeEntity> employeeEntityArgumentCaptor = ArgumentCaptor.forClass(EmployeeEntity.class);
            verify(employeeRepository).save(employeeEntityArgumentCaptor.capture());
            assertThat(employeeEntityArgumentCaptor.getValue()).usingRecursiveComparison()
                    .isEqualTo(expectedEmployeeEntity);
        }

        @Test
        void retrieveAllEmployee() {
            EmployeeEntity expectedEmployeeEntity1 =  new EmployeeEntity(1L, "testName", "testLastName",
                    "test@gmail.com", 25, 1800, 1);
            EmployeeEntity expectedEmployeeEntity2 =  new EmployeeEntity(2L, "testName2", "testLastName2",
                    "test2@gmail.com", 25, 1800, 2);
            EmployeeEntity expectedEmployeeEntity3 =  new EmployeeEntity(3L, "testName3", "testLastName",
                    "test3@gmail.com", 25, 1800, 3);
            List<EmployeeEntity> employeeEntityList = new ArrayList<>();
            employeeEntityList.add(expectedEmployeeEntity1);
            employeeEntityList.add(expectedEmployeeEntity2);
            employeeEntityList.add(expectedEmployeeEntity3);
            when(employeeRepository.findAll()).thenReturn(employeeEntityList);
            List<SimpleEmployeeTo> result=  employeeService.retrieveAllEmployee();
            assertThat(result.size()).isGreaterThanOrEqualTo(1);
        }

        @Test
        void deleteEmployee() {
            EmployeeEntity expectedEmployeeEntity1 = new EmployeeEntity(1L, "testName", "testLastName",
                    "test@gmail.com", 25, 1800, 1);
            EmployeeEntity expectedEmployeeEntity2 = new EmployeeEntity(2L, "testName2", "testLastName2",
                    "test2@gmail.com", 25, 1800, 2);
            EmployeeEntity expectedEmployeeEntity3 = new EmployeeEntity(3L, "testName3", "testLastName",
                    "test3@gmail.com", 25, 1800, 3);
            when(employeeRepository.findById(expectedEmployeeEntity1.getEmployeeid())).thenReturn(Optional.of(expectedEmployeeEntity1));
            employeeService.deleteEmployee(expectedEmployeeEntity1.getEmployeeid());

            verify(employeeRepository).deleteById(expectedEmployeeEntity1.getEmployeeid());
        }

}
