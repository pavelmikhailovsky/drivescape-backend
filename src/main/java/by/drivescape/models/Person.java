package by.drivescape.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {

    private Long id;

    @NotEmpty(message = "First name should be not empty")
    @Size(max = 150, message = "First name should be not max 150 character")
    private String firstName;

    @NotEmpty(message = "Last name should be not empty")
    @Size(max = 150, message = "Last name should be not max 150 character")
    private String lastName;

    @NotEmpty(message = "Password should be not empty")
    @Size(min = 8, message = "Password should be min 8 character")
    private String password;

    @NotEmpty(message = "Email should be not empty")
    @Email(message = "Email should be valid")
    private String email;

    private String image = String.valueOf("");

    // determines if the driver is working
    private boolean isActiveDriver = false;

    private boolean isDefaultUser = true;
    private boolean isDriver = false;
    private boolean isModerator = false;

    public Person(Long id, String firstName,
                  String lastName, String password,
                  String email, String image) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isActiveDriver() {
        return isActiveDriver;
    }

    public void setActiveDriver(boolean active) {
        isActiveDriver = active;
    }

    public boolean isDriver() {
        return isDriver;
    }

    public void setDriver(boolean driver) {
        isDriver = driver;
    }

    public boolean isModerator() {
        return isModerator;
    }

    public void setModerator(boolean moderator) {
        isModerator = moderator;
    }

    public boolean isDefaultUser() {
        return isDefaultUser;
    }

    public void setDefaultUser(boolean defaultUser) {
        isDefaultUser = defaultUser;
    }
}
