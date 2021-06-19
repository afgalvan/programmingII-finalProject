package app.controllers;

import app.controllers.api.Locations;
import app.exceptions.InvalidLocationException;
import java.util.List;
import lombok.SneakyThrows;

/**
 *
 */
public class LocationController {

    private static final LocationController instance = new LocationController();

    private LocationController() {}

    public static LocationController getInstance() {
        return instance;
    }

    /**
     * @param department
     * @return
     */
    public boolean isValidDepartment(String department) {
        return Locations.getAll().containsKey(department.toLowerCase());
    }

    /**
     * @param department
     * @param city
     * @return
     */
    public boolean isValidCityOf(String department, String city) {
        List<String> cities = Locations.getCities(department);
        return cities != null && cities.contains(city.toLowerCase());
    }

    /**
     * @param department
     * @return
     */
    @SneakyThrows
    public String throwForDepartment(String department) {
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
    @SneakyThrows
    public String throwForCity(String department, String city) {
        if (!isValidCityOf(department.toLowerCase(), city.toLowerCase())) {
            throw new InvalidLocationException(
                "La ciudad no pertenece a este departamento"
            );
        }
        return city;
    }
}
