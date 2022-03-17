public class Dimension {

    private int height;
    private int width;
    private int trunkCapacity;

    public Dimension(int high, int width, int trunkCapacity) {
        this.height = high;
        this.width = width;
        this.trunkCapacity = trunkCapacity;
    }

    public int getTrunkCapacity() {
        return trunkCapacity;
    }
}
