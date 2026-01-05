public class Backpack {
    private final int volume;
    private final int loadCapacity;
    private int remainingVolume;
    private int remainingLoadCapacity;

    public Backpack(int volume, int loadCapacity) {
        this.volume = volume;
        this.loadCapacity = loadCapacity;
        this.remainingVolume = volume;
        this.remainingLoadCapacity = loadCapacity;
    }

    public int getVolume() {
        return volume;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public int getRemainingVolume() {
        return remainingVolume;
    }

    public int getRemainingLoadCapacity() {
        return remainingLoadCapacity;
    }

    public boolean putItem(Item item) {
        if (item.getVolume() <= remainingVolume && item.getWeight() <= remainingLoadCapacity) {
            remainingVolume -= item.getVolume();
            remainingLoadCapacity -= item.getWeight();
            return true;
        }
        return false;
    }
}
