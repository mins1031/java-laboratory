package java_lab.Test;

public class MashTest1 {

    public static int powerJump(String game) {
        // Write your code here
        int maxJumpPower = 1;
        int jumpCount = 1;
        String startBinary = String.valueOf(game.charAt(game.length() - 1));

        for (String arg : game.split("")) {
            if (!arg.equals(startBinary)) {
                jumpCount++;
            } else {
                if (jumpCount != 1 && jumpCount > maxJumpPower) {
                    maxJumpPower = jumpCount;
                }
                jumpCount = 1;
            }
        }

        return maxJumpPower;
    }

    public static void main(String[] args) {
        String game = "110100101";
        System.out.println(powerJump(game));
    }
}
