package e1;

public abstract class Personal extends Integrantes{

    public Personal(String nombre, String apellido, int edad, int horrocruxes, String categoria, Residentes.CASA casa, Docentes.Asignatura asignatura) {
        super(nombre, apellido, edad, horrocruxes, categoria, casa, asignatura);
    }

    @Override
    public abstract int getSueldo();

    @Override
    public abstract double getRecompensa();
}
