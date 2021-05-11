package app.controllers;

import app.controllers.api.LocationApi;
import app.exceptions.InvalidLocationException;
import java.util.List;
import lombok.SneakyThrows;

public class LocationController {

    public boolean isValidDepartment(String department) {
        return LocationApi.getAll().containsKey(department.toLowerCase());
    }

    public boolean isValidCityOf(String department, String city) {
        List<String> cities = LocationApi.getCities(department);
        return cities != null && cities.contains(city.toLowerCase());
    }

    @SneakyThrows
    public String checkForDepartment(String department) {
        if (!isValidDepartment(department)) {
            throw new InvalidLocationException("El departamento no existe");
        }
        return department;
    }

    @SneakyThrows
    public String checkForCity(String department, String city) {
        if (!isValidCityOf(department, city)) {
            throw new InvalidLocationException(
                "La ciudad no pertenece a este departamento"
            );
        }
        return city;
    }
}
