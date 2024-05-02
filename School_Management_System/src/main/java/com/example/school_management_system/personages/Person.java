package com.example.school_management_system.personages;

// This is the parent class of Student, Mentor, and Teacher classes
public abstract class Person {

    // These are the attributes of the Person class
    protected String name;
    protected String lastname;
    protected String birthdate;
    protected String phone;
    protected String email;
    protected String address;
    protected String city;

    // This is the constructor of the Person class
    public Person(String name, String lastname, String birthdate, String phone, String email,
        String address, String city) {

        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.city = city;
    }

    // These are the getter methods of the Person class
    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    // These are the setter methods of the Person class
    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // This is an abstract method of the Person class
    public void printDetails() {

    }

    // This is the toString method of the Person class
    public String toString() {
        // Return the attributes of this object
        return "Name: " + name + " Lastname: " + lastname + " Birthdate: " + birthdate +
            " Phone: " + phone + " Email: " + email + " Address: " + address + " City: " + city;
    }

    // This is the equals method of the Person class
    public boolean equals(Object obj) {
        // If the object is null, return false
        if (obj == null) {
            return false;
        }
        // If the object is the same as this object, return true
        if (obj == this) {
            return true;
        }
        // If the object is not an instance of the Person class, return false
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        // Cast the object to the Person class
        Person person = (Person) obj;
        // Return true if the attributes of the object are the same as the attributes of this object
        return person.name.equals(name) && person.lastname.equals(lastname) &&
            person.birthdate.equals(birthdate) && person.phone.equals(phone) &&
            person.email.equals(email) && person.address.equals(address) && person.city.equals(city);
    }

    // This is the hashCode method of the Person class
    public int hashCode() {
        // Return the hash code of the attributes of this object
        return name.hashCode() + lastname.hashCode() + birthdate.hashCode() + phone.hashCode() +
            email.hashCode() + address.hashCode() + city.hashCode();
    }
}
