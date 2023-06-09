package dev.ahmed;

import org.junit.Test;

/**
 * @author Ahmed Bughra
 * @create 2023-05-25  5:31 AM
 */
public class TestAwsCodeWhisperer {
    // random String generator

    public static String randomStringGenerator(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_+-=[]{};':\",./<>?`~";
        StringBuilder result = new StringBuilder();
        java.util.Random rnd = new java.util.Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }
        return result.toString();
    }
    @Test
    public void testRandomStringGenerator() {
        System.out.println(randomStringGenerator(10));
    }



    public static void main(String[] args) {
        System.out.println("Hello World");
}
}

