package factoryModel.factory;

public class FactoryTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 使用反射机制实例化工厂对象，因为字符串是可以通过变量改变的
        Factory benchiFactory = (Factory) Class.forName("factoryModel.factory.BenchiFactory").newInstance();
        Factory baomaFactory=(Factory) Class.forName("factoryModel.factory.BaomaFactory").newInstance();

        baomaFactory.createCar().run();
        benchiFactory.createCar().didi();
    }
}
