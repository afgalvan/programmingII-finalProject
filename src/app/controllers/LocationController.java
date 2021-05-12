package app.controllers;

import app.controllers.api.LocationApi;
import app.exceptions.InvalidLocationException;
import java.util.List;
import lombok.SneakyThrows;

/**
 *
 */
public class LocationController {

    /**
     *
     * @param department
     * @return
     */
    public boolean isValidDepartment(String department) {
        return LocationApi.getAll().containsKey(department.toLowerCase());
    }

    /**
     *
     * @param department
     * @param city
     * @return
     */
    public boolean isValidCityOf(String department, String city) {
        List<String> cities = LocationApi.getCities(department);
        return cities != null && cities.contains(city.toLowerCase());
    }

    /**
     *
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
     *
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