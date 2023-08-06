package Decorator;

import java.io.*;

public class InputStreamTest {
    public static void main(String[] args) throws FileNotFoundException {
        int c;
        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("/Users/bhanujggandhi/Developer/learn/java-template/DesignPatterns/src/Decorator/test.txt")));

            while((c = in.read()) >= 0) {
                System.out.print((char) c);
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
