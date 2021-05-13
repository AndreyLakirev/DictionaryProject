import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sberatart.cities.model.City;
import org.sberatart.cities.services.CityDictionary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CityDictionaryTest {
    public static String testFilePath = "src/test/test.txt";
    @BeforeClass
    public static void setDictionary () throws IOException {
        String example = "Санкт-Петербург;Санкт-Петербург;Северо-Западный;5000000;1703/" +
                "Москва;Москва;Центральный;11200000;1147;/" +
                "Псков;Псков;Северо-Западный;0;0/" +
                "Архангельск;Архангельск;Северо-Западный;0;0";
        File file = new File(testFilePath);
        file.setWritable(true);
        file.setReadable(true);
        FileWriter writer = new FileWriter(file);
        writer.write(example);
        writer.close();
        CityDictionary.readDictionaryFromFile(file.getPath());
    }
    @AfterClass
    public static void shutDown () {
        File file = new File(testFilePath);
        file.delete();
    }
    @After
    public void testCompleted () {
        System.out.println("Test completed");
    }
    @Test
    public void fileReadTest ()  {

        String result = "";
        for (City city : CityDictionary.getCities()) {
            result += city.toString();
        }
        assertEquals(result, "City{name='Санкт-Петербург', region='Санкт-Петербург', district='Северо-Западный', population=5000000, foundation=1703}" +
                "City{name='Москва', region='Москва', district='Центральный', population=11200000, foundation=1147}" +
                "City{name='Псков', region='Псков', district='Северо-Западный', population=0, foundation=0}" +
                "City{name='Архангельск', region='Архангельск', district='Северо-Западный', population=0, foundation=0}");
    }

    @Test
    public void maxPopulationTest () {
        CityDictionary.sortAlphabetically();
        assertEquals("[" + CityDictionary.getMaxPopulation().index + "] Population: " + CityDictionary.getMaxPopulation().population,
                "[2] Population: 11200000");
    }

    @Test
    public void citiesCountByRegionsTest () {
        assertEquals(CityDictionary.getCitiesCountByRegions().toString(), "{Архангельск=1, Москва=1, Санкт-Петербург=1, Псков=1}");
    }

    @Test
    public void alphabeticalSortTest () {
        CityDictionary.sortAlphabetically();
        String result = "";
        for (City city : CityDictionary.getCities()) {
            result += city.toString();
        }
        assertEquals(result, "City{name='Архангельск', region='Архангельск', district='Северо-Западный', population=0, foundation=0}" +
                "City{name='Москва', region='Москва', district='Центральный', population=11200000, foundation=1147}" +
                "City{name='Псков', region='Псков', district='Северо-Западный', population=0, foundation=0}" +
                "City{name='Санкт-Петербург', region='Санкт-Петербург', district='Северо-Западный', population=5000000, foundation=1703}");
    }

    @Test
    public void sortByDistrictsTest () {
        CityDictionary.sortAlphabeticallyByDistrict();
        String result = "";
        for (City city : CityDictionary.getCities()) {
            result += city.toString();
        }
        assertEquals(result, "City{name='Москва', region='Москва', district='Центральный', population=11200000, foundation=1147}" +
                "City{name='Архангельск', region='Архангельск', district='Северо-Западный', population=0, foundation=0}" +
                "City{name='Псков', region='Псков', district='Северо-Западный', population=0, foundation=0}" +
                "City{name='Санкт-Петербург', region='Санкт-Петербург', district='Северо-Западный', population=5000000, foundation=1703}");
    }
}
