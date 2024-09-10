package homework.employee;

import homework.employee.model.Company;
import homework.employee.model.Employee;
import homework.employee.storage.CompanyStorage;
import homework.employee.storage.EmployeeStorage;

import java.util.Scanner;

public class EmployeeDemo implements EmployeeCommands {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final EmployeeStorage EMPLOYEE_STORAGE = new EmployeeStorage();
    private static final CompanyStorage COMPANY_STORAGE = new CompanyStorage();

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            EmployeeCommands.printAllCommands();
            String command = SCANNER.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;

                case ADD_COMPANY:
                    addCompany();
                    break;

                case ADD_EMPLOYEE:
                    addEmployee();
                    break;

                case PRINT_ALL_COMPANIES:
                    COMPANY_STORAGE.printAllCompanies();
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

                case DELETE_COMPANY:
                    deleteCompany();
                    break;

                case DELETE_EMPLOYEE:
                    deleteEmployee();
                    break;

                case UPDATE_COMPANY:
                    updateCompany();
                    break;

                case UPDATE_EMPLOYEE:
                    updateEmployee();
                    break;

                default:
                    System.out.println("Wrong command! Try again!");
                    break;
            }
        }
    }


    private static void addCompany() {
        System.out.println("Please input company ID");
        String id = SCANNER.nextLine();
        Company companyById = COMPANY_STORAGE.searchCompanyById(id);
        if (companyById == null) {
            System.out.println("Please input company name");
            String name = SCANNER.nextLine();
            System.out.println("Please input company address");
            String address = SCANNER.nextLine();
            System.out.println("Please input company phone");
            String phone = SCANNER.nextLine();
            Company company = new Company(id, name, address, phone);
            if (company.getId().isEmpty() || company.getName().isEmpty() ||
                    company.getAddress().isEmpty() || company.getPhone().isEmpty()) {
                System.out.println("You can't put empty fields");
                return;
            }
            COMPANY_STORAGE.addCompany(company);
            System.out.println("Company added!");
        } else {
            System.out.println("Company is already exists!");

        }
    }


    private static void addEmployee() {
        COMPANY_STORAGE.printAllCompanies();
        System.out.println("Please input company ID");
        String companyID = SCANNER.nextLine();
        Company company = COMPANY_STORAGE.searchCompanyById(companyID);
        if (company != null) {
            System.out.println("Please enter employee id");
            String id = SCANNER.nextLine();
            System.out.println("Please enter name");
            String name = SCANNER.nextLine();
            System.out.println("Please enter surname");
            String surname = SCANNER.nextLine();
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
        } else {
            System.out.println("Wrong company ID");
        }

    }

    private static void updateEmployee() {
        EMPLOYEE_STORAGE.printAllEmployees();
        System.out.println("Please enter employee ID you want update");
        String id = SCANNER.nextLine();
        if (id == null || id.isEmpty()) {
            System.out.println("ID cannot be empty!");
            return;
        }
        Employee employee = EMPLOYEE_STORAGE.searchEmployeeById(id);
        if (employee != null) {
            COMPANY_STORAGE.printAllCompanies();
            System.out.println("Please input company ID");
            String companyID = SCANNER.nextLine();
            Company company = COMPANY_STORAGE.searchCompanyById(companyID);
            if (company != null) {
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
                    employee.setCompany(company);

                    System.out.println("Please enter new position");
                    String position = SCANNER.nextLine();
                    if (position != null && !position.isEmpty()) {
                        employee.setPosition(position);
                    }
                    System.out.println("Employee updated");

                } catch (NumberFormatException e) {
                    System.out.println("Please enter correct format salary!");
                }
            } else {
                System.out.println("Wrong Company ID!");
            }

        } else {
            System.out.println("Employee not found!");
        }

    }

    private static void updateCompany() {
        COMPANY_STORAGE.printAllCompanies();
        System.out.println("Please input company ID");
        String id = SCANNER.nextLine();
        Company company = COMPANY_STORAGE.searchCompanyById(id);
        if (company != null) {
            System.out.println("Please input company new name");
            String name = SCANNER.nextLine();
            if (name != null && !name.isEmpty()) {
                company.setName(name);
            }
            System.out.println("Please input company new address");
            String address = SCANNER.nextLine();
            if (address != null && !address.isEmpty()) {
                company.setAddress(address);
            }
            System.out.println("Please input company new phone");
            String phone = SCANNER.nextLine();
            if (phone != null && !phone.isEmpty()) {
                company.setPhone(phone);
            }
            System.out.println("Company updated!");
        } else {
            System.out.println("Wrong company ID");
        }
    }


    private static void searchByCompany() {
        COMPANY_STORAGE.printAllCompanies();
        System.out.println("Please Enter company id!");
        String companyId = SCANNER.nextLine();
        Company company = COMPANY_STORAGE.searchCompanyById(companyId);
        if (company != null) {
            EMPLOYEE_STORAGE.searchEmployeeByCompany(company);
        } else {
            System.out.println("Wrong company ID");
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
        EMPLOYEE_STORAGE.printAllEmployees();
        System.out.println("Please enter employee Id for delete");
        String id = SCANNER.nextLine();
        Employee employee = EMPLOYEE_STORAGE.searchEmployeeById(id);
        if (employee != null) {
            EMPLOYEE_STORAGE.deleteEmployeeById(id);
            System.out.println("employee deleted");
        } else {
            System.out.println("There are not any employee");

        }
    }

    private static void deleteCompany() {
        COMPANY_STORAGE.printAllCompanies();
        System.out.println("Please enter company Id for delete");
        String id = SCANNER.nextLine();
        Company company = COMPANY_STORAGE.searchCompanyById(id);
        if (company != null) {
            COMPANY_STORAGE.deleteCompanyById(id);
            System.out.println("Company deleted");

        } else {

            System.out.println("Wrong company ID");
        }
    }

}
