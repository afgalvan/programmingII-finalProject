package app.controllers;

import app.controllers.api.Json;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import java.util.stream.Collectors;

public class Location {

    private static final Map<String, List<String>> locations;

    static {
        locations = getLocations();
    }

    /**
     *
     * @return
     */
    private static Map<String, List<String>> getLocations() {
        Map<String, List<String>> locations = new LinkedHashMap<>();
        JsonNode jsonNode = Json.parse("./src/app/models/api/locations.json");

        assert jsonNode != null;
        List<List<String>> cities = jsonNode
            .findValues("ciudades")
            .stream()
            .map(c -> Arrays.asList(c.toString().replaceAll("[\\[\\]\"]", "").split(",")))
            .collect(Collectors.toList());

        List<String> departments = new ArrayList<>(jsonNode.findValuesAsText("departamento"));

        for (int i = 0; i < departments.size(); i++) {
            locations.put(departments.get(i), cities.get(i));
        }

        return locations;
    }

    /**
     *
     * @return A map of key for the department and a value of its cities.
     */
    public static Map<String, List<String>> getAll() {
        return locations;
    }

    /**
     *
     * @return All the departments of Colombia.
     */
    public static Set<String> getDepartments() {
        return locations.keySet();
    }

    /**
     *
     * @param department the name of the department to find the cities.
     * @return A List of the cities in a department.
     */
    public static List<String> getCities(String department) {
        return locations.get(department);
    }
}
