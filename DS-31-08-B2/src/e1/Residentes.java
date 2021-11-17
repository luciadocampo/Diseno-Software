package e1;

public abstract class Residentes extends Integrantes{

    public Residentes(String nombre, String apellido, int edad, int horrocruxes, String categoria, CASA casa, Docentes.Asignatura asignatura) {
        super(nombre, apellido, edad, horrocruxes, categoria, casa, asignatura);
    }
    enum CASA{Gryffindor,Slythering,Hufflepuff,Ravenclaw}

    @Override
    public abstract int getSueldo();

    @Override
    public abstract double getRecompensa();
}
