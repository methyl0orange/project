package factoryModel.abtractFactory;

import factoryModel.factory.Factory;

public class abtractFactoryTest {
    public static void main(String[] args) {
        AbtractFactory baomaFactory=new BaomaFactory();
        baomaFactory.cratePC().make();
        baomaFactory.createCar().didi();
    }
}
