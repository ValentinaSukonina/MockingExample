package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;


class EmployeeTest {
    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee("Emp0234", 50000);
    }

    @AfterEach
    void tearDown() {
        this.employee = null;
    }

    @Test
    @DisplayName("Employee id changed")
    void employeeIdChanged() {
        Employee employee = new Employee("23", 50000);
        employee.setId("OOH-1");

        assertEquals("OOH-1", employee.getId());
    }

    @Test
    @DisplayName("Employee salary changed")
    void employeeSalaryChanged() {
        Employee employee = new Employee("23", 50000);
        employee.setSalary(55000);

        assertEquals(55000, employee.getSalary());
    }

    @Test
    @DisplayName("Setting new paid status updates employee paid status")
    void settingNewPaidStatusUpdatesEmployeePaidStatus() {
        employee.setPaid(true);

        assertTrue(employee.isPaid());
    }

    @Test
    @DisplayName("toString method returns correct format")
    void toStringMethodReturnsCorrectFormat() {
        String expected = "Employee [id=" + "Emp0234" + ", salary=" + 50000.00 + "]";

        assertEquals(expected, employee.toString());
    }

    @Test
    @DisplayName("Null id does not throw exception")
    void nullIdDoesNotThrowException() {
        employee.setId(null);

        assertThatCode(()-> employee.getId())
                .doesNotThrowAnyException();
    }

}


