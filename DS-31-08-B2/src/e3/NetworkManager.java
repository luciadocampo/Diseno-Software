package e3;

import java.util.*;

public interface NetworkManager {
    void addUser(String user, List<TopicOfInterest> topicOfInterest);
    void removeUser(String user);
    void addInterest(String user, TopicOfInterest topicOfInterest);
    void removeInterest(String user, TopicOfInterest topicOfInterest);
    List<String> getUsers();
    List<TopicOfInterest> getInterests();
    List<TopicOfInterest> getInterestsUser(String user);
    List<TopicOfInterest> getInteresesEnComun(String primero,String segundo);
}
