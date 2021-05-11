package test.controllers.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import app.controllers.api.LocationApi;
import org.junit.Test;

public class LocationApiTest {

    @Test
    public void getAllDepartmentsTest() {
        assertEquals(
            ("[Amazonas, Antioquia, Arauca, Atlántico, Bolívar," +
            " Boyacá, Caldas, Caquetá, Casanare, Cauca, Cesar, Chocó, Cundinamarca," +
            " Córdoba, Guainía, Guaviare, Huila, La Guajira, Magdalena, Meta, Nariño," +
            " Norte de Santander, Putumayo, Quindío, Risaralda, San Andrés y " +
            "Providencia, Santander, Sucre, Tolima, Valle del Cauca, Vaupés," +
            " Vichada]").toLowerCase(),
            LocationApi.getDepartments().toString()
        );
    }

    @Test
    public void getCitiesFromDepartment() {
        assertEquals(
            "[Leticia, Puerto Nariño]".toLowerCase(),
            LocationApi.getCities("Amazonas".toLowerCase()).toString()
        );

        assertEquals(
            "[Cumaribo, La Primavera, Puerto Carreño, Santa Rosalía]".toLowerCase(),
            LocationApi.getCities("Vichada".toLowerCase()).toString()
        );
    }

    @Test
    public void invalidDepartment() {
        assertNull(LocationApi.getCities("New York"));
    }
}
