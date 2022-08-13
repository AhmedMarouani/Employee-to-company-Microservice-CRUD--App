package com.example.demo.controller;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.Dto.SimpleEmployeeTo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void addEmployee() throws Exception {
        SimpleEmployeeTo expectedSimpleEmployeeTo = new SimpleEmployeeTo(1L, "testName", "testLastName",
                "test@gmail.com", 25, 1800, 1);
        //when
        var response = mockMvc.perform(
                        post("/api/v1/Employee/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(expectedSimpleEmployeeTo))
                )//then
                .andExpect(status().isOk())
                .andReturn();
        var employeeResponseTO = objectMapper.readValue(response.getResponse().getContentAsString(), SimpleEmployeeTo.class);

        assertThat(employeeResponseTO).usingRecursiveComparison().ignoringFields("id").isEqualTo(expectedSimpleEmployeeTo);
    }

    @Test
    void retrieveAllEmployee() throws Exception {
        createEmployees();
        SimpleEmployeeTo expectedEmployeeTO = getSecondEmployeeTo();
        List<SimpleEmployeeTo> employeeToList = new ArrayList<>();
        employeeToList.add(expectedEmployeeTO);
        //when
        var response = mockMvc.perform(get("/api/v1/Employee/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(employeeToList)
                                )
                )//then
                .andExpect(status().isOk())
                .andReturn();
        var employeeResponseTO = objectMapper.readValue(response.getResponse().getContentAsString(), SimpleEmployeeTo.class);

        assertThat(employeeResponseTO).usingRecursiveComparison().isEqualTo(employeeToList);
    }
    private SimpleEmployeeTo getSecondEmployeeTo(){
        return new SimpleEmployeeTo(2L, "ahmed", "marouani",
                "ahmed.marouani@gmail.com", 27 , 800, 2);
    }

    private void createEmployees(){
        EmployeeEntity e1 = new EmployeeEntity(1L, "ahmed", "marouani",
                "ahmed.marouani@gmail.com", 27 , 800, 1);
        EmployeeEntity e2 = new EmployeeEntity(2L, "ahmed", "marouani",
                "ahmed.marouani@gmail.com", 27 , 800, 2);
        EmployeeEntity e3 = new EmployeeEntity(3L, "ahmed", "marouani",
                "ahmed.marouani@gmail.com", 27 , 800, 3);
        employeeRepository.saveAndFlush(e1);
        employeeRepository.saveAndFlush(e2);
        employeeRepository.saveAndFlush(e3);

    }


}
