package org.sberatart.cities.utils;

import org.sberatart.cities.model.City;

public class MyParser {
    public static int tryParseInt(String s) {
        try {
            return Integer.parseInt(s.trim());
        }
        catch (NumberFormatException ex) {
            System.out.println("Incorrect number");
            String result = "";
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (Character.isDigit(c)) {
                    result += c;
                }
            }
            if (result.length() != 0 && result.length() < 16) {
                return  Integer.parseInt(result);
            }
            else {
                return 0;
            }
        }
    }
    public static City tryParseCity (String s) {
        String[] fields = s.split(";");
        City city = new City();
        if (fields.length == 5) {
            city.name = fields[0];
            city.region = fields[1];
            city.district = fields[2];
            city.population = MyParser.tryParseInt(fields[3]);
            city.foundation = MyParser.tryParseInt(fields[4]);
        }
        return city;
    }
}
