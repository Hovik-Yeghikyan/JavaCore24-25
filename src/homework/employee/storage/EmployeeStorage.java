package homework.employee.storage;

import homework.employee.model.Company;
import homework.employee.model.Employee;

public class EmployeeStorage {

    Employee[] employees = new Employee[10];
    private int size;

    public void addEmployee(Employee employee) {
        if (size == employees.length) {
            extend();
        }
        employees[size++] = employee;
    }




    public void printAllEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public Employee searchEmployeeById(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(id)) {
                return employees[i];
            }
        }
        return null;
    }

    public void searchEmployeeByCompany(Company company) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getCompany().equals(company)) {
                System.out.println(employees[i]);
            }
        }
    }

    public void deleteEmployeeById(String id) {
        int index = getEmployeeIndexById(id);
        if (index != -1) {
            for (int i = index + 1; i < size; i++) {
                employees[i - 1] = employees[i];
            }
            size--;
        }
    }

    private int getEmployeeIndexById(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    private void extend() {
        Employee[] tmp = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, tmp, 0, employees.length);
        employees = tmp;
    }
}
