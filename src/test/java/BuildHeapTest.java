import org.junit.Test;

public class BuildHeapTest {

    @Test
    public void testGetSwapsHeap() {
        int[] input = {18, 8, 23, 8, 9, 99, 12, 8, 9};
        System.out.println(BuildHeap.getSwapsHeap(input));
        BuildHeap.printLevels(input);
    }

    @Test
    public void testSample1() {
        int[] input = {5, 4, 3, 2, 1};
        System.out.println(BuildHeap.getSwapsHeap(input));
        BuildHeap.printLevels(input);
    }

    @Test
    public void testSample2() {
        int[] input = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        System.out.println(BuildHeap.getSwapsHeap(input));
        BuildHeap.printLevels(input);
    }
}