package e3;

public class TopicOfInterest {
    private final String topic;

    public TopicOfInterest(String aficion){
        this.topic=aficion;
    }

    public String getAficion(){
        return topic;
    }

    @Override
    public String toString(){
        return getAficion();
    }
}
