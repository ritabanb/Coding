package BitManipulation;

public class BitGetterSetter {
    private int num;
    private int i;

    public BitGetterSetter(int num, int i) {
        this.num = num;
        this.i = i;
    }

    public boolean getBit() {
        return ((num & (1 << i)) != 0); // i = 1, else i = 0
    }

    public int setBit() {
        return num | (1 << i);
    }

    public int clearBit() {
        int mask = ~(1 << i);
        return num & mask;
    }

    public int updateBit(boolean bitIs1) {
        int value = bitIs1 ? 1 : 0;
        int mask = ~(1 << i);
        return (num & mask) | (value << i);
    }
}
