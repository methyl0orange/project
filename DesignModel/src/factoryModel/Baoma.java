package factoryModel;

import factoryModel.Car;

public class Baoma implements Car {
    @Override
    public void run() {
        System.out.println("baoma跑了");
    }

    @Override
    public void didi() {
        System.out.println("baoma鸣笛");
    }
}
