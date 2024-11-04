package testng;

import org.example.entity.Actividad;
import org.example.entity.Socio;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ActividadTestNg {
    Actividad act;
    Socio s1;
    Socio s2;

    @BeforeMethod
    public void setUp() {
        act = new Actividad("Caminar");
        s1 = new Socio("socio1@gmail.com");
        s2 = new Socio("socio2@gmail.com");
        act.inscribirSocio(s1);
        act.inscribirSocio(s2);
    }

    @Test
    public void testUnicoEncargado() {
        assertTrue(act.setEncargado(s1), "Debería poder asignar el primer encargado");
        assertFalse(act.setEncargado(s2), "No debería permitir asignar un segundo encargado");
        assertEquals(s1, act.getEncargado(), "El encargado debería ser el primero asignado");
    }
}
