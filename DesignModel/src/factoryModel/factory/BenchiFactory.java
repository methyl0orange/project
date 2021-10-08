package factoryModel.factory;

import factoryModel.Benchi;
import factoryModel.Car;

public class BenchiFactory implements Factory {
    @Override
    public Car createCar() {
        return new Benchi();
    }
}
