package homework.medicalCenter;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.storage.PersonStorage;
import homework.medicalCenter.util.DateUtil;

import java.text.ParseException;
import java.util.Scanner;

public class MedicalMain implements Commands {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final PersonStorage PERSON_STORAGE = new PersonStorage();


    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            Commands.printAllCommands();
            String command = SCANNER.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;

                case ADD_DOCTOR:
                    addDoctor();
                    break;

                case SEARCH_DOCTOR_BY_PROFESSION:
                    searchDoctorByProfession();
                    break;

                case DELETE_DOCTOR_BY_ID:
                    deleteDoctor();
                    break;

                case CHANGE_DOCTOR_BY_ID:
                    updateDoctor();
                    break;

                case ADD_PATIENT:
                    addPatient();
                    break;

                case PRINT_ALL_PATIENTS_BY_DOCTOR:
                    printPatientsByDoctor();
                    break;

                case PRINT_ALL_PATIENTS:
                    PERSON_STORAGE.printAllPatients();
                    break;

                default:
                    System.out.println("Wrong command!!! Please try again!");
            }
        }
    }


    private static void addPatient() {
        PERSON_STORAGE.printAllDoctors();
        System.out.println("Please select your doctor id");
        String doctorId = SCANNER.nextLine();
        Doctor doctorByID = PERSON_STORAGE.searchDoctorByID(doctorId);
        if (doctorByID != null) {
            System.out.println("Please input patient id");
            String id = SCANNER.nextLine();
            Patient patientByID = PERSON_STORAGE.searchPatientByID(id);
            if (patientByID == null) {
                try {
                    System.out.println("Please input patient name");
                    String name = SCANNER.nextLine();
                    System.out.println("Please input patient surname");
                    String surname = SCANNER.nextLine();
                    System.out.println("Please input patient phone number");
                    String phone = SCANNER.nextLine();
                    System.out.println("Please input  register date and time (01-10-2000 20:00)");
                    String registerDateTime = SCANNER.nextLine();
                    Patient patient = new Patient(id, name, surname, phone, doctorByID, DateUtil.formatStringToDate(registerDateTime));
                    if (patient.getId().isEmpty() || patient.getName().isEmpty() ||
                            patient.getSurname().isEmpty() || patient.getPhoneNumber().isEmpty()) {
                        System.out.println("You can't put empty fields");
                        return;
                    }
                    PERSON_STORAGE.add(patient);
                    System.out.println("Patient added!");
                } catch (ParseException e) {
                    System.out.println("Incorrect register date/time");
                }
            } else {
                System.out.println("Patient is already exists!");
            }
        } else {
            System.out.println("Wrong doctor ID!!! Try again!");

        }

    }

    private static void addDoctor() {
        System.out.println("Please input Doctor ID");
        String id = SCANNER.nextLine();
        Doctor doctorByID = PERSON_STORAGE.searchDoctorByID(id);
        if (doctorByID == null) {
            System.out.println("Please input doctor name");
            String name = SCANNER.nextLine();
            System.out.println("Please input doctor surname");
            String surname = SCANNER.nextLine();
            System.out.println("Please input doctor phone number");
            String phone = SCANNER.nextLine();
            System.out.println("Please input doctor email");
            String email = SCANNER.nextLine();
            System.out.println("Please input doctor profession");
            String profession = SCANNER.nextLine();
            Doctor doctor = new Doctor(id, name, surname, phone, email, profession);
            if (doctor.getId().isEmpty() || doctor.getName().isEmpty() ||
                    doctor.getSurname().isEmpty() || doctor.getPhoneNumber().isEmpty() ||
                    doctor.getEmail().isEmpty() || doctor.getProfession().isEmpty()) {
                System.out.println("You can't put empty fields");
                return;
            }
            PERSON_STORAGE.add(doctor);
            System.out.println("Doctor added!");
        } else {
            System.out.println("Doctor with id " + id + " already exists!");
        }
    }

    private static void updateDoctor() {
        PERSON_STORAGE.printAllDoctors();
        System.out.println("Please input doctor id to update");
        String id = SCANNER.nextLine();
        Doctor doctorByID = PERSON_STORAGE.searchDoctorByID(id);
        if (doctorByID != null) {
            System.out.println("Please input doctors new name");
            String name = SCANNER.nextLine();
            if (name != null && !name.isEmpty()) {
                doctorByID.setName(name);
            }
            System.out.println("Please input doctors new surname");
            String surname = SCANNER.nextLine();
            if (surname != null && !surname.isEmpty()) {
                doctorByID.setSurname(surname);
            }
            System.out.println("Please input doctors new phone");
            String phone = SCANNER.nextLine();
            if (phone != null && !phone.isEmpty()) {
                doctorByID.setPhoneNumber(phone);
            }
            System.out.println("Please input doctors new email");
            String email = SCANNER.nextLine();
            if (email != null && !email.isEmpty()) {
                doctorByID.setEmail(email);
            }
            System.out.println("Please input doctors new profession");
            String profession = SCANNER.nextLine();
            if (profession != null && !profession.isEmpty()) {
                doctorByID.setProfession(profession);
            }
            System.out.println("Doctor updated!");

        } else {
            System.out.println("Wrong ID!!! Try again!");
        }

    }

    private static void printPatientsByDoctor() {
        System.out.println("Please input doctor id for search patients");
        String id = SCANNER.nextLine();
        Doctor doctorByID = PERSON_STORAGE.searchDoctorByID(id);
        if (doctorByID != null) {
            PERSON_STORAGE.printAllPatientsByDoctor(doctorByID);
        } else {
            System.out.println("Wrong doctor ID!!! Try again!");
        }
    }

    private static void deleteDoctor() {
        PERSON_STORAGE.printAllDoctors();
        System.out.println("Please input doctor id for delete");
        String id = SCANNER.nextLine();
        Doctor doctorByID = PERSON_STORAGE.searchDoctorByID(id);
        if (doctorByID != null) {
            PERSON_STORAGE.deleteDoctorByID(id);
            System.out.println("Doctor deleted!");
        } else {
            System.out.println("Wrong ID!!! Try again!");
        }

    }

    private static void searchDoctorByProfession() {
        System.out.println("Please input doctors profession");
        String profession = SCANNER.nextLine();
        PERSON_STORAGE.searchDoctorByProfession(profession);


    }

}
