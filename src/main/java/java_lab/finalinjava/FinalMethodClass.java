package java_lab.finalinjava;

public class FinalMethodClass {
    private String name;

    public FinalMethodClass(String name) {
        this.name = name;
    }

    public final String printName() {
        System.out.println(this.name);
        return this.name;
    }

    public void printTest(final int test) {
        final int localVariable;
        localVariable = 2;
//        localVariable = 3; => 사용 못함
//        test = 4; => 사용 못함
    }

    public int[] multiply(int[] inputs, int multiplier) {
        int[] nums = new int[inputs.length];
        for (int i =0; i < inputs.length; i++) {
            nums[i] = inputs[i] * multiplier;
        }

        return nums;
    }

}
