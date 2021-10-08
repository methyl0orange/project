package factoryModel.sampleFactory;

import factoryModel.Baoma;
import factoryModel.Benchi;
import factoryModel.Car;

public class CarFactory {
    public Car CreateCar(String name){
        Car car=null;
        if(name.equals("Baoma")){
            car=new Baoma();
        }else {
            car=new Benchi();
        }
        return car;
    }
}
