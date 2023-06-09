package ru.netology.entity;

public class Location {

    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", country=" + country +
                ", street='" + street + '\'' +
                ", builing=" + builing +
                '}';
    }

    private final String city;

    private final Country country;

    private final String street;

    private final int builing;

    public Location(String city, Country country, String street, int builing) {
            this.city = city;
            this.country = country;
            this.street = street;
            this.builing = builing;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public int getBuiling() {
        return builing;
    }

}
