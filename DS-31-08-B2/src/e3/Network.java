package e3;

import java.util.*;

public class Network implements NetworkManager{
    private final NetworkManager nw;
    private final List<TopicOfInterest> aficionesComunes = new ArrayList<>();

    @Override
    public void addUser(String user, List<TopicOfInterest> topicOfInterest){
        nw.addUser(user, topicOfInterest);
    }
    @Override
    public void removeUser(String user){
        nw.removeUser(user);
    }
    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest){
        nw.addInterest(user,topicOfInterest);
    }
    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest){
        nw.removeInterest(user,topicOfInterest);
    }
    @Override
    public List<String> getUsers(){
        return nw.getUsers();
    }
    @Override
    public List<TopicOfInterest> getInterests(){
        return nw.getInterests();
    }
    @Override
    public List<TopicOfInterest> getInterestsUser(String user){
        return nw.getInterestsUser(user);
    }

    public Network(NetworkManager nw){
        this.nw=nw;
    }

    public NetworkManager getNetwork(){
        return nw;
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
}
