package classwork.classwork12;

public enum Language {
    ARM("Armenia"),
    RU("Russia"),
    ENG("USA"),
    FR("France");

    private String countryName;

    Language(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
}
