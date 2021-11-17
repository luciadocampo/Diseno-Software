package e2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ApartamentosTest {
    //CREACIÓN DE NUEVOS APARTAMENTOS.
    Apartamentos a1 = new Apartamentos(1234, 500, 2, 300, "15630");
    Apartamentos a2 = new Apartamentos(1235, 450, 0, 450, "15009");
    Apartamentos a3 = new Apartamentos(1236, 350, 3, 300, "15638");
    Apartamentos a4 = new Apartamentos(1237, 500, 2, 300, "15009");
    Apartamentos a5 = new Apartamentos(1238, 500, 2, 300, "15632");

    //TEST BÁSICOS
    @Test
    public void testGetReferencia(){
        assertEquals(1234,a1.getReferencias());
    }
    @Test
    public void testGetPrecioVivienda(){
        assertEquals(450,a2.getPrecioViviendas());
    }

    @Test
    public void testGetPlazas(){
        assertEquals(150,a3.getPrecioPlazas()); // 3 * 50 euros que le hemos adjudicado a cada plaza.
    }
    @Test
    public void testGetTamano(){
        assertEquals(300,a4.getTamanos());
    }

    @Test
    public void testGetCP(){
        assertEquals("15632",a5.getCP());
    }

    @Test
    public void testGetPrecioFinal(){
        assertEquals(600,a1.getPrecioFinal());
        assertEquals(450,a2.getPrecioFinal());
        assertEquals(600,a4.getPrecioFinal());
    }

    @Test
    public void testToString(){
        assertEquals(a1.toString(),"Referencia: 1234, PrecioBase: 500, Precio plazas: 2, Tamaño en m2: 300, Código Postal: 15630.\n");
        assertEquals(a2.toString(),"Referencia: 1235, PrecioBase: 450, Precio plazas: 0, Tamaño en m2: 450, Código Postal: 15009.\n");
    }

    //TEST PRINCIPALES

    @Test
    public void testExepcionesDeCreacion(){

        assertThrows(IllegalArgumentException.class,()->new Apartamentos(0,500,2,300,"15008"));
        assertThrows(IllegalArgumentException.class,()->new Apartamentos(1235,-500,2,300,"15008"));
        assertThrows(IllegalArgumentException.class,()->new Apartamentos(1235,500,-13,300,"15008"));
        assertThrows(IllegalArgumentException.class,()->new Apartamentos(1235,500,2,0,"15008"));
        assertThrows(IllegalArgumentException.class,()->new Apartamentos(1235,500,2,300,null));
    }

    @Test
    public void testExcepcionDeDuplicado(){
        //CONTROLAMOS QUE NO SE INSERTE EN LA LISTA UN ANUNCIO IGUAL, ES DECIR, 2 APARTAMENTOS CON EL MISMO NÚMERO DE REFERENCIA.
        GestionApartamentos.addApartamento(a1);
        Apartamentos errorAp = new Apartamentos(1234, 500, 2, 300, "15008");
        assertThrows(IllegalArgumentException.class,()->GestionApartamentos.addApartamento(errorAp));
        GestionApartamentos.apartamentos.clear(); // Para limpiar la lista antes de probar el sort.
    }

    @Test
    public void hashCodeAndEquals(){
        Object ob = new Object();
        Object ob2 = null;
        Apartamentos ap = new Apartamentos(1234,500,2,300,"15630");
        Apartamentos ap2 = new Apartamentos(1234,500,2,300,"15630");
        Apartamentos ap3 = new Apartamentos(1234,500,3,300,"15630");   //CREAMOS ESTOS NUEVOS APARTAMENTOS PARA COMPARAR TODOS LOS POSIBLES CASOS DE COMPARACIÓN EN EL EQUALS.
        Apartamentos ap4 = new Apartamentos(1234,500,3,400,"15630");
        Apartamentos ap5 = new Apartamentos(1234,500,3,400,"15631");
        // MÉTODO EQUALS
        assertFalse(a1.equals(a2));
        assertTrue(a3.equals(a3));
        assertTrue(a1.equals(ap));
        assertFalse(a1.equals(ob));
        assertFalse(a1.equals(ob2));
        assertFalse(ap2.equals(ap3));
        assertFalse(ap3.equals(ap4));
        assertFalse(ap4.equals(ap5));





        // MÉTODO HASHCODE
        assertTrue(a1.hashCode() == ap.hashCode());
        assertFalse(a1.hashCode() == a3.hashCode());
    }

    @Test
    public void testCompareTo(){
        //No podemos hacer ningún compareTo == 0 porque nunca podemos tener un apartamento con el mismo número de referencia y es el primer atributo de ordenación por orden natural.
        //El compareTo usa orden natural de las comparaciones y empieza por el número de referencia por ello salen estos resultados:
        Assertions.assertTrue(a1.compareTo(a2) <0);
        Assertions.assertTrue(a1.compareTo(a3) <0);
        Assertions.assertTrue(a1.compareTo(a4) <0);

        Assertions.assertTrue(a3.compareTo(a2) >0);
        Assertions.assertTrue(a3.compareTo(a4) <0);

        Assertions.assertTrue(a4.compareTo(a2) >0);
        Assertions.assertTrue(a4.compareTo(a5) <0);

        Assertions.assertTrue(a5.compareTo(a4) >0);
        Assertions.assertTrue(a5.compareTo(a3) >0);
        Assertions.assertTrue(a5.compareTo(a2) >0);
    }

    @Test
    public void testCompare() {
        Comparator<Apartamentos> compCP = new CompCPostal();
        Comparator<Apartamentos> compPBase = new CompPrecioBase();
        Comparator<Apartamentos> compPFinal = new CompPrecioFinal();
        Comparator<Apartamentos> compTam = new CompTamano();
        Comparator<Apartamentos> gestAp = new GestionApartamentos();

        //Compare por Código Postal
        Assertions.assertTrue(compCP.compare(a1,a2)>0);
        Assertions.assertTrue(compCP.compare(a2,a4)==0);
        Assertions.assertTrue(compCP.compare(a5,a3)<0);

        //Compare por Precio Base
        Assertions.assertTrue(compPBase.compare(a1,a2)>0);
        Assertions.assertTrue(compPBase.compare(a4,a5)==0);
        Assertions.assertTrue(compPBase.compare(a3,a2)<0);

        //Compare por Precio Final
        Assertions.assertTrue(compPFinal.compare(a1,a2)>0);
        Assertions.assertTrue(compPFinal.compare(a4,a5)==0);
        Assertions.assertTrue(compPFinal.compare(a2,a3)<0);

        //Compare por Tamaño
        Assertions.assertTrue(compTam.compare(a2,a1)>0);
        Assertions.assertTrue(compTam.compare(a4,a5)==0);
        Assertions.assertTrue(compTam.compare(a3,a2)<0);

        //Compare por orden natural sin especificar. POR ORDEN NATURAL VAN A HACERSE SIEMPRE POR REFERENCIA PORQUE NUNCA VA A HABER 2 NÚMEROS DE REFERENCIA IGUALES.
        Assertions.assertTrue(gestAp.compare(a2,a1)>0);
        Assertions.assertTrue(gestAp.compare(a2,a4)<0);
    }

    @Test
    public void testSort() {
        GestionApartamentos.addApartamento(a1);
        GestionApartamentos.addApartamento(a2);
        GestionApartamentos.addApartamento(a3);
        GestionApartamentos.addApartamento(a4);
        GestionApartamentos.addApartamento(a5);

       //Sort de la lista por Código Postal.
        Comparator<Apartamentos> compCP = new CompCPostal();
        GestionApartamentos.apartamentos.sort(compCP);
        assertEquals("""
                [Referencia: 1235, PrecioBase: 450, Precio plazas: 0, Tamaño en m2: 450, Código Postal: 15009.
                , Referencia: 1237, PrecioBase: 500, Precio plazas: 2, Tamaño en m2: 300, Código Postal: 15009.
                , Referencia: 1234, PrecioBase: 500, Precio plazas: 2, Tamaño en m2: 300, Código Postal: 15630.
                , Referencia: 1238, PrecioBase: 500, Precio plazas: 2, Tamaño en m2: 300, Código Postal: 15632.
                , Referencia: 1236, PrecioBase: 350, Precio plazas: 3, Tamaño en m2: 300, Código Postal: 15638.
                ]""",GestionApartamentos.apartamentos.toString());

        //Sort de la lista por tamaño.
        Comparator<Apartamentos> compTam = new CompTamano();
        GestionApartamentos.apartamentos.sort(compTam);
        assertEquals("""
                [Referencia: 1237, PrecioBase: 500, Precio plazas: 2, Tamaño en m2: 300, Código Postal: 15009.
                , Referencia: 1234, PrecioBase: 500, Precio plazas: 2, Tamaño en m2: 300, Código Postal: 15630.
                , Referencia: 1238, PrecioBase: 500, Precio plazas: 2, Tamaño en m2: 300, Código Postal: 15632.
                , Referencia: 1236, PrecioBase: 350, Precio plazas: 3, Tamaño en m2: 300, Código Postal: 15638.
                , Referencia: 1235, PrecioBase: 450, Precio plazas: 0, Tamaño en m2: 450, Código Postal: 15009.
                ]""",GestionApartamentos.apartamentos.toString());

        //Por orden natural que empieza con referencia.
        Comparator<Apartamentos> gestAp = new GestionApartamentos();
        GestionApartamentos.apartamentos.sort(gestAp);
        assertEquals("""
                [Referencia: 1234, PrecioBase: 500, Precio plazas: 2, Tamaño en m2: 300, Código Postal: 15630.
                , Referencia: 1235, PrecioBase: 450, Precio plazas: 0, Tamaño en m2: 450, Código Postal: 15009.
                , Referencia: 1236, PrecioBase: 350, Precio plazas: 3, Tamaño en m2: 300, Código Postal: 15638.
                , Referencia: 1237, PrecioBase: 500, Precio plazas: 2, Tamaño en m2: 300, Código Postal: 15009.
                , Referencia: 1238, PrecioBase: 500, Precio plazas: 2, Tamaño en m2: 300, Código Postal: 15632.
                ]""",GestionApartamentos.apartamentos.toString());

        GestionApartamentos.apartamentos.clear(); // Para limpiar la lista y que se vuelva a utilizar.
    }
}