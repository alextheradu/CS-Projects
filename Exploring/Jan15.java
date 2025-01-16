
public class Jan15 {

public static String textReverse(String str) {
    String rts = "";
    for(int i = str.length() - 1; i >= 0; i--)
        rts = rts + str.charAt(i);
    return rts;
}
public static int countVowels(String str) {
    int counter = 0;
    for(int i = 0; (str.length() - 1) > i; i++)
        if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u')
            counter++;
    if(counter > 0) return counter;
    else return -1;
}
public static int indexOfNthOccurrence(String str, String target, int whichOne) {
    int again = 0;
    for (int i = 0; i <= str.length() - target.length(); i++) {
        if (str.substring(i, i + target.length()).equals(target)) {
            again++;
            if (again == whichOne) {
                return i;
            }
        }
    }
    return -1;
}
    public static void main(String[] args)
    {
        String text = "Imagination";
        String reverse = textReverse(text);
        System.out.println("The reverse of "+text+" is "+reverse);

        String text1 = "Stop on your right foot, don't forget it!";
        int count = countVowels(text1);
        System.out.println("There are "+count+" vowels in the text: "+text1);

        String text2 = "The only people who don't like krabby patties have never tasted one." ;
        String target2 = "e"; //account for both upper and lowercase letters
        int whichOne2 = 4;
        int index2 = indexOfNthOccurrence(text2, target2, whichOne2);
        System.out.println("Occurrence #" + whichOne2 + " of an \'" + target2 +
        "\' is at index " + index2 + ".");

    }
}