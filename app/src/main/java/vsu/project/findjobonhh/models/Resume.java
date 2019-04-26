package vsu.project.findjobonhh.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class Resume {

    @SerializedName("lastName")
    @Expose
    private String lastName;

    @SerializedName("firstName")
    @Expose
    private String firstName;

    @SerializedName("middleName")
    @Expose
    private String middleName;

    @SerializedName("birthDate")
    @Expose
    private String birthDate;

    @SerializedName("gender")
    @Expose
    private Gender gender;

    @SerializedName("photo")
    @Expose
    private Photo photo;

    @SerializedName("portfolio")
    @Expose
    private List<Portfolio> portfolios;

    @SerializedName("contact")
    @Expose
    private List<Contact> contacts;

    public Resume() {
    }

    public Resume(String lastName, String firstName, String middleName, String birthDate,
                  Gender gender, Photo photo, List<Portfolio> portfolios, List<Contact> contacts) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.photo = photo;
        this.portfolios = portfolios;
        this.contacts = contacts;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public List<Portfolio> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(List<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(lastName, resume.lastName) &&
                Objects.equals(firstName, resume.firstName) &&
                Objects.equals(middleName, resume.middleName) &&
                Objects.equals(birthDate, resume.birthDate) &&
                Objects.equals(gender, resume.gender) &&
                Objects.equals(photo, resume.photo) &&
                Objects.equals(portfolios, resume.portfolios) &&
                Objects.equals(contacts, resume.contacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName, birthDate, gender, photo, portfolios, contacts);
    }

    @Override
    public String toString() {
        return "Resume{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", gender=" + gender +
                ", photo=" + photo +
                ", portfolios=" + portfolios +
                ", contacts=" + contacts +
                '}';
    }
}
