package factoryModel.abtractFactory;

import factoryModel.Benchi;
import factoryModel.Car;

public class BenchiFactory implements AbtractFactory{

    @Override
    public Car createCar() {
        return new Benchi();
    }

    @Override
    public PC cratePC() {
        return new BenchiPC();
    }
}
