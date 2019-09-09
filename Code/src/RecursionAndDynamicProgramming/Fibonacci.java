package RecursionAndDynamicProgramming;

public class Fibonacci {
    public int iterative(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;
        int a = 0, b = 1;
        for (int i = 2; i < num; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a + b;
    }

    public int recursive(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;
        return recursive(num - 1) + recursive(num - 2);
    }

    public int memorizationRecursive(int num) {
        return memorizationRecursiveHelper(num, new int[num + 1]);
    }

    public int memorizationRecursiveHelper(int num, int[] mem) {
        if (num == 0) return 0;
        if (num == 1) return 1;
        if (mem[num] == 0)
            mem[num] = memorizationRecursiveHelper(num - 1, mem) + memorizationRecursiveHelper(num - 2, mem);
        return mem[num];
    }

    public int dynamicProgramming(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;
        int[] mem = new int[num];
        mem[0] = 0;
        mem[1] = 1;
        for (int i = 2; i < num; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[num - 1] + mem[num - 2];
    }
}
