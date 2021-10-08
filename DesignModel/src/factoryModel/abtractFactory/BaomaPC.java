package factoryModel.abtractFactory;

public class BaomaPC implements PC {
    @Override
    public void make() {
        System.out.println("baoma牌PC");
    }
}
