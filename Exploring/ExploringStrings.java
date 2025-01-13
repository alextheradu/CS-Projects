public class ExploringStrings {
 public static void main(String[] args) {
   //  String fullName = "Albert Einstein";
   //  int spaceOfSpace = fullName.indexOf(" ");
   //  String firstName = fullName.substring(0, spaceOfSpace);
   //  String lastName = fullName.substring(spaceOfSpace + 1);
   //  System.out.println(lastName + ", " + firstName);

   //Write code to count and print the number of times that the letter 'e' occurs in the text string.
   String text = "The quick brown fox jumps over the lazy dog.";
   int count = 0;
   int countVowels = 0;
   for (int i = 0; i < text.length(); i++) {
      char ch = text.charAt(i);
     if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
       countVowels++;
     }
     if (text.charAt(i) == 'e') {
       count++;
     }
   }
   System.out.println("There are " + count + " letter 'e' in the text.");
   System.out.println("There are " + countVowels + " vowels in the text.");
    
 }   
}