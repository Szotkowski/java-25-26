import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @Test
    public void testItemAndBackpack() {
        Item item1 = new Item(5, 3);
        Item item2 = new Item(4, 8);

        Backpack backpack = new Backpack(10, 10);

        assertTrue(backpack.putItem(item1));
        assertEquals(5, backpack.getRemainingVolume());
        assertEquals(7, backpack.getRemainingLoadCapacity());

        assertFalse(backpack.putItem(item2));
    }

    @Test
    public void testRectangleConstructorsAndMethods() {
        Rectangle r1 = new Rectangle(4, 6);
        assertEquals(24, r1.getArea());
        assertEquals(20, r1.getPerimeter());

        Rectangle r2 = new Rectangle(5);
        assertEquals(25, r2.getArea());
        assertEquals(20, r2.getPerimeter());

        Rectangle r3 = new Rectangle();
        assertEquals(15, r3.getArea());
        assertEquals(16, r3.getPerimeter());
    }

    @Test
    public void testRectangleInstanceCount() {
        int before = Rectangle.getInstanceCount();
        new Rectangle(2, 3);
        new Rectangle(7);
        assertEquals(before + 2, Rectangle.getInstanceCount());
    }

    @Test
    public void testRectangleInvalidSides() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-1, 4));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(0, 5));
    }
}
