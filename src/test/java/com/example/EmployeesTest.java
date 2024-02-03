package com.example;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class EmployeesTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private Employees employees;
    
    @BeforeEach
    void createEmployeeRepository(){
        Employee employee1 = new Employee("Emp0234", 50000);
        Employee employee2 = new Employee("Emp1234",55000);
        when(employeeRepository.findAll()).thenReturn(List.of(employee1,employee2));
    }

    @Test
    @DisplayName("Given two employees will return two ")
    void givenTwoEmployeesWillReturnTwo() {    
        BankService bankServiceSpy = new BankServiceSpy();
        employees = new Employees(employeeRepository, bankServiceSpy);
        
        assertThat(employees.payEmployees()).isEqualTo(2);
    }
    
    @Test
    @DisplayName("Catch RuntimeException for payEmployees")
    void catchRuntimeExceptionForPayEmployees() {
        BankService bankServiceSpy = spy(new BankServiceSpy());
        employees = new Employees(employeeRepository, bankServiceSpy);
        doThrow(new RuntimeException("Simulating a runtime exception"))
                .when(bankServiceSpy)
                .pay(anyString(), anyDouble());

        Mockito.verify(bankServiceSpy, Mockito.times(0)).pay(anyString(), anyDouble());

        assertThat(employees.payEmployees()).isZero();
    }

}
