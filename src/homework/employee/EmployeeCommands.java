package homework.employee;

public interface EmployeeCommands {
    String EXIT = "0";
    String ADD_COMPANY = "1";
    String ADD_EMPLOYEE = "2";
    String PRINT_ALL_COMPANIES = "3";
    String PRINT_ALL_EMPLOYEES = "4";
    String SEARCH_EMPLOYEE_BY_EMPLOYEE_ID = "5";
    String SEARCH_EMPLOYEE_BY_COMPANY_NAME = "6";
    String DELETE_COMPANY = "7";
    String DELETE_EMPLOYEE = "8";
    String UPDATE_COMPANY = "9";
    String UPDATE_EMPLOYEE = "10";


    static void printAllCommands() {
        System.out.println("Please Enter " + EXIT + " for EXIT");
        System.out.println("Please Enter " + ADD_COMPANY + " for ADD_COMPANY");
        System.out.println("Please Enter " + ADD_EMPLOYEE + " for ADD_EMPLOYEE");
        System.out.println("Please Enter " + PRINT_ALL_COMPANIES + " for PRINT_ALL_COMPANIES");
        System.out.println("Please Enter " + PRINT_ALL_EMPLOYEES + " for PRINT_ALL_EMPLOYEES");
        System.out.println("Please Enter " + SEARCH_EMPLOYEE_BY_EMPLOYEE_ID + " for SEARCH_EMPLOYEE_BY_EMPLOYEE_ID");
        System.out.println("Please Enter " + SEARCH_EMPLOYEE_BY_COMPANY_NAME + " for SEARCH_EMPLOYEE_BY_COMPANY_NAME");
        System.out.println("Please Enter " + DELETE_COMPANY + " for DELETE_COMPANY");
        System.out.println("Please Enter " + DELETE_EMPLOYEE + " for DELETE_EMPLOYEE");
        System.out.println("Please Enter " + UPDATE_COMPANY + " for UPDATE_COMPANY");
        System.out.println("Please Enter " + UPDATE_EMPLOYEE + " for UPDATE_EMPLOYEE");

    }
}
