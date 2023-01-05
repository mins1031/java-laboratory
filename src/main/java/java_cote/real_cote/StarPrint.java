package java_cote.real_cote;

import java.util.Scanner;
import java.util.stream.IntStream;

public class StarPrint {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int height = sc.nextInt();

//        for (int heightCount = 0; heightCount < height; heightCount++) {
//            for (int widthCount = 0; widthCount < width; widthCount++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }

        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, width).forEach(s -> stringBuilder.append("*"));
        IntStream.range(0, height).forEach(s -> System.out.println(stringBuilder.toString()));
    }
}
