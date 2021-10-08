package factoryModel;


public class Benchi implements Car {
    @Override
    public void run() {
        System.out.println("benchi跑了");
    }

    @Override
    public void didi() {
        System.out.println("benchi鸣笛");
    }
}
