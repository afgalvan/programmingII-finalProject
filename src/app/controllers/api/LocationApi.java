package app.controllers.api;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.val;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A class to get the departments and cities list from Colombia. Got from a json file
 * from https://github.com/marcovega/colombia-json repo.
 */
public final class LocationApi {

    private static final Map<String, List<String>> locations;

    static {
        locations = getLocations();
    }

    /**
     * Map the json with the locations reference to a Map to relational the
     * department with a list of its cities.
     *
     * @return A map with a String as key, and a List of Strings as value.
     */
    private static Map<String, List<String>> getLocations() {
        val locations = new LinkedHashMap<String, List<String>>();
        String  jsonString = JsonUtils.readFile(
            "./src/app/controllers/api/locations.json"
        );
        JsonNode jsonNode = JsonUtils.parse(jsonString);

        assert jsonNode != null;
        List<List<String>> cities = jsonNode.findValues("ciudades")
            .stream()
            .map(c -> Arrays.asList(
                c.toString().replaceAll("[\\[\\]\"]", "").split(",")
            )).collect(Collectors.toList());

        val departments = new ArrayList<>(
            jsonNode.findValuesAsText("departamento")
        );

        for (int i = 0; i < departments.size(); i++) {
            locations.put(departments.get(i), cities.get(i));
        }

        return locations;
    }

    /**
     * Obtain all the locations of Colombia from the API, getting a Map with a
     * key for the department and a value of its cities.
     *
     * @return A map with a String as key, and a List of Strings as value.
     */
    public static Map<String, List<String>> getAll() {
        return locations;
    }

    /**
     * Get all the departments of Colombia.
     *
     * @return A List of all departments of Colombia.
     */
    public static List<String> getDepartments() {
        return new ArrayList<>(locations.keySet());
    }

    /**
     * Get all the cities from a given department of Colombia.
     *
     * @param department The name of the department to find the cities.
     * @return A List of the cities in a department.
     */
    public static List<String> getCities(String department) {
        return locations.get(department);
    }

    /**
     * Get a number of cities of a given department.
     *
     * @param department The name of the department to calculate the cities len.
     * @return A integer that is the number of cities that a department has.
     */
    public static int citiesLen(String department) {
        return locations.get(department).size();
    }

    /**
     * Get the last city from a department.
     *
     * @param department The name of the department to find last city.
     * @return The name of the last city of a department.
     */
    public static String getLastCity(String department) {
        return locations.get(department).get(citiesLen(department) - 1);
    }
}
