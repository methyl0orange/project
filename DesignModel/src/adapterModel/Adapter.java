package adapterModel;

public class Adapter extends Adapted implements Target {
    @Override
    public void request() {

        System.out.println("目标方法");
    }
}
