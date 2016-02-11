package com.sergeyry.gymtrainer.model;


import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.Size;



@Entity
@Table(name="USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=3, max=45)
    @NotEmpty
    @Column(name = "LOGIN", nullable = false)
    private String login;

    @Size(min=3, max=45)
    @NotEmpty
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Size(min=3, max=45)
    @NotEmpty
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Size(min=5, max=45)
    @NotEmpty
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Size(min=5, max=45)
    @NotEmpty
    @Column(name = "EMAIL", nullable = false)
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (id != other.id)
            return false;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User: " + firstName + " " + lastName;
    }

}
