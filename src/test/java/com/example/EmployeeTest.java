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
    @DisplayName("Retrieve employee id for initialized employee")
    void retrieveEmployeeIdForInitializedEmployee() {
        assertEquals("Emp0234", employee.getId());
    }

    @Test
    @DisplayName("Setting new id updates employee id")
    void settingNewIdUpdatesEmployeeId() {
        employee.setId(("OOH-1"));
        assertEquals("OOH-1", employee.getId());
    }

    @Test
    @DisplayName("Retrieve salary for initialized employee")
    void retrieveSalaryForInitializedEmployee() {
        assertEquals(50000, employee.getSalary());
    }

    @Test
    @DisplayName("Setting new salary updates employee salary")
    void settingNewSalaryUpdatesEmployeeId() {
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


