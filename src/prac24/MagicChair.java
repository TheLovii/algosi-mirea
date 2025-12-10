package prac24;

public class MagicChair implements Chair {

    public void doMagic() {
        System.out.println("Магический стул творит чудо!");
    }

    @Override
    public void sit() {
        System.out.println("Вы сидите на магическом стуле.");
    }
}
