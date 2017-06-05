package com.eregister.PeopleService.Entity;

/**
 * Created by Szymon on 05.06.2017.
 */
public class PersonalData {
    private int idPerson;
    private String name;
    private String surname;
    private String dateOfBirth;
    private String sex;
    private String phone;
    private String mail;
    private String expirationDate;
    private int idAddress;
    private String street;
    private String houseNumber;
    private int flatNumber;
    private String postalCode;
    private String city;
    private String country;

    public PersonalData() {

    }

    public PersonalData(Person person, Address address) {
        this.idPerson = person.getId();
        this.name = person.getName();
        this.surname = person.getSurname();
        this.dateOfBirth = person.getDateOfBirth();
        this.sex = person.getSex();
        this.phone = person.getPhone();
        this.mail = person.getMail();
        this.expirationDate = person.getExpirationDate();
        this.idAddress = address.getId();
        this.street = address.getStreet();
        this.houseNumber = address.getHouseNumber();
        this.flatNumber = address.getFlatNumber();
        this.postalCode = address.getPostalCode();
        this.city = address.getCity();
        this.country = address.getCountry();
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
