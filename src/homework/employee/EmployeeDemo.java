package homework.employee;

import java.util.Scanner;

public class EmployeeDemo implements EmployeeCommands {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final EmployeeStorage EMPLOYEE_STORAGE = new EmployeeStorage();

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            EmployeeCommands.printAllCommands();
            String command = SCANNER.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;

                case ADD_EMPLOYEE:
                    addEmployee();
                    break;

                case PRINT_ALL_EMPLOYEES:
                    EMPLOYEE_STORAGE.printAllEmployees();
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

                case UPDATE_EMPLOYEE:
                    updateEmployee();
                    break;

                default:
                    System.out.println("Wrong command! Try again!");
            }
        }
    }


    private static void addEmployee() {
        System.out.println("Please enter id");
        String id = SCANNER.nextLine();
        System.out.println("Please enter name");
        String name = SCANNER.nextLine();
        System.out.println("Please enter surname");
        String surname = SCANNER.nextLine();
        System.out.println("Please enter company");
        String company = SCANNER.nextLine();
        System.out.println("Please enter position");
        String position = SCANNER.nextLine();
        try {
            System.out.println("Please enter salary");
            double salary = Double.parseDouble(SCANNER.nextLine());
            Employee employee = new Employee(name, surname, id, salary, company, position);
            if (employee.getEmployeeID() == null || employee.getEmployeeID().isEmpty() ||
                    (employee.getName() == null || employee.getName().isEmpty() ||
                            (employee.getSurname() == null || employee.getSurname().isEmpty()))) {
                System.out.println("ID/NAME/SURNAME cannot be empty!!!");
                return;
            }
            Employee employeeId = EMPLOYEE_STORAGE.searchEmployeeById(id);
            if (employeeId == null) {
                EMPLOYEE_STORAGE.addEmployee(employee);
                System.out.println("Employee added!");

            } else {
                System.out.println("Employee is already exists!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter correct format salary!");
        }
    }

    private static void updateEmployee() {
        System.out.println("Please enter employee ID you want update");
        String id = SCANNER.nextLine();
        if (id == null || id.isEmpty()) {
            System.out.println("ID cannot be empty!");
            return;
        }
        Employee employee = EMPLOYEE_STORAGE.searchEmployeeById(id);
        if (employee != null) {
            System.out.println("Please enter new name");
            String name = SCANNER.nextLine();
            if (name != null && !name.isEmpty()) {
                employee.setName(name);
            }
            System.out.println("Please enter new surname");
            String surname = SCANNER.nextLine();
            if (surname != null && !surname.isEmpty()) {
                employee.setSurname(surname);
            }
            try {
                System.out.println("Please enter new salary");
                String salaryStr = SCANNER.nextLine();
                if (salaryStr != null && !salaryStr.isEmpty()) {
                    employee.setSalary(Double.parseDouble(salaryStr));
                }

                System.out.println("Please enter new company");
                String company = SCANNER.nextLine();
                if (company != null && !company.isEmpty()) {
                    employee.setCompany(company);
                }
                System.out.println("Please enter new position");
                String position = SCANNER.nextLine();
                if (position != null && !position.isEmpty()) {
                    employee.setPosition(position);
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter correct format salary!");
            }
        } else {
            System.out.println("Employee not found!");
        }

    }


    private static void searchByCompany() {
        System.out.println("Please Enter company name!");
        String company = SCANNER.nextLine();
        Employee[] employeeCompany = EMPLOYEE_STORAGE.searchEmployeeByCompany(company);
        for (Employee employee : employeeCompany) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    private static void searchEmployeeByEmployeeId() {
        System.out.println("Please enter id for search");
        String id = SCANNER.nextLine();
        if (EMPLOYEE_STORAGE.searchEmployeeById(id) == null) {
            System.out.println("Cant find any employee with " + id + " ID");
        } else if (!id.isEmpty()) {
            System.out.println(EMPLOYEE_STORAGE.searchEmployeeById(id));
        } else {
            System.out.println("You are not entered any ID");
        }

    }

    private static void deleteEmployee() {
        System.out.println("Please enter employee Id for delete");
        String id = SCANNER.nextLine();
        if (EMPLOYEE_STORAGE.searchEmployeeById(id) != null) {
            EMPLOYEE_STORAGE.deleteEmployeeById(id);
            System.out.println("employee deleted");
        } else {
            System.out.println("There are not any employee");

        }
    }

}
