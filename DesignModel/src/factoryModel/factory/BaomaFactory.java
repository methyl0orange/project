package factoryModel.factory;

import factoryModel.Baoma;
import factoryModel.Car;

public class BaomaFactory implements Factory {
    @Override
    public Car createCar() {
        return new Baoma();
    }
}
