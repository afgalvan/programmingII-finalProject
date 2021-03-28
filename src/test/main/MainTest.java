package test.main;

import static org.junit.Assert.assertEquals;

import app.main.Main;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemOutput() {
        System.setOut(systemOut);
    }

    @Test
    public void shouldPrintOnTerminal() {
        Main.main(new String[0]);
        assertEquals(
            "[Abejorral, Abriaquí, Alejandría, Amagá, Amalfi, Andes, Angelópolis, Angostura, Anorí, Anzá, Apartadó, Arboletes, Argelia, Armenia, Barbosa, Bello, Belmira, Betania, Betulia, Briceño, Buriticá, Cáceres, Caicedo, Caldas, Campamento, Cañasgordas, Caracolí, Caramanta, Carepa, Carolina del Príncipe, Caucasia, Chigorodó, Cisneros, Ciudad Bolívar, Cocorná, Concepción, Concordia, Copacabana, Dabeiba, Donmatías, Ebéjico, El Bagre, El Carmen de Viboral, El Peñol, El Retiro, El Santuario, Entrerríos, Envigado, Fredonia, Frontino, Giraldo, Girardota, Gómez Plata, Granada, Guadalupe, Guarne, Guatapé, Heliconia, Hispania, Itagüí, Ituango, Jardín, Jericó, La Ceja, La Estrella, La Pintada, La Unión, Liborina, Maceo, Marinilla, Medellín, Montebello, Murindó, Mutatá, Nariño, Nechí, Necoclí, Olaya, Peque, Pueblorrico, Puerto Berrío, Puerto Nare, Puerto Triunfo, Remedios, Rionegro, Sabanalarga, Sabaneta, Salgar, San Andrés de Cuerquia, San Carlos, San Francisco, San Jerónimo, San José de la Montaña, San Juan de Urabá, San Luis, San Pedro de Urabá, San Pedro de los Milagros, San Rafael, San Roque, San Vicente, Santa Bárbara, Santa Fe de Antioquia, Santa Rosa de Osos, Santo Domingo, Segovia, Sonsón, Sopetrán, Támesis, Tarazá, Tarso, Titiribí, Toledo, Turbo, Uramita, Urrao, Valdivia, Valparaíso, Vegachí, Venecia, Vigía del Fuerte, Yalí, Yarumal, Yolombó, Yondó, Zaragoza]\n",
            getOutput()
        );
    }
}
