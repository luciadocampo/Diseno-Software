package e3;

import java.util.*;

public class MapaHash implements NetworkManager{
    private final Map<String, List<TopicOfInterest>> hashmap;
    private final List<TopicOfInterest> aficionesComunes = new ArrayList<>();
    private final List<TopicOfInterest> aficiones = new ArrayList<>();

    public MapaHash(){
        hashmap = new HashMap<>();
    }

    public void addUser(String user, List<TopicOfInterest> topicOfInterest){
        hashmap.put(user, topicOfInterest);
    }

    public void removeUser(String user){
        hashmap.remove(user);
    }
    public void addInterest(String user, TopicOfInterest topicOfInterest){
        List<TopicOfInterest> aficion = hashmap.get(user);
        aficion.add(topicOfInterest);
    }
    public void removeInterest(String user, TopicOfInterest topicOfInterest){
        List<TopicOfInterest> aficion = hashmap.get(user);
        aficion.remove(topicOfInterest);
    }
    public List<String> getUsers(){
        return new ArrayList<>(hashmap.keySet());
    }
    public List<TopicOfInterest> getInterests(){
        for(String user : hashmap.keySet()){
            aficiones.addAll(hashmap.get(user));
        }
        return aficiones;
    }
    public List<TopicOfInterest> getInterestsUser(String user){
        return hashmap.get(user);
    }

    @Override
    public List<TopicOfInterest> getInteresesEnComun(String primero,String segundo){
        for(TopicOfInterest aficion1 : getInterestsUser(primero)){
            for(TopicOfInterest aficion2 : getInterestsUser(segundo)){
                if(aficion1.equals(aficion2)){
                    aficionesComunes.add(aficion1);
                }
            }
        }
        return aficionesComunes;
    }

    //FUNCIÓN TO STRING PARA IMPRIMIR.
    @Override
    public String toString(){
        StringBuilder mapa = new StringBuilder();
        for (Map.Entry<String,List<TopicOfInterest>> usuarios : hashmap.entrySet()) {
            mapa.append(usuarios).append(" ");
        }
        return mapa.toString();
    }
}
