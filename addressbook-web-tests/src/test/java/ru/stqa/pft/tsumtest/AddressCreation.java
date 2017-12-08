package ru.stqa.pft.tsumtest;

public class AddressCreation {
    private final String street;
    private final String zip;
    private final String house;
    private final String structure;
    private final String apartment;

    public AddressCreation(String Street, String zip, String house, String structure, String apartment) {
        street = Street;
        this.zip = zip;
        this.house = house;
        this.structure = structure;
        this.apartment = apartment;
    }

    public String getStreet() {
        return street;
    }

    public String getZip() {
        return zip;
    }

    public String getHouse() {
        return house;
    }

    public String getStructure() {
        return structure;
    }

    public String getApartment() {
        return apartment;
    }
}
