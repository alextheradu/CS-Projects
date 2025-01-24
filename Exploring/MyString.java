public class MyString {

    //Instance variable
    private String myText;

    //get myText
    public String MyText() {
        return myText;
    }
    public MyString(String text) {
        myText = text;
    }
    public String frontBack() {
        char first = myText.charAt(0);
        char last = myText.charAt(myText.length() - 1);
        String middle = myText.substring(1, myText.length() - 1);
        return last + middle + first;
    }
    public int indexOf(char target) {
        for (int i = 0; i < myText.length(); i++)
            if (myText.charAt(i) == target)
                return i;
        return -1;
    }
    public String reverse() {
        String rts = "";
        for(int i = myText.length() - 1; i >= 0; i--)
            rts = rts + myText.charAt(i);
        return rts;
    }
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
    public static String getInitials(String fullName) {
        String initials = "";
        int spaceOfSpace = fullName.indexOf(" ");
        char firstInitial = fullName.charAt(0);
        char lastInitial = fullName.charAt(spaceOfSpace + 1);
        initials = firstInitial + "." + lastInitial + ".";
        return initials.toUpperCase();
    }
    public static String getEmail(String fullName) {
        String firstName = "";
        String lastName = "";
        //if last name is more than 6 characters, limit last name to 6 characters
        int spaceOfSpace = fullName.indexOf(" ");
        firstName = fullName.substring(0, spaceOfSpace);
        lastName = fullName.substring(spaceOfSpace + 1);
        if (lastName.length() > 6)
            lastName = lastName.substring(0, 6);
        lastName = lastName.toLowerCase();
        firstName = firstName.toLowerCase();
        firstName = firstName.substring(0,2);
        return lastName + firstName + "@pascack.org";
    }

}
