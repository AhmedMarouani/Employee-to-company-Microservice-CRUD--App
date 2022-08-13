package com.example.demo.service;

import com.example.demo.adapter.CompanyClient;
import com.example.demo.adapter.to.CompanyTo;
import com.example.demo.controller.to.EmployeeTo;
import com.example.demo.mappers.EmployeeDtoMapper;
import com.example.demo.mappers.EmployeeToMapeer;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.Dto.SimpleEmployeeTo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.mappers.EmployeeToMapeer.maptoemployeeTo;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompanyClient companyClient;

    public void verifyExistenceById(long id){
        employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no employee was found for id " + id));
    }

    public boolean isEmailExisting(String email){
        return employeeRepository.getByEmailIgnoreCase(email).isPresent();
    }
    //stream is something like a list
    //.map will map what it gets as a parameter with what became a stream
    //EmployeeDtoMapper::mapToEmployeeDto we did not use EmployeeDtoMapper.mapToEmployeeDto because it will
    //consider it as an executable method
    @Override
    public List<SimpleEmployeeTo> retrieveAllEmployee() {
        return employeeRepository.findAll().stream().map(EmployeeDtoMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeTo addEmployee(EmployeeTo employeeTo, String companyName) {
        log.info("saving Employee: ", employeeTo);
        return EmployeeToMapeer.maptoemployeeTo(employeeRepository.save(
                EmployeeToMapeer.mapToEmployeeEntity(employeeTo)), companyName);
    }

    @Override
    public void deleteEmployee(long id) {
        log.info("Deleting Employee by id: {}", id);
        verifyExistenceById(id);
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeTo updateEmployee(EmployeeEntity e, Long id) {
        log.info("Employee updated", e);

        EmployeeEntity updatedemployee = employeeRepository.findById(id).get();
        updatedemployee.setFirstname(e.getFirstname());
        updatedemployee.setLastname(e.getLastname());
        updatedemployee.setAge(e.getAge());
        updatedemployee.setSalary(e.getSalary());
        updatedemployee.setEmail(e.getEmail());
        updatedemployee.setCompanyid(e.getCompanyid());

        return EmployeeToMapeer.maptoemployeeTo(employeeRepository.save(updatedemployee), "wolf");
    }

    @Override
    public EmployeeTo retreiveEmployee(Long id) {
        log.info("fetching Employee by id: {}", id);
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        long companyIdOfEmploee = employeeEntity.getCompanyid();
        CompanyTo companyTo = this.getCompanyById(companyIdOfEmploee);
        // we did this mapping between the Employee and the EmployeeTo because they do not have the same type
        String comanyName = companyTo.getName();
        EmployeeTo employeeTo = maptoemployeeTo(employeeEntity, comanyName);
        return employeeTo;
    }

    @Override
    public CompanyTo getCompanyById(long id){
        log.info("fetching Company by id: {}", id);
        CompanyTo companyTo = companyClient.getCompanyById(id);
        return companyTo;
    }
}
