package factoryModel.abtractFactory;

public class BenchiPC implements PC {
    @Override
    public void make() {
        System.out.println("benchi牌PC");
    }
}
