package homework.medicalCenter;

public interface Commands {

    String EXIT = "0";
    String ADD_DOCTOR = "1";
    String SEARCH_DOCTOR_BY_PROFESSION = "2";
    String DELETE_DOCTOR_BY_ID = "3";
    String CHANGE_DOCTOR_BY_ID = "4";
    String ADD_PATIENT = "5";
    String PRINT_ALL_PATIENTS_BY_DOCTOR = "6";
    String PRINT_ALL_PATIENTS = "7";


    static void printAllCommands() {
        System.out.println("Please input " + EXIT  + " for EXIT");
        System.out.println("Please input " + ADD_DOCTOR  + " for ADD DOCTOR");
        System.out.println("Please input " + SEARCH_DOCTOR_BY_PROFESSION  + " for SEARCH DOCTOR BY PROFESSION");
        System.out.println("Please input " + DELETE_DOCTOR_BY_ID  + " for DELETE DOCTOR BY ID");
        System.out.println("Please input " + CHANGE_DOCTOR_BY_ID  + " for CHANGE DOCTOR BY ID");
        System.out.println("Please input " + ADD_PATIENT  + " for ADD PATIENT");
        System.out.println("Please input " + PRINT_ALL_PATIENTS_BY_DOCTOR  + " for PRINT ALL PATIENTS BY DOCTOR");
        System.out.println("Please input " + PRINT_ALL_PATIENTS  + " for PRINT ALL PATIENTS");

    }

}
