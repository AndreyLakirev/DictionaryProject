package org.sberatart.cities.services;

import org.sberatart.cities.model.City;
import org.sberatart.cities.utils.MyParser;
import org.sberatart.cities.utils.PrintHelper;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class CityDictionary {

    private static ArrayList<City> cities = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        PrintHelper.DoDictionaryCheck();
    }

    public static int getDistrictIndex (String district) {
        switch (district) {
            case "Центральный" : return 1;
            case "Северо-Западный" : return 2;
            case "Южный" : return 3;
            case "Северо-Кавказский" : return 4;
            case "Приволжский" : return 5;
            case "Уральский" : return 6;
            case "Сибирский" : return 7;
            case "Дальневосточный" : return 8;
            default : return 9;
        }
    }

    public static ArrayList<City> getCities() {
        return cities;
    }

    //Модуль 4
    public static Map<String, Integer> getCitiesCountByRegions() {
        Map<String, Integer> map = new HashMap<>();
        for (City city : cities) {
            if (map.containsKey(city.region)) {
                map.replace(city.region, map.get(city.region), map.get(city.region) + 1);
            }
            else {
                map.put(city.region, 1);
            }
        }
        return map;
    }

    //Модуль 3
    public static City getMaxPopulation() {
        City[] cityArray = new City[cities.size()];
        cities.toArray(cityArray);
        int max = 0;
        int index = 0;
        for (int i = 0; i < cityArray.length; i++) {
            if (cityArray[i].population > max) {
                max = cityArray[i].population;
                index = i;
            }
        }
        return cities.get(index);
    }

    // Модуль 2
    public static void sortAlphabetically() {
        cities.sort((lc, rc) -> (lc.name.compareTo(rc.name)));
    }

    public static void sortAlphabeticallyByDistrict() {
        cities.sort(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                if (getDistrictIndex(o1.district) < getDistrictIndex(o2.district)) {
                    return -1;
                }
                else if (getDistrictIndex(o1.district) > getDistrictIndex(o2.district)) {
                    return 1;
                }
                else {
                    return o1.name.compareTo(o2.name);
                }
            }
        });
    }

    //Модуль 1
    public static void readDictionaryFromFile(String path) throws IOException {
        String result = "";
        try (FileReader reader = new FileReader(path)) {
            int c;
            while ((c = reader.read()) != -1) {
                result += (char) c;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        String[] citiesData = result.split("/");
        for (int i = 1; i <= citiesData.length; i++) {
            City city = MyParser.tryParseCity(citiesData[i - 1]);
            city.index = i;
            cities.add(city);
        }
    }
}
