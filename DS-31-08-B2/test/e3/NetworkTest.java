package e3;

import org.junit.jupiter.api.Test;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class NetworkTest {

    @Test
    public void testNetwork(){
        List<TopicOfInterest> toi1 = new ArrayList<>();
        List<TopicOfInterest> toi2 = new ArrayList<>();
        MapaHash mh = new MapaHash();
        Network nw = new Network(mh);

        TopicOfInterest aficion1 = new TopicOfInterest("DORMIR");
        TopicOfInterest aficion2 = new TopicOfInterest("FUTBOL");
        TopicOfInterest aficion3 = new TopicOfInterest("CANTAR");
        toi1.add(aficion1);
        toi1.add(aficion2);
        toi1.add(aficion3);
        toi2.add(aficion1);
        toi2.add(aficion2);
        toi2.add(aficion3);

        TopicOfInterest aficion4 = new TopicOfInterest("PINTAR");
        TopicOfInterest aficion5 = new TopicOfInterest("MÚSICA");


        nw.addUser("David",toi1);
        assertEquals("David=[DORMIR, FUTBOL, CANTAR] ",nw.getNetwork().toString());

        nw.addUser("Lucia",toi2);
        assertEquals("Lucia=[DORMIR, FUTBOL, CANTAR] David=[DORMIR, FUTBOL, CANTAR] ",nw.getNetwork().toString());

        nw.removeUser("David");
        assertEquals("Lucia=[DORMIR, FUTBOL, CANTAR] ",nw.getNetwork().toString());

        nw.addInterest("Lucia",aficion4);
        assertEquals("Lucia=[DORMIR, FUTBOL, CANTAR, PINTAR] ",nw.getNetwork().toString());

        nw.removeInterest("Lucia",aficion2);
        assertEquals("Lucia=[DORMIR, CANTAR, PINTAR] ",nw.getNetwork().toString());

        nw.addUser("David",toi1);
        nw.addInterest("David",aficion5);
        assertEquals("[Lucia, David]",nw.getUsers().toString());

        assertEquals("[DORMIR, CANTAR, PINTAR, DORMIR, FUTBOL, CANTAR, MÚSICA]",nw.getInterests().toString());
        assertEquals("[DORMIR, CANTAR, PINTAR]",nw.getInterestsUser("Lucia").toString());
        assertEquals("[DORMIR, CANTAR]",nw.getInteresesEnComun("Lucia","David").toString());

        assertEquals("Lucia=[DORMIR, CANTAR, PINTAR] David=[DORMIR, FUTBOL, CANTAR, MÚSICA] ",nw.getNetwork().toString());
    }



    @Test
    public void testNetworkMatriz(){
        //NO NOS FUNCIONAN TODAS LAS FUNCIONES EN MATRIZ. CREEMOS QUE DEBE SER POR MAL MANEJO DE POSICIONES EN LAS MATRICES PERO NO ENTENDEMOS COMO SOLUCIONAR EL ERROR.
        List<TopicOfInterest> toi1 = new ArrayList<>();
        List<TopicOfInterest> toi2 = new ArrayList<>();
        MapaMatriz mm = new MapaMatriz();
        Network nw = new Network(mm);

        TopicOfInterest aficion1 = new TopicOfInterest("DORMIR");
        TopicOfInterest aficion2 = new TopicOfInterest("FUTBOL");
        TopicOfInterest aficion3 = new TopicOfInterest("CANTAR");
        toi1.add(aficion1);
        toi1.add(aficion2);
        toi1.add(aficion3);
        toi2.add(aficion1);
        toi2.add(aficion2);
        toi2.add(aficion3);

        TopicOfInterest aficion4 = new TopicOfInterest("PINTAR");
        TopicOfInterest aficion5 = new TopicOfInterest("MÚSICA");


        mm.addUser("David",toi1);
        assertEquals("David DORMIR FUTBOL CANTAR ",nw.getNetwork().toString());

        mm.addUser("Lucia",toi2);
        assertEquals("David DORMIR FUTBOL CANTAR Lucia DORMIR FUTBOL CANTAR ",nw.getNetwork().toString());
        assertEquals("[David, Lucia]",nw.getUsers().toString());

        mm.removeInterest("David",aficion1);
        mm.removeInterest("Lucia",aficion1);
        assertEquals("David FUTBOL CANTAR Lucia FUTBOL CANTAR ",nw.getNetwork().toString());

    }

    @Test
    public void testNetworkHashMap(){
        //AQUÍ SI QUE FUNCIONAN TODAS LAS FUNCIONES CORRECTAMENTE.
        List<TopicOfInterest> toi1 = new ArrayList<>();
        List<TopicOfInterest> toi2 = new ArrayList<>();
        MapaHash mh = new MapaHash();
        Network nw = new Network(mh);

        TopicOfInterest aficion1 = new TopicOfInterest("DORMIR");
        TopicOfInterest aficion2 = new TopicOfInterest("FUTBOL");
        TopicOfInterest aficion3 = new TopicOfInterest("CANTAR");
        toi1.add(aficion1);
        toi1.add(aficion2);
        toi1.add(aficion3);
        toi2.add(aficion1);
        toi2.add(aficion2);
        toi2.add(aficion3);

        TopicOfInterest aficion4 = new TopicOfInterest("PINTAR");
        TopicOfInterest aficion5 = new TopicOfInterest("MÚSICA");


        mh.addUser("David",toi1);
        assertEquals("David=[DORMIR, FUTBOL, CANTAR] ",nw.getNetwork().toString());

        mh.addUser("Lucia",toi2);
        assertEquals("Lucia=[DORMIR, FUTBOL, CANTAR] David=[DORMIR, FUTBOL, CANTAR] ",nw.getNetwork().toString());

        mh.removeUser("David");
        assertEquals("Lucia=[DORMIR, FUTBOL, CANTAR] ",nw.getNetwork().toString());

        mh.addInterest("Lucia",aficion4);
        assertEquals("Lucia=[DORMIR, FUTBOL, CANTAR, PINTAR] ",nw.getNetwork().toString());

        mh.removeInterest("Lucia",aficion2);
        assertEquals("Lucia=[DORMIR, CANTAR, PINTAR] ",nw.getNetwork().toString());

        mh.addUser("David",toi1);
        mh.addInterest("David",aficion5);
        assertEquals("[Lucia, David]",mh.getUsers().toString());

        assertEquals("[DORMIR, CANTAR, PINTAR, DORMIR, FUTBOL, CANTAR, MÚSICA]",mh.getInterests().toString());
        assertEquals("[DORMIR, CANTAR, PINTAR]",mh.getInterestsUser("Lucia").toString());
        assertEquals("[DORMIR, CANTAR]",mh.getInteresesEnComun("Lucia","David").toString());

        assertEquals("Lucia=[DORMIR, CANTAR, PINTAR] David=[DORMIR, FUTBOL, CANTAR, MÚSICA] ",nw.getNetwork().toString()); //Para comprobar que llamando a la network también nos saca el hashmap introducido.
    }
}
