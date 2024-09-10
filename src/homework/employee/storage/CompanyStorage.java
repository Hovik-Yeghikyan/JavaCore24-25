package homework.employee.storage;

import homework.employee.model.Company;

public class CompanyStorage {

    Company[] companies = new Company[10];
    private int size;

    public void addCompany(Company company) {
        if (size == companies.length) {
            extend();
        }
        companies[size++] = company;
    }


    public void printAllCompanies() {
        for (int i = 0; i < size; i++) {
            System.out.println(companies[i]);
        }
    }

    public Company searchCompanyById(String id) {
        for (int i = 0; i < size; i++) {
            if (companies[i].getId().equals(id)) {
                return companies[i];
            }
        }
        return null;
    }


    public void deleteCompanyById(String id) {
        int index = getCompanyIndexById(id);
        if (index != -1) {
            for (int i = index + 1; i < size; i++) {
                companies[i - 1] = companies[i];
            }
            size--;
        }
    }

    private int getCompanyIndexById(String id) {
        for (int i = 0; i < size; i++) {
            if (companies[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    private void extend() {
        Company[] tmp = new Company[companies.length + 10];
        System.arraycopy(companies, 0, tmp, 0, companies.length);
        companies = tmp;
    }
}
