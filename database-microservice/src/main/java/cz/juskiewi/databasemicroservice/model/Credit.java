package cz.juskiewi.databasemicroservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Credit {

    @Id
    @GeneratedValue
    private int id;

    private String creditName;

    public Credit() {
    }

    public Credit(String creditName) {
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
