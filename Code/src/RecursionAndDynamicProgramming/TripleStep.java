package RecursionAndDynamicProgramming;

public class TripleStep {
    public int climb(int n) {
        if (n == 0 || n == 1) return 1;
        if (n == 2) return 2;
        int[] mem = new int[n + 1];
        mem[0] = mem[1] = 1;
        mem[2] = 2;
        for (int i = 3; i <= n; i++) {
            mem[i] = mem[i - 3] + mem[i - 2] + mem[i - 1];
        }
        return mem[n];
    }

    public static void main(String[] args) {
        TripleStep obj = new TripleStep();
        System.out.println(obj.climb(4));
    }
}
