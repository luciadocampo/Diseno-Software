package e3;

import java.util.*;

public class MapaMatriz implements NetworkManager {
    private String[][] mm;
    private int z=-1;

    //CREACIÓN DE LA MATRIZ.
    public MapaMatriz() {
        mm = new String[512][512]; // Matriz normalmente con potencias de 2 para sus dimensiones. En este caso cogemos 2^9.
    }
    //FUNCIONES DE LA INTERFAZ
    @Override
    public void addUser(String user, List<TopicOfInterest> topicOfInterest) {
        int x = encontrarUsuarioAux();
        if (x != -1) {
            mm[x][0] = user;
        for (int i = 1; i < topicOfInterest.size() + 1 && i < 511; i++) {
            mm[x][i] = topicOfInterest.get(i - 1).getAficion();
        }
    }
}

    @Override
    public void removeUser(String user) {
        int x=encontrarUsuario(user);
        if(x!=-1){
            mm[x][0]=user;
            for(int i=1;i<511;i++){
                mm[x][i] = null;
            }
        }
    }

    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        int x=encontrarUsuario(user),y;
        if(x!=-1){
            y=encontrarAficionAux(x);
            mm[x][y]=topicOfInterest.getAficion();
        }
    }

    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        int x=encontrarUsuario(user);
        int y=encontrarAficion(x,topicOfInterest);
        if(x!=-1 && y!=-1){
            mm[x][y]=null;
        }
    }

    @Override
    public List<String> getUsers() {
        List<String> usuarios = new ArrayList<>();
        for (int x=0;mm[x][0] != null && x<512; x++){
            usuarios.add(mm[x][0]);
        }
        return usuarios;
    }

    @Override
    public List<TopicOfInterest> getInterests() {
        List<TopicOfInterest> aficiones = new ArrayList<>();
        for(int x=0;mm[x][0]!=null && x<256;x++){
            aficiones.addAll(getInterestsUser(mm[x][0]));
        }
        return aficiones;
    }

    @Override
    public List<TopicOfInterest> getInterestsUser(String user) {
        List<TopicOfInterest> aficiones = new ArrayList<>();
        int x=encontrarUsuario(user);
        if(x!=-1){
            for(int y=1;mm[x][y]!=null && y<512;y++){
                aficiones.add(getInterests().get(0));
            }
        }
        return aficiones;
    }

    @Override
    public List<TopicOfInterest> getInteresesEnComun(String primero, String segundo) {
        return null;
    }

    //FUNCIONES AUXILIARES DE COMPROBACIONES Y BÚSQUEDAS PARA LAS FUNCIONES DE LA INTERFAZ.
    boolean listaUsuarioLlena(){
        return mm[511][0]!=null;
    }

    public int encontrarUsuario(String user){
        int x=-1;
        for(int y=0;mm[y][0]!=null && y<512;y++){
            if(mm[y][0].equals(user)){
                x=y;
                break;
            }
        }
        return x;
    }

    public int encontrarUsuarioAux(){
        if(!listaUsuarioLlena()){
            z++;
            for(int y=0;mm[y][0] !=null && y<511 ;y++){
                y=z;
            }
        }
        return z;
    }

    boolean listaAficionesLlena(int x){
        return mm[x][511]!=null;
    }

    public int encontrarAficion(int k,TopicOfInterest aficion){
        int x=-1;
        for(int y=0;mm[y][0]!=null && y<512;y++){
            if(mm[k][y].equals(aficion.getAficion())){
                x=y;
                break;
            }
        }
        return x;
    }

    public int encontrarAficionAux(int x){
        if(!listaAficionesLlena(x)){
            z++;
            for(int y=0;mm[x][y] !=null && y<511;y++){
                z=y;
            }
        }
        return z;
    }

    //FUNCIÓN TO STRING PARA IMPRIMIR.
    @Override
    public String toString(){
        StringBuilder mapa = new StringBuilder();
        for(int i=0;i<mm.length;i++){
            for(int j=0;j<mm.length;j++){
                if(mm[i][j]!=null){
                    mapa.append(mm[i][j]).append(" ");
                }
            }
        }
        return mapa.toString();
    }
}
