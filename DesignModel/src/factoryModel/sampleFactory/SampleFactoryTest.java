package factoryModel.sampleFactory;

public class SampleFactoryTest {
    public static void main(String[] args) {
        CarFactory carFactory=new CarFactory();
        carFactory.CreateCar("Baoma").run();

    }
}
