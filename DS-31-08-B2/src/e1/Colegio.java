package e1;

import java.util.ArrayList;

public class Colegio{

    public static String imprimirRecompensas(ArrayList<Integrantes> Hogwarts){
        double sum=0;
        StringBuilder recompensa= new StringBuilder();
        for (Integrantes hogwarts : Hogwarts) {
            recompensa.append(hogwarts.name).append(" ").append(hogwarts.surname).append("(").append(hogwarts.category).append(",").append(hogwarts.horro).append(" ").append("horrocruxes").append(")").append(":").append(" ").append(hogwarts.getRecompensa()).append(" ").append("galeones").append("\n");
            sum+=hogwarts.getRecompensa();
        }
        return recompensa +"La recompensa total del Colegio Hogwarts es de " + sum + " galeones";
    }

    public static String imprimirSalarios(ArrayList<Integrantes> Hogwarts){
        double sum=0;
        StringBuilder recompensa= new StringBuilder();
        for (Integrantes hogwarts : Hogwarts) {
            recompensa.append(hogwarts.name).append(" ").append(hogwarts.surname).append("(").append(hogwarts.category).append(")").append(":").append(" ").append(hogwarts.getSueldo()).append(" ").append("galeones").append("\n");
            sum+=hogwarts.getRecompensa();
        }
        return recompensa +"El gasto de Hogwarts en personal es de " + sum + " galeones";
    }
}
