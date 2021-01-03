import java.io.*;
import java.util.*;

public class BuildHeap {
    private int[] data;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
            data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
            out.println(swap.index1 + " " + swap.index2);
        }
    }

    private void generateSwaps() {
        swaps = new ArrayList<Swap>();
        // The following naive implementation just sorts
        // the given sequence using selection sort algorithm
        // and saves the resulting sequence of swaps.
        // This turns the given array into a heap,
        // but in the worst case gives a quadratic number of swaps.
        //
        // TODO: replace by a more efficient implementation
        for (int i = 0; i < data.length; ++i) {
            for (int j = i + 1; j < data.length; ++j) {
                if (data[i] > data[j]) {
                    swaps.add(new Swap(i, j));
                    int tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }
        }
    }

    static List<Swap> getSwapsHeap(int[] data) {
        ArrayList<Swap> swaps = new ArrayList<>();
        heapify(swaps, data);
        return swaps;
    }

    static void printLevels(int[] data) {
        int i = 0;
        int level = 1;
        while (i < data.length) {
            if (i == ((int) Math.pow(2, level)) - 2) {
                System.out.print(data[i] + "\n");
                level++;
            } else {
                System.out.print(data[i] + ", ");
            }
            i++;
        }
    }

    private static void heapify(ArrayList<Swap> list, int[] data) {
        int startPoint = (data.length / 2) - 1;
        for (int i = startPoint; i >= 0; i--) {
            int currentPoint = i;
            while (true) {
                int min = data[currentPoint];
                int indexToSwap = currentPoint;
                int childL = (currentPoint * 2) + 1;
                int childR = (currentPoint * 2) + 2;
                if (childL < data.length && data[childL] < min) {
                    min = data[childL];
                    indexToSwap = childL;
                }
                if (childR < data.length && data[childR] < min) {
                    min = data[childR];
                    indexToSwap = childR;
                }
                if (indexToSwap == currentPoint)
                    break;
                list.add(new Swap(currentPoint, indexToSwap));
                swap(data, indexToSwap, currentPoint);
                currentPoint = indexToSwap;
            }
        }
    }

    private static void swap(int[] data, int i, int j) {
        int tempI = data[i];
        data[i] = data[j];
        data[j] = tempI;
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        //generateSwaps();
        swaps = getSwapsHeap(data);
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }

        @Override
        public String toString() {
            return index1 + ", " + index2 + "\n";
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
