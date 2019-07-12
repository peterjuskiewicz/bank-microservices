package cz.juskiewi.creditmicroservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Credit {


    private int id;
//    @JsonIgnore
    private String creditName;

    public Credit() {
    }

    public Credit(int id, String creditName) {
        this.id = id;
        this.creditName = creditName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                ", creditName='" + creditName + '\'' +
                '}';
    }
}
