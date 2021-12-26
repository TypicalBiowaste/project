package com.artem;

public class Base {
    private final String number;
    private final String address;
    private final String appellation;
    private final String numberFloor;
    private final String prefixCode;
    private final String yearConstruction;

    public Base(String number, String address, String appellation, String numberFloor, String prefixCode, String yearConstruction) {
        this.number = number;
        this.address = address;
        this.appellation = appellation;
        this.numberFloor = numberFloor;
        this.prefixCode = prefixCode;
        this.yearConstruction = yearConstruction;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public String getAppellation() {
        return appellation;
    }

    public String getNumberFloor() {
        return numberFloor;
    }

    public String getPrefixCode() {
        return prefixCode;
    }

    public String getYearConstruction() {
        return yearConstruction;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("{").append(", number='").append(number).append('\'').append(", address='").append(address).append('\'').append(", appellation='").append(appellation).append('\'').append(", numberFloor='").append(numberFloor).append('\'').append(", prefixCode='").append(prefixCode).append('\'').append(", yearConstruction='").append(yearConstruction).append('\'').append('}').toString();
    }
}
