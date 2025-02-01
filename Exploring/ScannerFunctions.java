import java.util.Scanner;

public class ScannerFunctions {
    public static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
    
    public static String replaceVowels(String str) {
        StringBuilder result = new StringBuilder();
        int numCount = 0;
        
        for (char c : str.toCharArray()) {
            if (isVowel(c)) {
                result.append(numCount % 10);
                numCount++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.isEmpty()) break;
            System.out.println(replaceVowels(s));
        }
    }
}