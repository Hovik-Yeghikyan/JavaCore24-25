package classwork.bookStorage.model;

import classwork.bookStorage.util.DateUtil;

import java.util.Date;

public class Author {

    private String id;
    private  String name;
    private  String surname;
    private  String phone;
    private Date dateOfBirthday;

    public Author() {
    }

    public Author(String id, String name, String surname, String phone, Date dateOfBirthday) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(Date dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;

        if (getId() != null ? !getId().equals(author.getId()) : author.getId() != null) return false;
        if (getName() != null ? !getName().equals(author.getName()) : author.getName() != null) return false;
        if (getSurname() != null ? !getSurname().equals(author.getSurname()) : author.getSurname() != null)
            return false;
        if (getPhone() != null ? !getPhone().equals(author.getPhone()) : author.getPhone() != null) return false;
        return getDateOfBirthday() != null ? getDateOfBirthday().equals(author.getDateOfBirthday()) : author.getDateOfBirthday() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getDateOfBirthday() != null ? getDateOfBirthday().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirthday=" + DateUtil.fromDateToString(dateOfBirthday) +
                '}';
    }
}
