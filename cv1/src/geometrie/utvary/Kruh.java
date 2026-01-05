package geometrie.utvary;

public class Kruh {
    public static final double PI = 3.1415927;

    private int polomer;
    private int stredX;
    private int stredY;

    public Kruh(int polomer, int stredX, int stredY) {
        this.polomer = polomer;
        this.stredX = stredX;
        this.stredY = stredY;
    }

    public int getPolomer() {
        return polomer;
    }

    public void setPolomer(int polomer) {
        this.polomer = polomer;
    }

    public int getStredX() {
        return stredX;
    }

    public void setStredX(int stredX) {
        this.stredX = stredX;
    }

    public int getStredY() {
        return stredY;
    }

    public void setStredY(int stredY) {
        this.stredY = stredY;
    }

    public double obvod() {
        return 2 * PI * this.polomer;
    }

    public int obvodInt() {
        return (int) obvod();
    }
}
