package org.sberatart.cities.utils;

import org.sberatart.cities.model.City;
import org.sberatart.cities.services.CityDictionary;

import java.io.IOException;
import java.util.Map;


public class PrintHelper {
    public static void DoDictionaryCheck () throws IOException {
        CityDictionary.readDictionaryFromFile("src/main/resources/someText.txt");
        for (City city : CityDictionary.getCities()) {
            System.out.println(city);
        }
        CityDictionary.sortAlphabetically();
        for (City city : CityDictionary.getCities()) {
            System.out.println(city);
        }
        CityDictionary.sortAlphabeticallyByDistrict();
        for (City city : CityDictionary.getCities()) {
            System.out.println(city);
        }
        System.out.println("[" + CityDictionary.getMaxPopulation().index + "] Population: " + CityDictionary.getMaxPopulation().population);
        for (Map.Entry<String, Integer> kvp : CityDictionary.getCitiesCountByRegions().entrySet()) {
            System.out.println(kvp.getKey() + ": " + kvp.getValue());
        }
    }
}
