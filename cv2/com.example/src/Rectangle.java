public class Rectangle {
    private static int instanceCount = 0;

    private int a;
    private int b;

    public Rectangle(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Strany musí být kladné.");
        }
        this.a = a;
        this.b = b;
        instanceCount++;
    }

    public Rectangle(int side) {
        this(side, side);
    }

    public Rectangle() {
        this(3, 5);
    }

    public int getArea() {
        return a * b;
    }

    public int getPerimeter() {
        return 2 * (a + b);
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
