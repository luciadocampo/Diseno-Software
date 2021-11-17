package e1;

public class Docentes extends Personal{
    private int sueldo;

    public Docentes(String nombre, String apellido, int edad, int horrocruxes, String categoria, Residentes.CASA casa, Asignatura asignatura) {
        super(nombre, apellido, edad, horrocruxes, categoria, casa, asignatura);
    }

    enum Asignatura{Defensa,Transformaciones,Pociones,Herbologia,Historia}

    public int getSueldo(){
        if(subject==Asignatura.Defensa){
            sueldo=500;
        }
        if(subject==Asignatura.Transformaciones){
            sueldo=400;
        }
        if(subject==Asignatura.Pociones){
            sueldo=350;
        }
        if(subject==Asignatura.Herbologia){
            sueldo=250;
        }
        if(subject==Asignatura.Historia){
            sueldo=200;
        }
        return sueldo;
    }

    public double getRecompensa(){
        if(subject==Asignatura.Defensa){
            return (50*horro)*0.75;
        }
        return 50*horro;
    }

}
