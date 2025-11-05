package prac12;

import java.util.StringTokenizer;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String building;
    private String apartment;

    // Разбор адреса с разделителем ","
    public void parseAddressComma(String address) {
        String[] parts = address.split(",");
        if (parts.length == 7) {
            country = parts[0].trim();
            region = parts[1].trim();
            city = parts[2].trim();
            street = parts[3].trim();
            house = parts[4].trim();
            building = parts[5].trim();
            apartment = parts[6].trim();
        }
    }

    // Разбор адреса с разделителем ',', '.', ';' с использованием StringTokenizer
    public void parseAddressTokenizer(String address) {
        StringTokenizer tokenizer = new StringTokenizer(address, ",.;");
        if (tokenizer.countTokens() == 7) {
            country = tokenizer.nextToken().trim();
            region = tokenizer.nextToken().trim();
            city = tokenizer.nextToken().trim();
            street = tokenizer.nextToken().trim();
            house = tokenizer.nextToken().trim();
            building = tokenizer.nextToken().trim();
            apartment = tokenizer.nextToken().trim();
        }
    }

    @Override
    public String toString() {
        return "Country: " + country + "\nRegion: " + region + "\nCity: " + city +
               "\nStreet: " + street + "\nHouse: " + house + "\nBuilding: " + building +
               "\nApartment: " + apartment;
    }

    public static void main(String[] args) {
        Address address1 = new Address();
        address1.parseAddressComma("Russia, Moscow, Moscow City, Tverskaya, 12, Building 3, Apt 45");
        System.out.println(address1);

        Address address2 = new Address();
        address2.parseAddressTokenizer("Russia; Moscow; Moscow City; Tverskaya; 12; Building 3; Apt 45");
        System.out.println(address2);
    }
}

