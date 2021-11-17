package e1;

import java.util.ArrayList;

public abstract class Integrantes {
    String name;
    String surname;
    int horro;
    int age;
    String category;
    Residentes.CASA house;
    Docentes.Asignatura subject;
    static ArrayList<Integrantes> Hogwarts = new ArrayList<>();

    public Integrantes(String nombre, String apellido,int edad, int horrocruxes, String categoria, Residentes.CASA casa, Docentes.Asignatura asignatura) {
        if(nombre==null || apellido == null || horrocruxes<0 || edad < 0 || categoria==null){
            throw new IllegalArgumentException();
        }
        else {
            this.name = nombre;
            this.surname = apellido;
            this.horro = horrocruxes;
            this.age = edad;
            this.category = categoria;
        }
        this.house=casa;
        this.subject=asignatura;
    }

    public static void addIntegrante(Integrantes i){
        if(Hogwarts.isEmpty()){
            Hogwarts.add(i);
        }
        else {
            if(i.subject!=null) {
                for (Integrantes hogwarts : Hogwarts) {
                    if (i.subject == hogwarts.subject) {
                        throw new IllegalArgumentException("Ya hay un docente impartiendo esta asignatura");
                    }
                }
            }
            Hogwarts.add(i);
        }
    }

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public int getHorrocruxes(){
        return horro;
    }
    public Residentes.CASA getHouse(){
        return house;
    }

    public Docentes.Asignatura getSubject(){
        return subject;
    }
    public int getAge(){
        return age;
    }
    public String getCategory(){
        if(house!=null){
            return category+" de "+house;
        }
        if(subject!=null){
            return category+" de "+subject;
        }
        return category;
    }
    public abstract int getSueldo();
    public abstract double getRecompensa();
}
