package homework.medicalCenter.model;

import homework.medicalCenter.util.DateUtil;

import java.util.Date;

public class Patient extends Person {

    private Doctor doctor;
    private Date registerDate;


    public Patient() {
    }

    public Patient(String id, String name, String surname, String phoneNumber, Doctor doctor, Date registerDate) {
        super(id, name, surname, phoneNumber);
        this.doctor = doctor;
        this.registerDate = registerDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient patient)) return false;
        if (!super.equals(o)) return false;

        if (getDoctor() != null ? !getDoctor().equals(patient.getDoctor()) : patient.getDoctor() != null) return false;
        return getRegisterDate() != null ? getRegisterDate().equals(patient.getRegisterDate()) : patient.getRegisterDate() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getDoctor() != null ? getDoctor().hashCode() : 0);
        result = 31 * result + (getRegisterDate() != null ? getRegisterDate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "doctor=" + doctor +
                ", registerDate=" + DateUtil.formatDateToString(registerDate) +
                "} " + super.toString();
    }
}
