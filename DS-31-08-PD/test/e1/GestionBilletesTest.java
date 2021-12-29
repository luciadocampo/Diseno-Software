package e1;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GestionBilletesTest {
    BilletesAutobus billete1 = new BilletesAutobus("A Coruña","Barcelona","14/02/2022",349.99f);
    BilletesAutobus billete2 = new BilletesAutobus("Ferrol","Bilbao","15/02/2022",155.60f);
    BilletesAutobus billete3 = new BilletesAutobus("Barcelona","Pontevedra","16/02/2022",187.49f);
    BilletesAutobus billete4 = new BilletesAutobus("Sevilla","Madrid","17/02/2022",213.50f);
    BilletesAutobus billete5 = new BilletesAutobus("A Coruña","Madrid","17/02/2022",250.00f);
    BilletesAutobus billete6 = new BilletesAutobus("Sevilla","Granada","15/02/2022",89.89f);

    @Test
    public void testBasico(){
        assertEquals("A Coruña",billete1.getOrigen());
        assertEquals("Barcelona",billete1.getDestino());
        assertEquals("14/02/2022",billete1.getFecha());
        assertEquals(349.99f,billete1.getPrecio());
    }

    @Test
    public void testBasicoFormatoToString(){
        assertEquals("""
                BILLETE:
                ORIGEN: A Coruña
                DESTINO: Barcelona
                FECHA: 14/02/2022
                PRECIO: 349.99
                -------------------------------
                """,billete1.toString());                //UN BILLETE SOLO.

        List<BilletesAutobus> billetesAutobuses = new ArrayList<>();
        billetesAutobuses.add(billete1);
        billetesAutobuses.add(billete2);
        BuscadorDeBilletes buscadorDeBilletes = new BuscadorDeBilletes(billetesAutobuses);
        assertEquals("""
                BILLETE:
                ORIGEN: A Coruña
                DESTINO: Barcelona
                FECHA: 14/02/2022
                PRECIO: 349.99
                -------------------------------
                BILLETE:
                ORIGEN: Ferrol
                DESTINO: Bilbao
                FECHA: 15/02/2022
                PRECIO: 155.6
                -------------------------------
                """,buscadorDeBilletes.toString());   //VARIOS BILLETES.
    }

    @Test
    public void testCriterioDeOrigen(){
        List<BilletesAutobus> listaDeBilletes = new ArrayList<>();
        List<String> listaDeOrigenes = new ArrayList<>();
        CriterioRaiz<BilletesAutobus> criterioDeOrigen = new CriterioDeOrigen(listaDeOrigenes);
        List<CriterioRaiz<BilletesAutobus>> criteriosBilletes = new ArrayList<>();

        listaDeBilletes.add(billete1);
        listaDeBilletes.add(billete2);
        listaDeBilletes.add(billete3);
        listaDeBilletes.add(billete4);
        listaDeBilletes.add(billete5);
        listaDeBilletes.add(billete6);
        BuscadorDeBilletes busca = new BuscadorDeBilletes(listaDeBilletes);

        listaDeOrigenes.add("A Coruña");
        listaDeOrigenes.add("Sevilla");

        criteriosBilletes.add(criterioDeOrigen);   // ORIGEN: A CORUÑA OR SEVILLA

        assertEquals("""
                [BILLETE:
                ORIGEN: A Coruña
                DESTINO: Barcelona
                FECHA: 14/02/2022
                PRECIO: 349.99
                -------------------------------
                , BILLETE:
                ORIGEN: Sevilla
                DESTINO: Madrid
                FECHA: 17/02/2022
                PRECIO: 213.5
                -------------------------------
                , BILLETE:
                ORIGEN: A Coruña
                DESTINO: Madrid
                FECHA: 17/02/2022
                PRECIO: 250.0
                -------------------------------
                , BILLETE:
                ORIGEN: Sevilla
                DESTINO: Granada
                FECHA: 15/02/2022
                PRECIO: 89.89
                -------------------------------
                ]""",busca.buscadorBilletesFunc(criteriosBilletes).toString());  // LISTA FINAL CON LOS CRITERIOS PUESTOS.
    }

    @Test
    public void testCriterioDeDestino(){
        List<BilletesAutobus> listaDeBilletes = new ArrayList<>();
        List<String> listaDeDestinos = new ArrayList<>();
        CriterioRaiz<BilletesAutobus> criterioDeDestino = new CriterioDeDestino(listaDeDestinos);
        List<CriterioRaiz<BilletesAutobus>> criteriosBilletes = new ArrayList<>();

        listaDeBilletes.add(billete1);
        listaDeBilletes.add(billete2);
        listaDeBilletes.add(billete3);
        listaDeBilletes.add(billete4);
        listaDeBilletes.add(billete5);
        listaDeBilletes.add(billete6);
        BuscadorDeBilletes busca = new BuscadorDeBilletes(listaDeBilletes);

        listaDeDestinos.add("Pontevedra");
        listaDeDestinos.add("Madrid");

        criteriosBilletes.add(criterioDeDestino);           // DESTINO: PONTEVEDRA OR MADRID

        assertEquals("""
                [BILLETE:
                ORIGEN: Barcelona
                DESTINO: Pontevedra
                FECHA: 16/02/2022
                PRECIO: 187.49
                -------------------------------
                , BILLETE:
                ORIGEN: Sevilla
                DESTINO: Madrid
                FECHA: 17/02/2022
                PRECIO: 213.5
                -------------------------------
                , BILLETE:
                ORIGEN: A Coruña
                DESTINO: Madrid
                FECHA: 17/02/2022
                PRECIO: 250.0
                -------------------------------
                ]""",busca.buscadorBilletesFunc(criteriosBilletes).toString());  // LISTA FINAL CON LOS CRITERIOS PUESTOS.
    }

    @Test
    public void testCriterioDeFecha(){
        List<BilletesAutobus> listaDeBilletes = new ArrayList<>();
        List<String> listaDeFechas = new ArrayList<>();
        CriterioRaiz<BilletesAutobus> criterioDeFecha = new CriterioDeFecha(listaDeFechas);
        List<CriterioRaiz<BilletesAutobus>> criteriosBilletes = new ArrayList<>();

        listaDeBilletes.add(billete1);
        listaDeBilletes.add(billete2);
        listaDeBilletes.add(billete3);
        listaDeBilletes.add(billete4);
        listaDeBilletes.add(billete5);
        listaDeBilletes.add(billete6);
        BuscadorDeBilletes busca = new BuscadorDeBilletes(listaDeBilletes);

        listaDeFechas.add("17/02/2022");
        listaDeFechas.add("15/02/2022");

        criteriosBilletes.add(criterioDeFecha);  // FECHA: 15/02/2022 OR 17/02/2022

        assertEquals("""
                [BILLETE:
                ORIGEN: Ferrol
                DESTINO: Bilbao
                FECHA: 15/02/2022
                PRECIO: 155.6
                -------------------------------
                , BILLETE:
                ORIGEN: Sevilla
                DESTINO: Madrid
                FECHA: 17/02/2022
                PRECIO: 213.5
                -------------------------------
                , BILLETE:
                ORIGEN: A Coruña
                DESTINO: Madrid
                FECHA: 17/02/2022
                PRECIO: 250.0
                -------------------------------
                , BILLETE:
                ORIGEN: Sevilla
                DESTINO: Granada
                FECHA: 15/02/2022
                PRECIO: 89.89
                -------------------------------
                ]""",busca.buscadorBilletesFunc(criteriosBilletes).toString());  // LISTA FINAL CON LOS CRITERIOS PUESTOS.


    }

    @Test
    public void testCriterioDePrecio(){
        List<BilletesAutobus> listaDeBilletes = new ArrayList<>();
        List<String> listaDeRangos = new ArrayList<>();
        List<Float> listaDePrecios = new ArrayList<>();
        listaDePrecios.add(300.00f);
        listaDeRangos.add("<=");              //BILLETES MENORES O IGUALES QUE 300 EUROS. DEBE SACAR TODOS MENOS EL PRIMER BILLETE QUE CUESTA 349.99 EUROS.
        CriterioRaiz<BilletesAutobus> criterioDePrecio = new CriterioDePrecio(listaDeRangos,listaDePrecios);

        List<CriterioRaiz<BilletesAutobus>> criteriosBilletes = new ArrayList<>();

        listaDeBilletes.add(billete1);
        listaDeBilletes.add(billete2);
        listaDeBilletes.add(billete3);
        listaDeBilletes.add(billete4);
        listaDeBilletes.add(billete5);
        listaDeBilletes.add(billete6);
        BuscadorDeBilletes busca = new BuscadorDeBilletes(listaDeBilletes);

        criteriosBilletes.add(criterioDePrecio);  // PRECIO: MENOS O IGUAL QUE 300.00 EUROS

        assertEquals("""
                [BILLETE:
                ORIGEN: Ferrol
                DESTINO: Bilbao
                FECHA: 15/02/2022
                PRECIO: 155.6
                -------------------------------
                , BILLETE:
                ORIGEN: Barcelona
                DESTINO: Pontevedra
                FECHA: 16/02/2022
                PRECIO: 187.49
                -------------------------------
                , BILLETE:
                ORIGEN: Sevilla
                DESTINO: Madrid
                FECHA: 17/02/2022
                PRECIO: 213.5
                -------------------------------
                , BILLETE:
                ORIGEN: A Coruña
                DESTINO: Madrid
                FECHA: 17/02/2022
                PRECIO: 250.0
                -------------------------------
                , BILLETE:
                ORIGEN: Sevilla
                DESTINO: Granada
                FECHA: 15/02/2022
                PRECIO: 89.89
                -------------------------------
                ]""",busca.buscadorBilletesFunc(criteriosBilletes).toString()); // LISTA FINAL CON LOS CRITERIOS PUESTOS.
    }


    @Test
    public void testCriterioDePreciosDos(){  // HACEMOS ESTE TEST UNICA Y EXCLUSIVAMENTE PARA SUBIR EL COVERAGE DE LOS DIFERENTES USOS DE LOS RANGOS DE PRECIOS QUE NO SE HAN USADO.
        List<BilletesAutobus> listaDeBilletes = new ArrayList<>();
        List<BilletesAutobus> listaDeBilletes2 = new ArrayList<>() ;
        List<BilletesAutobus> listaDeBilletes3 = new ArrayList<>() ;
        listaDeBilletes.add(billete1);
        listaDeBilletes.add(billete2);
        listaDeBilletes.add(billete3);
        listaDeBilletes.add(billete4);
        listaDeBilletes.add(billete5);
        listaDeBilletes.add(billete6);

        listaDeBilletes2.add(billete1);
        listaDeBilletes2.add(billete2);
        listaDeBilletes2.add(billete3);
        listaDeBilletes2.add(billete4);
        listaDeBilletes2.add(billete5);
        listaDeBilletes2.add(billete6);

        listaDeBilletes3.add(billete1);
        listaDeBilletes3.add(billete2);
        listaDeBilletes3.add(billete3);
        listaDeBilletes3.add(billete4);
        listaDeBilletes3.add(billete5);
        listaDeBilletes3.add(billete6);

        BuscadorDeBilletes busca = new BuscadorDeBilletes(listaDeBilletes);
        BuscadorDeBilletes busca2 = new BuscadorDeBilletes(listaDeBilletes2);
        BuscadorDeBilletes busca3 = new BuscadorDeBilletes(listaDeBilletes3);
        List<CriterioRaiz<BilletesAutobus>> criteriosPrecioDos = new ArrayList<>();
        List<CriterioRaiz<BilletesAutobus>> criteriosPrecioDos2 = new ArrayList<>();
        List<CriterioRaiz<BilletesAutobus>> criteriosPrecioDos3 = new ArrayList<>();


        List<Float> listaPrecios = new ArrayList<>();
        listaPrecios.add(213.50f);
        List<String> listaRangos = new ArrayList<>();
        List<String> listaRangos2 = new ArrayList<>();
        List<String> listaRangos3 = new ArrayList<>();
        listaRangos.add("==");
        listaRangos2.add(">=");
        listaRangos3.add(">");


        CriterioRaiz<BilletesAutobus> criterioDePrecioDos = new CriterioDePrecio(listaRangos, listaPrecios);
        CriterioRaiz<BilletesAutobus> criterioDePrecioDos2 = new CriterioDePrecio(listaRangos2, listaPrecios);
        CriterioRaiz<BilletesAutobus> criterioDePrecioDos3 = new CriterioDePrecio(listaRangos3, listaPrecios);

        criteriosPrecioDos.add(criterioDePrecioDos);
        criteriosPrecioDos2.add(criterioDePrecioDos2);
        criteriosPrecioDos3.add(criterioDePrecioDos3);

       assertEquals("""
                [BILLETE:
                ORIGEN: Sevilla
                DESTINO: Madrid
                FECHA: 17/02/2022
                PRECIO: 213.5
                -------------------------------
                ]""",busca.buscadorBilletesFunc(criteriosPrecioDos).toString()); // NOS SACA LOS BILLETES IGUALES A 213.50 EUROS (1 BILLETE DE LOS 6)

        assertEquals("""
                [BILLETE:
                ORIGEN: A Coruña
                DESTINO: Barcelona
                FECHA: 14/02/2022
                PRECIO: 349.99
                -------------------------------
                , BILLETE:
                ORIGEN: Sevilla
                DESTINO: Madrid
                FECHA: 17/02/2022
                PRECIO: 213.5
                -------------------------------
                , BILLETE:
                ORIGEN: A Coruña
                DESTINO: Madrid
                FECHA: 17/02/2022
                PRECIO: 250.0
                -------------------------------
                ]""",busca2.buscadorBilletesFunc(criteriosPrecioDos2).toString()); // NOS SACA LOS BILLETES MAYORES O IGUALES DE 213.50 EUROS (3 BILLETES DE LOS 6)

        assertEquals("""
                [BILLETE:
                ORIGEN: A Coruña
                DESTINO: Barcelona
                FECHA: 14/02/2022
                PRECIO: 349.99
                -------------------------------
                , BILLETE:
                ORIGEN: A Coruña
                DESTINO: Madrid
                FECHA: 17/02/2022
                PRECIO: 250.0
                -------------------------------
                ]""",busca3.buscadorBilletesFunc(criteriosPrecioDos3).toString());  // NOS SACA LOS BILLETES MAYORES ESTRICTOS DE 213.50 EUROS (2 BILLETES DE LOS 6)

    }

    @Test
    public void testEqualsAndHashCode(){
        BilletesAutobus bAux1 = new BilletesAutobus("A Coruña","Barcelona","14/02/2022",349.99f);
        BilletesAutobus bAux2 = new BilletesAutobus("Santiago","Barcelona","14/02/2022",349.99f);

        assertEquals(bAux1,billete1);
        assertNotEquals(bAux2,billete1);

        assertEquals(bAux1.hashCode(),billete1.hashCode());
    }

    @Test
    public void testTodosLosCriteriosJuntos(){
        List<BilletesAutobus> listaDeBilletes = new ArrayList<>() ;
        List<String> listaDeOrigenes = new ArrayList<>();
        List<String> listaDeDestinos = new ArrayList<>();
        List<String> listaDeFechas = new ArrayList<>();
        List<String> listaDeRangos = new ArrayList<>();
        List<Float> listaDePrecios = new ArrayList<>();
        listaDeBilletes.add(billete1);
        listaDeBilletes.add(billete2);
        listaDeBilletes.add(billete3);                     //AÑADIMOS BILLETES A LA LISTA.
        listaDeBilletes.add(billete4);
        listaDeBilletes.add(billete5);
        listaDeBilletes.add(billete6);
        BuscadorDeBilletes busca = new BuscadorDeBilletes(listaDeBilletes);
        List<CriterioRaiz<BilletesAutobus>> criteriosJuntos = new ArrayList<>();

        listaDeOrigenes.add("A Coruña");
        listaDeOrigenes.add("Sevilla");
        CriterioRaiz<BilletesAutobus> criterioDeOrigen = new CriterioDeOrigen(listaDeOrigenes);
        criteriosJuntos.add(criterioDeOrigen);             // ORIGEN: A CORUÑA OR SEVILLA

        listaDeDestinos.add("Madrid");
        CriterioRaiz<BilletesAutobus> criterioDeDestino = new CriterioDeDestino(listaDeDestinos);
        criteriosJuntos.add(criterioDeDestino);            // ORIGEN: (A CORUÑA OR SEVILLA) AND DESTINO: MADRID

        listaDeFechas.add("14/02/2022");
        listaDeFechas.add("17/02/2022");
        CriterioRaiz<BilletesAutobus> criterioDeFechas = new CriterioDeFecha(listaDeFechas);
        criteriosJuntos.add(criterioDeFechas);   // ORIGEN: (A CORUÑA OR SEVILLA) AND DESTINO: MADRID AND FECHA: (14/02/2022 OR 17/02/2022)

        listaDePrecios.add(230.00f);
        listaDeRangos.add("<");
        CriterioRaiz<BilletesAutobus> criterioDePrecio = new CriterioDePrecio(listaDeRangos, listaDePrecios);

        criteriosJuntos.add(criterioDePrecio); // ORIGEN: (A CORUÑA OR SEVILLA) AND DESTINO: MADRID AND FECHA: (14/02/2022 OR 17/02/2022) AND PRECIO: MENOR ESTRICTO QUE 230.00 EUROS.

        assertEquals("""
                [BILLETE:
                ORIGEN: Sevilla
                DESTINO: Madrid
                FECHA: 17/02/2022
                PRECIO: 213.5
                -------------------------------
                ]""",busca.buscadorBilletesFunc(criteriosJuntos).toString());  //DEBE SACAR EL BILLETE DE SEVILLA-MADRID EL 17/02/2022 POR 213.50 EUROS YA QUE ES EL ÚNICO QUE CUMPLE LAS CONDICIONES PUESTAS.
    }
}
