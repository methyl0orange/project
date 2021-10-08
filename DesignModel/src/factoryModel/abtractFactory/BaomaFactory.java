package factoryModel.abtractFactory;

import factoryModel.Baoma;
import factoryModel.Car;

public class BaomaFactory implements AbtractFactory {
    @Override
    public Car createCar() {
        return new Baoma();
    }

    @Override
    public PC cratePC() {
        return new BaomaPC();
    }
}
