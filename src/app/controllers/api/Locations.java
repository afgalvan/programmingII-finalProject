package app.controllers.api;

import app.exceptions.InvalidLocationException;
import app.models.annotations.TestedOn;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import lombok.val;
import test.controllers.api.LocationsTest;

/**
 * A class to get the departments and cities list from Colombia. Got from a json file
 * from https://github.com/marcovega/colombia-json repository.
 */
@TestedOn(LocationsTest.class)
public final class Locations {

    private static final Map<String, List<String>> locations;

    static {
        locations = getLocations();
    }

    private static JsonNode getJsonNode() {
        val jsonPath = "./src/app/controllers/api/locations.json";
        String jsonString = JsonUtils.readFile(jsonPath);
        return JsonUtils.parse(jsonString);
    }

    private static List<String> nodeToList(JsonNode node) {
        return Arrays.asList(
            node.toString().toLowerCase().replaceAll("[\\[\\]\"]", "").split(",")
        );
    }

    private static List<List<String>> parseCities(JsonNode jsonNode) {
        return jsonNode
            .findValues("ciudades")
            .stream()
            .map(Locations::nodeToList)
            .collect(Collectors.toList());
    }

    private static List<String> parseDepartments(JsonNode jsonNode) {
        return new ArrayList<>(jsonNode.findValuesAsText("departamento"));
    }

    private static Map<String, List<String>> linkLocations(
        List<String> departments,
        List<List<String>> cities
    ) {
        val locationsMap = new LinkedHashMap<String, List<String>>();
        for (int i = 0; i < departments.size(); i++) {
            locationsMap.put(departments.get(i).toLowerCase(), cities.get(i));
        }

        return locationsMap;
    }

    /**
     * @return A map with a String as key, and a List of Strings as value.
     */
    private static Map<String, List<String>> getLocations() {
        /*
         * FIXME: Issue #100 - Improve json parsing by using built-in jackson methods
         * Map the json with the locations reference to a Map to relational the
         * department with a list of its cities.
         */
        JsonNode jsonNode = getJsonNode();
        if (jsonNode == null) {
            return new HashMap<>();
        }
        List<List<String>> cities = parseCities(jsonNode);
        List<String> departments = parseDepartments(jsonNode);
        return linkLocations(departments, cities);
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
        val lowerCaseDepartment = department.toLowerCase();
        return locations.get(lowerCaseDepartment);
    }

    /**
     * Get a number of cities of a given department.
     *
     * @param department The name of the department to calculate the cities len.
     * @return A integer that is the number of cities that a department has.
     */
    public static int citiesLen(String department) {
        val lowerCaseDepartment = department.toLowerCase();
        return locations.get(lowerCaseDepartment).size();
    }

    /**
     * Get the last city from a department.
     *
     * @param department The name of the department to find last city.
     * @return The name of the last city of a department.
     */
    public static String getLastCityOf(String department) {
        int lastCityIndex = citiesLen(department) - 1;
        return getCities(department).get(lastCityIndex);
    }

    /**
     * @param department A {@code String} representing the name of a department in Colombia.
     *
     * @return if is an existing department.
     */
    public static boolean isValidDepartment(String department) {
        return Locations.getAll().containsKey(department.toLowerCase());
    }

    /**
     * @param department A {@code String} representing the name of a department in Colombia.
     * @param city A {@code String} representing the name of a city of the given department.
     *
     * @return if a city belongs to the given department.
     */
    public static boolean isValidCityOf(String department, String city) {
        List<String> cities = Locations.getCities(department);
        return cities != null && cities.contains(city.toLowerCase());
    }

    /**
     *
     * @param department A {@code String} representing the name of a department in Colombia.
     * @return the same name in case of a validation.
     *
     * @throws InvalidLocationException if a invalid department is given.
     */
    public static String throwForDepartment(String department)
        throws InvalidLocationException {
        if (!isValidDepartment(department)) {
            throw new InvalidLocationException("El departamento no existe");
        }
        return department;
    }

    /**
     * @param department
     * @param city
     * @return
     */
    public static String throwForCity(String department, String city)
        throws InvalidLocationException {
        if (!isValidCityOf(department.toLowerCase(), city.toLowerCase())) {
            throw new InvalidLocationException(
                "La ciudad no pertenece a este departamento"
            );
        }

        return city;
    }
}
