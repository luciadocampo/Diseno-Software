package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColegioTest {
    //Creación de los integrantes de Hogwarts principales.
    Guardabosques g = new Guardabosques("Rubeus","Hagrid",50,2,"Guardabosques",null,null); // nulo porque los guardabosques no tienen casa asociada ni imparten clase.
    Conserjes c = new Conserjes("Argus","Filch",45,0,"Conserje",null,null);// nulo porque los conserjes no tienen casa asociada ni imparten clase.
    Docentes d1 = new Docentes("Severus","Snape",47,2,"Docente",null, Docentes.Asignatura.Defensa);// nulo porque los docentes no tienen casa asociada.
    Docentes d2 = new Docentes("Minerva","McGonagall",47,1,"Docente",null, Docentes.Asignatura.Transformaciones);// nulo porque los docentes no tienen casa asociada.
    Fantasmas f1 = new Fantasmas("Barón","Sanguinario",200,1,"Fantasma", Residentes.CASA.Slythering,null);// nulo porque los fantasmas no imparten clase.
    Fantasmas f2 = new Fantasmas("Nick","Casi decapitado",175,1,"Fantasma", Residentes.CASA.Gryffindor,null);// nulo porque los fantasmas no imparten clase.
    Estudiantes e1 = new Estudiantes("Hermione","Granger",17,3,"Estudiante", Residentes.CASA.Gryffindor,null);//nulo porque los estudiantes no imparten clase.
    Estudiantes e2 = new Estudiantes("Luna","Lovegood",17,1,"Estudiante", Residentes.CASA.Ravenclaw,null);//nulo porque los estudiantes no imparten clase.
    Estudiantes e3 = new Estudiantes("Cedric","Diggory",16,0,"Estudiante", Residentes.CASA.Hufflepuff,null);//nulo porque los estudiantes no imparten clase.

    //AQUÍ CREAMOS MÁS PARA AUMENTAR EL COVERAGE DE ALGUNOS CAMPOS QUE NO HAN SIDO TOCADOS COMO DOCENTES DE HERBOLOGÍA,HISTORIA Y POCIONES O UN ESTUDIANTE DE SLYTHERING.
    Estudiantes e4 = new Estudiantes("Draco","Malfoy",17,2,"Estudiante", Residentes.CASA.Slythering,null);//nulo porque los estudiantes no imparten clase.
    Docentes d3 = new Docentes("Horace","Slughorn",39,1,"Docente",null, Docentes.Asignatura.Pociones);// nulo porque los docentes no tienen casa asociada.
    Docentes d4 = new Docentes("Pomona","Sprout",44,1,"Docente",null, Docentes.Asignatura.Herbologia);// nulo porque los docentes no tienen casa asociada.
    Docentes d5 = new Docentes("Cuthbert","Binns",51,1,"Docente",null, Docentes.Asignatura.Historia);// nulo porque los docentes no tienen casa asociada.


    //TEST BÁSICOS
    @Test
    public void testGetName(){
        assertEquals("Minerva",d2.getName());
        assertEquals("Luna",e2.getName());
        assertEquals("Argus",c.getName());
        assertEquals("Barón",f1.getName());
    }

    @Test
    public void testGetSurname(){
        assertEquals("McGonagall",d2.getSurname());
        assertEquals("Lovegood",e2.getSurname());
        assertEquals("Filch",c.getSurname());
        assertEquals("Sanguinario",f1.getSurname());
    }

    @Test
    public void testGetAge(){
        assertEquals(47,d2.getAge());
        assertEquals(17,e2.getAge());
        assertEquals(45,c.getAge());
        assertEquals(200,f1.getAge());
    }

    @Test
    public void testGetHorrocruxes(){
        assertEquals(1,d2.getHorrocruxes());
        assertEquals(1,e2.getHorrocruxes());
        assertEquals(0,c.getHorrocruxes());
        assertEquals(1,f1.getHorrocruxes());
    }

    @Test
    public void testGetCategory() {
        assertEquals("Docente de Transformaciones", d2.getCategory());
        assertEquals("Estudiante de Ravenclaw", e2.getCategory());
        assertEquals("Conserje", c.getCategory());
        assertEquals("Fantasma de Slythering", f1.getCategory());
    }


    @Test
    public void testGetHouse(){
        assertNull(d2.getHouse());
        assertEquals(Residentes.CASA.Ravenclaw,e2.getHouse());
        assertNull(c.getHouse());
        assertEquals(Residentes.CASA.Slythering,f1.getHouse());
    }

    @Test
    public void testGetSubject(){
        assertEquals(Docentes.Asignatura.Transformaciones,d2.getSubject());
        assertNull(e2.getSubject());
        assertNull(c.getSubject());
        assertEquals(Docentes.Asignatura.Defensa,d1.getSubject());

    }

    //TEST PRINCIPALES

    @Test
    public void testDocenteRepetido(){
        Docentes d3 = new Docentes("Albus","Dumbledore",60,1,"Docente",null, Docentes.Asignatura.Defensa);
        Integrantes.addIntegrante(d1);
        assertThrows(IllegalArgumentException.class,()->Integrantes.addIntegrante(d3)); // NO PUEDE HABER 2 DOCENTES EN UNA MISMA ASIGNATURA.
        Integrantes.Hogwarts.clear(); // para que se quite al d1 de la lista para luego ejecutar bien el imprimirRecompensas() y el imprimirSalarios();
    }

    @Test
    public void testExcepcionesALaHoraDeCrearUnIntegrante(){

        assertThrows(IllegalArgumentException.class,()->new Estudiantes(null,"Potter",17,2,"Estudiante",null,null));
        assertThrows(IllegalArgumentException.class,()->new Estudiantes("Harry",null,17,2,"Estudiante",null,null));
        assertThrows(IllegalArgumentException.class,()->new Estudiantes("Harry","Potter",-17,2,"Estudiante",null,null));
        assertThrows(IllegalArgumentException.class,()->new Estudiantes("Harry","Potter",17,-3,"Estudiante",null,null));
        assertThrows(IllegalArgumentException.class,()->new Estudiantes("Harry","Potter",17,2,null,null,null));

    }
    @Test
    public void testGetSueldo(){
        assertEquals(500,d1.getSueldo()); // Sueldo por ser Docente de Transformaciones.
        assertEquals(400,d2.getSueldo()); // Sueldo por ser Docente de Defensa, el 25% de reducción solo se tiene en cuenta en la recompensa.
        assertEquals(350,d3.getSueldo()); // Sueldo por ser Docente de Pociones.
        assertEquals(250,d4.getSueldo()); // Sueldo por ser Docente de Herbología.
        assertEquals(200,d5.getSueldo()); // Sueldo por ser Docente de Historia.
    }

    @Test
    public void testGetRecompensa(){
        assertEquals(270,e1.getRecompensa()); //90*3 recompensa por estudiante gryffindor
        assertEquals(160,f1.getRecompensa()); //(80*1) * 2 por ser fantasma de SLYTHERING, doble de recompensa.
        assertEquals(75,d1.getRecompensa()); //(50*2)*0,75 por ser Docente de DEFENSA, reducción del 25 %.
        assertEquals(50,d2.getRecompensa()); //(50*2) sin reducción por ser DOCENTE de Transformaciones. La modificación del 25% es solo para Docentes de DEFENSA.
        assertEquals(0,c.getRecompensa()); //(65*0)
        assertEquals(150,g.getRecompensa()); //(75*2)
        assertEquals(360,e4.getRecompensa());
    }

    @Test
    public void testGetNocturnidad(){
        g.setNocturnidad(2);
        c.setNocturnidad(3);
        assertEquals(2,g.getNocturnidad());
        assertEquals(3,c.getNocturnidad());
        assertEquals(190,g.getSueldo()); // 170 + 10*2 nocturnidades.
        assertEquals(180,c.getSueldo()); // 150 + 10*3 nocturnidades.
    }

    @Test
    public void testImprimirRecompensas(){
        Integrantes.addIntegrante(g);
        Integrantes.addIntegrante(c);
        Integrantes.addIntegrante(d1);
        Integrantes.addIntegrante(d2);
        Integrantes.addIntegrante(f1);
        Integrantes.addIntegrante(f2);
        Integrantes.addIntegrante(e1);
        Integrantes.addIntegrante(e2);
        Integrantes.addIntegrante(e3);
        assertEquals("""
                Rubeus Hagrid(Guardabosques,2 horrocruxes): 150.0 galeones
                Argus Filch(Conserje,0 horrocruxes): 0.0 galeones
                Severus Snape(Docente,2 horrocruxes): 75.0 galeones
                Minerva McGonagall(Docente,1 horrocruxes): 50.0 galeones
                Barón Sanguinario(Fantasma,1 horrocruxes): 160.0 galeones
                Nick Casi decapitado(Fantasma,1 horrocruxes): 80.0 galeones
                Hermione Granger(Estudiante,3 horrocruxes): 270.0 galeones
                Luna Lovegood(Estudiante,1 horrocruxes): 90.0 galeones
                Cedric Diggory(Estudiante,0 horrocruxes): 0.0 galeones
                La recompensa total del Colegio Hogwarts es de 875.0 galeones""",Colegio.imprimirRecompensas(Integrantes.Hogwarts));

        Integrantes.Hogwarts.clear(); // Para que no salte la excepción de " YA HAY DOCENTE IMPARTIENDO ESTA ASIGNATURA" cuando se añaden en el test de imprimirSalarios.
    }


    @Test
    public void testImprimirSalarios(){
        Integrantes.addIntegrante(g);// SALARIO POR PERSONAL
        Integrantes.addIntegrante(c);// SALARIO POR PERSONAL
        Integrantes.addIntegrante(d1);// SALARIO POR PERSONAL
        Integrantes.addIntegrante(d2);// SALARIO POR PERSONAL
        Integrantes.addIntegrante(f1);// SIN SALARIO POR RESIDENTE
        Integrantes.addIntegrante(f2);// SIN SALARIO POR RESIDENTE
        Integrantes.addIntegrante(e1);// SIN SALARIO POR RESIDENTE
        Integrantes.addIntegrante(e2);// SIN SALARIO POR RESIDENTE
        Integrantes.addIntegrante(e3);// SIN SALARIO POR RESIDENTE
        assertEquals("""
                Rubeus Hagrid(Guardabosques): 170 galeones
                Argus Filch(Conserje): 150 galeones
                Severus Snape(Docente): 500 galeones
                Minerva McGonagall(Docente): 400 galeones
                Barón Sanguinario(Fantasma): 0 galeones
                Nick Casi decapitado(Fantasma): 0 galeones
                Hermione Granger(Estudiante): 0 galeones
                Luna Lovegood(Estudiante): 0 galeones
                Cedric Diggory(Estudiante): 0 galeones
                El gasto de Hogwarts en personal es de 875.0 galeones""",Colegio.imprimirSalarios(Integrantes.Hogwarts));

        Integrantes.Hogwarts.clear(); // Para que no salte la excepción de "YA HAY DOCENTE IMPARTIENDO ESTA ASIGNATURA" cuando se añaden en el test de imprimirRecompensas.
    }
}