package org.sberatart.cities.model;

import org.sberatart.cities.utils.MyParser;

public class City {

    public String name;
    public String region;
    public String district;
    public int population;
    public int foundation;
    public int index;

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation=" + foundation +
                '}';
    }
}
