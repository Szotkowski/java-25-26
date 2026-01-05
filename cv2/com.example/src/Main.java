public class Main {
    public static void main(String[] args) {
        Backpack backpack = new Backpack(12, 10);
        Item item = new Item(3, 3);
        backpack.putItem(item);
    }
}