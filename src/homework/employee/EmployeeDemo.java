package homework.employee;

import java.util.Scanner;

public class EmployeeDemo implements EmployeeCommands {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeStorage employeeStorage = new EmployeeStorage();

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            EmployeeCommands.printAllCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;

                case ADD_EMPLOYEE:
                    addEmployee();
                    break;

                case PRINT_ALL_EMPLOYEES:
                    employeeStorage.printAllEmployees();
                    break;

                case SEARCH_EMPLOYEE_BY_EMPLOYEE_ID:
                    searchEmployeeByEmployeeId();
                    break;

                case SEARCH_EMPLOYEE_BY_COMPANY_NAME:
                    searchByCompany();
                    break;

                case DELETE_EMPLOYEE:
                    deleteEmployee();
                    break;

                default:
                    System.out.println("Wrong command! Try again!");
            }
        }
    }


    private static void addEmployee() {
        System.out.println("Please enter id");
        String id = scanner.nextLine();
        System.out.println("Please enter name");
        String name = scanner.nextLine();
        System.out.println("Please enter surname");
        String surname = scanner.nextLine();
        System.out.println("Please enter salary");
        double salary = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter company");
        String company = scanner.nextLine();
        System.out.println("Please enter position");
        String position = scanner.nextLine();
        Employee employee = new Employee(name, surname, id, salary, company, position);
        Employee employeeId = employeeStorage.searchEmployeeById(id);
        if (employeeId == null) {
            employeeStorage.addEmployee(employee);
            System.out.println("Employee added!");

        } else {
            System.out.println("Employee is already exists!");
        }
    }

    private static void searchByCompany() {
        System.out.println("Please Enter company name!");
        String company = scanner.nextLine();
        Employee[] employeeCompany = employeeStorage.searchEmployeeByCompany(company);
        for (Employee employee : employeeCompany) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    private static void searchEmployeeByEmployeeId() {
        System.out.println("Please enter id for search");
        String id = scanner.nextLine();
        if (employeeStorage.searchEmployeeById(id) == null) {
            System.out.println("Cant find any employee with " + id + " ID");
        } else if (!id.isEmpty()) {
            System.out.println(employeeStorage.searchEmployeeById(id));
        } else {
            System.out.println("You are not entered any ID");
        }

    }

    private static void deleteEmployee() {
        System.out.println("Please enter employee Id for delete");
        String id = scanner.nextLine();
        if (employeeStorage.searchEmployeeById(id) != null) {
            employeeStorage.deleteEmployeeById(id);
            System.out.println("employee deleted");
        } else {
            System.out.println("There are not any employee");

        }
    }

}
