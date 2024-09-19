package homework.medicalCenter.storage;

import homework.medicalCenter.exception.TimeNotAllowedException;
import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.model.Person;
import homework.medicalCenter.type.Profession;
import homework.medicalCenter.util.DateUtil;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

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
                    doctor.getProfession().name().equals(profession)) {
                System.out.println(doctor);
            }
        }
    }

    public Profession getDoctorsProfessionType(String profession) {
        if (profession.equals(Profession.GENERAL_PRACTITIONER.name()) ||
                profession.equals(Profession.PEDIATRICIAN.name()) ||
                profession.equals(Profession.CARDIOLOGIST.name()) ||
                profession.equals(Profession.DERMATOLOGIST.name()) ||
                profession.equals(Profession.NEUROLOGIST.name())) {
            return Profession.valueOf(profession);

        }
        return null;
    }

    //function  with deprecated methods (java util)

//    public void checkRegisterDate(String doctorId, String registerDate) throws ParseException, TimeNotAllowedException {
//        for (int i = 0; i < size; i++) {
//            if (people[i] instanceof Patient patient &&
//                    patient.getDoctor().getId().equals(doctorId)) {
//                Date patDate = patient.getRegisterDate();
//                Date regDate = DateUtil.formatStringToDate(registerDate);
//                if (patDate.getDay() == regDate.getDay() && patDate.getMonth() == regDate.getMonth() &&
//                        patDate.getYear() == regDate.getYear()) {
//                    if (regDate.getHours() == patDate.getHours() && regDate.getMinutes() - patDate.getMinutes() <= 30) {
//                        throw new TimeNotAllowedException();
//                    }
//                    if (patDate.getHours() - regDate.getHours() == 1 && regDate.getMinutes() - patDate.getMinutes() >= 30) {
//                        throw new TimeNotAllowedException();
//                    }
//                }
//            }
//        }
//    }

    public void checkRegisterDate(String doctorId,Date date) throws TimeNotAllowedException {
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Patient patient &&
                    patient.getDoctor().getId().equals(doctorId)) {
                Date patDate = patient.getRegisterDate();
                calendar.setTime(patDate);
                calendar.add(Calendar.MINUTE, 30);
                Date thirtyAfter = calendar.getTime();
                calendar.setTime(patDate);
                calendar.add(Calendar.MINUTE, -30);
                Date thirtyBefore = calendar.getTime();
                if (date.after(thirtyBefore) && date.before(thirtyAfter)) {
                    throw new TimeNotAllowedException();
                }
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
