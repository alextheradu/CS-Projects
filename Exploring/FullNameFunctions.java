public class FullNameFunctions {
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
    public static void main(String[] args) {
        String fullName = "Alex Radu";
        System.out.println(getInitials(fullName));
        System.out.println(getEmail(fullName));

        String text = "I love Java!";
        System.out.println("You entered: \"" + text + "\"");
        System.out.println("The string \"" + text + "\" has " + text.length() + " characters.");
        System.out.println("In all uppercase, it reads: " + text.toUpperCase());
        System.out.println("In all lowercase, it reads: " + text.toLowerCase());
        System.out.println("The character 'a'  is found at index " + text.indexOf('a'));
        System.out.println("The character at the end of the string is: " + text.charAt(text.length() - 1));
        System.out.println("The first half of the string is: " + text.substring(0, text.length() / 2));
        System.out.println("The second half of the string is: " + text.substring(text.length() / 2));
        System.out.println("The first word of the string is: " + text.substring(0, text.indexOf(" ")));
        System.out.println("Replacing all 'a's with '@'s gives: " + text.replace('a', '@'));
    }
}
