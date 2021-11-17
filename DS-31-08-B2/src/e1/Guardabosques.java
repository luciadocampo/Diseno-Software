package e1;

public class Guardabosques extends Personal{

    int nocturnidad;

    public Guardabosques(String nombre, String apellido, int edad, int horrocruxes, String categoria, Residentes.CASA casa, Docentes.Asignatura asignatura) {
        super(nombre, apellido, edad, horrocruxes, categoria, casa, asignatura);
    }

    public void setNocturnidad(int nocturnidad) {
        this.nocturnidad = nocturnidad;
    }

    public int getNocturnidad(){
        return nocturnidad;
    }

    public int getSueldo(){
        return 170+(10*nocturnidad);
    }

    public double getRecompensa(){
        return 75*horro;
    }

}
