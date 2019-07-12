package cz.juskiewi.creditmicroservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Customer {

//    @JsonIgnore
    private int creditId;

    private String firstName;
    private String pesel;
    private String lastName;

    public Customer() {
    }

    public Customer(int creditId, String firstName, String pesel, String lastName) {
        this.creditId = creditId;
        this.firstName = firstName;
        this.pesel = pesel;
        this.lastName = lastName;
    }

    public int getCreditId() {
        return creditId;
    }

    public void setCreditId(int creditId) {
        this.creditId = creditId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "creditId=" + creditId +
                ", firstName='" + firstName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
