package e2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlanificadorTareasTest {

    @Test
    public void testBasico(){
        ConstructorDeDependencias prueba = new ConstructorDeDependencias("C","A");

        assertEquals("C",prueba.getElemento1());
        assertEquals("A",prueba.getElemento2());
    }

    @Test
    public void testDepFuerte(){
        ClasificadorDeTareas clasi = new ClasificadorDeTareas();

        ConstructorDeDependencias d1 = new ConstructorDeDependencias("C","A");
        clasi.addDep(d1);
        ConstructorDeDependencias d2 = new ConstructorDeDependencias("C","F");
        clasi.addDep(d2);
        ConstructorDeDependencias d3 = new ConstructorDeDependencias("A","B");
        clasi.addDep(d3);
        ConstructorDeDependencias d4 = new ConstructorDeDependencias("A","D");
        clasi.addDep(d4);
        ConstructorDeDependencias d5 = new ConstructorDeDependencias("B","E");
        clasi.addDep(d5);
        ConstructorDeDependencias d6 = new ConstructorDeDependencias("D","E");
        clasi.addDep(d6);
        ConstructorDeDependencias d7 = new ConstructorDeDependencias("F","E");
        clasi.addDep(d7);
        ConstructorDeDependencias d8 = new ConstructorDeDependencias("G","F");
        clasi.addDep(d8);
        ConstructorDeDependencias d9 = new ConstructorDeDependencias("G","H");
        clasi.addDep(d9);
        ConstructorDeDependencias d10 = new ConstructorDeDependencias("F","J");
        clasi.addDep(d10);
        ConstructorDeDependencias d11 = new ConstructorDeDependencias("H","J");
        clasi.addDep(d11);

        DepRaizInterfaz dr = new DepFuerte();  //INDICAMOS QUE LA DEPEDENCIA A USAR ES DEPENDENCIA FUERTE.
        GestorDeProyectos gdp = new GestorDeProyectos(dr, clasi);   //EL GESTOR DE PROYECTOS ANALIZA LA DEPENDENCIA FUERTE Y CLASIFICA LA TAREA.
        assertEquals("C-A-B-D-G-F-E-H-J", gdp.Planificador());  //CADENA ESPERADA (ACORDE A LAS INDICACIONES DEL ENUNCIADO).
    }

    @Test
    public void testDepDebil(){
        ClasificadorDeTareas clasi = new ClasificadorDeTareas();

        ConstructorDeDependencias d1 = new ConstructorDeDependencias("C","A");
        clasi.addDep(d1);
        ConstructorDeDependencias d2 = new ConstructorDeDependencias("C","F");
        clasi.addDep(d2);
        ConstructorDeDependencias d3 = new ConstructorDeDependencias("A","B");
        clasi.addDep(d3);
        ConstructorDeDependencias d4 = new ConstructorDeDependencias("A","D");
        clasi.addDep(d4);
        ConstructorDeDependencias d5 = new ConstructorDeDependencias("B","E");
        clasi.addDep(d5);
        ConstructorDeDependencias d6 = new ConstructorDeDependencias("D","E");
        clasi.addDep(d6);
        ConstructorDeDependencias d7 = new ConstructorDeDependencias("F","E");
        clasi.addDep(d7);
        ConstructorDeDependencias d8 = new ConstructorDeDependencias("G","F");
        clasi.addDep(d8);
        ConstructorDeDependencias d9 = new ConstructorDeDependencias("G","H");
        clasi.addDep(d9);
        ConstructorDeDependencias d10 = new ConstructorDeDependencias("F","J");
        clasi.addDep(d10);
        ConstructorDeDependencias d11 = new ConstructorDeDependencias("H","J");
        clasi.addDep(d11);

        DepRaizInterfaz dr = new DepDebil();  //INDICAMOS QUE LA DEPEDENCIA A USAR ES DEPENDENCIA DÉBIL.
        GestorDeProyectos gdp = new GestorDeProyectos(dr, clasi);   //EL GESTOR DE PROYECTOS ANALIZA LA DEPENDENCIA DÉBIL Y CLASIFICA LA TAREA.
        assertEquals("C-A-B-D-E-F-G-H-J", gdp.Planificador()); //CADENA ESPERADA (ACORDE A LAS INDICACIONES DEL ENUNCIADO).
    }

    @Test
    public void testDepJerarquica(){
        ClasificadorDeTareas clasi = new ClasificadorDeTareas();

        ConstructorDeDependencias d1 = new ConstructorDeDependencias("C","A");
        clasi.addDep(d1);
        ConstructorDeDependencias d2 = new ConstructorDeDependencias("C","F");
        clasi.addDep(d2);
        ConstructorDeDependencias d3 = new ConstructorDeDependencias("A","B");
        clasi.addDep(d3);
        ConstructorDeDependencias d4 = new ConstructorDeDependencias("A","D");
        clasi.addDep(d4);
        ConstructorDeDependencias d5 = new ConstructorDeDependencias("B","E");
        clasi.addDep(d5);
        ConstructorDeDependencias d6 = new ConstructorDeDependencias("D","E");
        clasi.addDep(d6);
        ConstructorDeDependencias d7 = new ConstructorDeDependencias("F","E");
        clasi.addDep(d7);
        ConstructorDeDependencias d8 = new ConstructorDeDependencias("G","F");
        clasi.addDep(d8);
        ConstructorDeDependencias d9 = new ConstructorDeDependencias("G","H");
        clasi.addDep(d9);
        ConstructorDeDependencias d10 = new ConstructorDeDependencias("F","J");
        clasi.addDep(d10);
        ConstructorDeDependencias d11 = new ConstructorDeDependencias("H","J");
        clasi.addDep(d11);

        DepRaizInterfaz dr = new DepJerarquica();  //INDICAMOS QUE LA DEPEDENCIA A USAR ES ORDEN JERÁRQUICO.
        GestorDeProyectos gdp = new GestorDeProyectos(dr, clasi);   //EL GESTOR DE PROYECTOS ANALIZA EL ORDEN JERÁRQUICO Y CLASIFICA LA TAREA.
        assertEquals("C-G-A-F-H-B-D-E-J", gdp.Planificador()); //CADENA ESPERADA (ACORDE A LAS INDICACIONES DEL ENUNCIADO).
    }

    @Test
    public void testEqualsAndHashCode(){
        ConstructorDeDependencias prueba2 = new ConstructorDeDependencias("C","A");
        ConstructorDeDependencias prueba3 = new ConstructorDeDependencias("C","A");
        ConstructorDeDependencias prueba4 = new ConstructorDeDependencias("C","D");

        assertEquals(prueba2,prueba3);
        assertNotEquals(prueba2,prueba4);
        assertEquals(prueba2.hashCode(),prueba3.hashCode());
        assertNotEquals(prueba3.hashCode(),prueba4.hashCode());
    }
}
