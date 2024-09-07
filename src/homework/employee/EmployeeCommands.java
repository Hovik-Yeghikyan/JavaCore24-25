package homework.employee;

public interface EmployeeCommands {
    String EXIT = "0";
    String ADD_EMPLOYEE = "1";
    String PRINT_ALL_EMPLOYEES = "2";
    String SEARCH_EMPLOYEE_BY_EMPLOYEE_ID = "3";
    String SEARCH_EMPLOYEE_BY_COMPANY_NAME = "4";
    String DELETE_EMPLOYEE = "5";
    String UPDATE_EMPLOYEE = "6";


    static void printAllCommands() {
        System.out.println("Please Enter " + EXIT + " for EXIT");
        System.out.println("Please Enter " + ADD_EMPLOYEE + " for ADD_EMPLOYEE");
        System.out.println("Please Enter " + PRINT_ALL_EMPLOYEES + " for PRINT_ALL_EMPLOYEES");
        System.out.println("Please Enter " + SEARCH_EMPLOYEE_BY_EMPLOYEE_ID + " for SEARCH_EMPLOYEE_BY_EMPLOYEE_ID");
        System.out.println("Please Enter " + SEARCH_EMPLOYEE_BY_COMPANY_NAME + " for SEARCH_EMPLOYEE_BY_COMPANY_NAME");
        System.out.println("Please Enter " + DELETE_EMPLOYEE + " for DELETE_EMPLOYEE");
        System.out.println("Please Enter " + UPDATE_EMPLOYEE + " for UPDATE_EMPLOYEE");

    }
}
