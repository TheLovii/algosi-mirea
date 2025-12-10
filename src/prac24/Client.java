package prac24;

public class Client {
    private Chair chair;

    public void setChair(Chair chair) {
        this.chair = chair;
    }

    public void sit() {
        if (chair == null) {
            System.out.println("Стул не выбран.");
        } else {
            chair.sit();
        }
    }

    public static void main(String[] args) {
        AbstractChairFactory factory = new ChairFactory();
        Client client = new Client();

        client.setChair(factory.createVictorianChair());
        client.sit();

        MagicChair magicChair = factory.createMagicanChair();
        magicChair.doMagic();
        client.setChair(magicChair);
        client.sit();

        FunctionalChair functionalChair = factory.createFunctionalChair();
        System.out.println("2 + 3 = " + functionalChair.sum(2, 3));
        client.setChair(functionalChair);
        client.sit();
    }
}
