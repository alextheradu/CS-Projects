package MyLoremIspum;

public class MyString {

    public static int indexOf (String str, char letter) {
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == letter)
                return i;
        return -1;
    }
    public static int indexOf (String str, String target) {
        for(int i = 0; i <str.length(); i++)
            if(str.substring(i, i+target.length()).equals(target))
                return i;
        return -1;
    }
    //write a function that returns the number of times a target string appears in the given string.
    public static int countChar(String str, String target){
        int count = 0;
        for(int i = 0; i <= str.length() - target.length(); i++){
            if(str.substring(i, i + target.length()).equals(target))
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        String text = "This is only a test!";
        char target = 'p';

        int index = indexOf(text, target);
        if(index > -1)
            System.out.println("The text \"" + text + "\" has the character \"" + target + "\" at index " + index);
        else
            System.out.println("The text \"" + text + "\" does not have the character \"" + target + "\".");
        
        String targetS = "only";
        int indexS = text.indexOf(targetS);
        if(indexS > -1)
            System.out.println("The string \"" + targetS + "\" is found in the string at index " + indexS);
        else
            System.out.println("The string \"" + targetS + "\" is not found in the string.");



        String text2 = "Is mayonnaise an instrument in Indonesia?";
        String target2 = "in"; //account for both upper and lowercase letters
        int total = countChar(text2, target2);
        System.out.println("The text: "+text2+" has "+total+" of the letter "+target2);


    }
}