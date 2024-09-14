package homework.medicalCenter.storage;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.model.Person;

public class PersonStorage {
    private Person[] people = new Person[10];
    private int size;

    public void add(Person person) {
        if (size == this.people.length) {
            extend();
        }
        people[size++] = person;
    }

    public void printAllPatients() {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Patient) {
                System.out.println(people[i]);
            }
        }
    }

    public void printAllPatientsByDoctor(Doctor doctor) {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Patient patient &&
                    patient.getDoctor().equals(doctor)) {
                System.out.println(patient);
            }
        }
    }

    public void printAllDoctors() {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Doctor) {
                System.out.println(people[i]);
            }
        }
    }

    public void searchDoctorByProfession(String profession) {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Doctor doctor &&
                    doctor.getProfession().equals(profession)) {
                System.out.println(doctor);
            }
        }
    }

    public Doctor searchDoctorByID(String id) {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Doctor doctor) {
                if (doctor.getId().equals(id)) {
                    return doctor;
                }
            }
        }
        return null;
    }

    public Patient searchPatientByID(String id) {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Patient patient) {
                if (patient.getId().equals(id)) {
                    return patient;
                }
            }
        }
        return null;
    }

    public void deleteDoctorByID(String id) {
        for (int i = 0; i < size; i++) {
            Person person = people[i];
            if (person.getId().equals(id) && person instanceof Doctor) {
                deleteDoctorByIndex(i);
            }
        }

    }

    private void deleteDoctorByIndex(int index) {
        for (int i = index + 1; i < size; i++) {
            people[i - 1] = people[i];
        }
        size--;
    }

    private void extend() {
        Person[] tmp = new Person[people.length * 2];
        System.arraycopy(people, 0, tmp, 0, people.length);
        people = tmp;
    }
}
