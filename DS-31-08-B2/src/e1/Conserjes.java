package e1;

public class Conserjes extends Personal{

    int nocturnidad;

    public Conserjes(String nombre, String apellido, int edad, int horrocruxes, String categoria, Residentes.CASA casa, Docentes.Asignatura asignatura) {
        super(nombre, apellido, edad, horrocruxes, categoria, casa, asignatura);
    }

    public void setNocturnidad(int nocturnidad) {
        this.nocturnidad = nocturnidad;
    }

    public int getNocturnidad(){
        return nocturnidad;
    }

    public int getSueldo(){
        return 150+(10*nocturnidad);
    }

    public double getRecompensa(){
        return 65*horro;
    }
}
