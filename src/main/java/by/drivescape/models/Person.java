package by.drivescape.models;

public class Person {

    private Long personId;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String image;

    // determines if the driver is working
    private boolean isActiveDriver;

    private boolean isDefaultUser;
    private boolean isDriver;
    private boolean isModerator;

    public Person() {}

    public Person(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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

    public boolean getIsActiveDriver() {
        return isActiveDriver;
    }

    public void setIsActiveDriver(boolean isActiveDriver) {
        this.isActiveDriver = isActiveDriver;
    }

    public boolean getIsDefaultUser() {
        return isDefaultUser;
    }

    public void setIsDefaultUser(boolean IsDefaultUser) {
        this.isDefaultUser = IsDefaultUser;
    }

    public boolean getIsDriver() {
        return isDriver;
    }

    public void setIsDriver(boolean isDriver) {
        this.isDriver = isDriver;
    }

    public boolean getIsModerator() {
        return isModerator;
    }

    public void setIsModerator(boolean isModerator) {
        this.isModerator = isModerator;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", image='" + image + '\'' +
                ", isActiveDriver=" + isActiveDriver +
                ", isDefaultUser=" + isDefaultUser +
                ", isDriver=" + isDriver +
                ", isModerator=" + isModerator +
                '}';
    }
}
