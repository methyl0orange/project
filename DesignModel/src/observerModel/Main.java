package observerModel;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Child child=new Child();
        child.wakeUp();
    }
}

class Child{
    boolean isCry;
    private List<Observer> observers=new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add(new Mum());
    }

    public boolean isCry() {
        return isCry;
    }
    public void wakeUp(){
        isCry=true;
        wakeUpEvent event=new wakeUpEvent(System.currentTimeMillis(),"bed",this);
        for(Observer o:observers){
            o.actionOnWakeUp(event);
        }
    }
}
abstract class Event<T>{
    abstract T getSource();
}


//事件类
class wakeUpEvent extends Event<Child>{
    long timestamp;
    String loc;
    Child source;

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public wakeUpEvent(long timestamp, String loc,Child child) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source=child;
    }

    @Override
    Child getSource() {
        return source;
    }
}

interface Observer{
    void actionOnWakeUp(wakeUpEvent event);
}

class Dad implements Observer{


    public void feed(){
        System.out.println("dad feed----");
    }
    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        if(event.loc.equals("bed")){
            feed();
        }else{
            event.setLoc("bed");
            System.out.println("放在床上");
        }

    }
}
class Mum implements Observer{


    public void hug(){
        System.out.println("mum hug----");
    }
    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        if(event.loc.equals("bed")){
            hug();
        }else{
            System.out.println("放在床上");
        }
    }
}