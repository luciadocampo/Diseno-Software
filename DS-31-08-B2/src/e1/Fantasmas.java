package e1;
public class Fantasmas extends Residentes{

    public Fantasmas(String nombre, String apellido, int edad, int horrocruxes, String categoria, CASA casa, Docentes.Asignatura asignatura) {
        super(nombre, apellido, edad, horrocruxes, categoria, casa, asignatura);
    }

    @Override
    public int getSueldo() {
        return 0;
    }

    public double getRecompensa(){
        int r=80*horro;
        if(house==CASA.Slythering){
            return r*2;
        }
        return r;
    }
}
