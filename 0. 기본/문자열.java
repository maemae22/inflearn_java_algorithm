import java.util.*;
import java.io.*;

public class 문자열 {
    public static void main(String[] args) throws Exception {
        String letter = "sdfjlkjglsdfdsf";

        char c = letter.toUpperCase().charAt(0); // String 대문자로 : .toUpperCase()
        char sameChar = Character.toUpperCase(letter.charAt(0)); // Char 대문자로 : Character.toUpperCase(char);
        char[] cArray = letter.toCharArray();

        // ⭐ 소문자인지 대문자인지 판별하고, 소문자는 대문자로, 대문자는 소문자로 바꾸는 방법
        // 방법1. 문자열 아스키코드
        // 숫자는 48 ~ 57, 영문 대문자는 65 ~ 90, 영문 소문자는 97 ~ 122.
        // 영문 소문자에서 32를 빼면 영문 대문자가 된다.
        if (65 <= c && c<=90) {
            System.out.println((char)(c+32));
        } else {
            System.out.println((char)(c-32));
        }

        // 방법2. Character 클래스 이용
        if(Character.isLowerCase(c)) {
            System.out.println(Character.toUpperCase(c));
        } else {
            System.out.println(Character.toLowerCase(c));
        }

        // ⭐ 10진수 <-> 2진수, 8진수, 16진수 변환
        // 10진수 -> 2진수, 8진수, 16진수 : Integer 클래스의 toBinaryString(int i), toOctalString(int i), toHexaString(int i)
        int decimal = 10;
        String binary = Integer.toBinaryString(decimal); // 10진수 -> 2진수
        String octal = Integer.toOctalString(decimal); // 10진수 -> 8진수
        String hexaDecimal = Integer.toHexString(decimal); // 10진수 -> 16진수

        // 2진수, 8진수, 16진수 -> 10진수 : Integer.parseInt(String s, int radix)
        int binaryToDecimal = Integer.parseInt("1010", 2);
        int octalToDecimal = Integer.parseInt("12", 8);
        int hexaToDecimal = Integer.parseInt("A", 16);

        // ⭐ Character 가 숫자인지 확인하고, 숫자라면 int형으로 바꾸는 방법
        // Character.isDigit(c) / c-48 (아스키코드 활용)
        char five = '5';
        char notFive = '$';

        if (Character.isDigit(five)) {
            System.out.println("Character.isDigit(five) = " + Character.isDigit(five));
            System.out.println("five - 48 = " + (five - 48));
        }
        System.out.println("Character.isDigit(notFive) = " + Character.isDigit(notFive));
        System.out.println("notFive - 48 = " + (notFive - 48));

    }
}
