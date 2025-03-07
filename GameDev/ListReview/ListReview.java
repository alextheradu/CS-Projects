package GameDev.ListReview;

import java.util.ArrayList;
import java.util.Collections;

public class ListReview {
    // Make a list that can store names for students in our class
    
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Elijah");
        names.add("Emma");
        names.add("Otro Persona");
        names.add("Alex");

        // Print the list
        for (String name : names)
        System.out.println(name);
        
        System.out.println(names);
        
        // Sort the list alphabetically
        Collections.sort(names);
        System.out.println("SORTED: ");
        System.out.println(names);

        // Find and print a random name from the list
        int randomIndex = (int) (Math.random() * names.size());
        System.out.println("RANDOM: ");
        System.out.println(names.get(randomIndex));

        // Find and print the longest name in the list
        String longestName = "";
        for (String name : names) {
            if (name.length() > longestName.length()) {
                longestName = name;
            }
        }
        System.out.println("LONGEST: ");
        System.out.println(longestName);
        
        // Find and print the shortest name in the list
        String shortestName = names.get(0); 
        for (String name : names) {
            if (name.length() < shortestName.length()) {
                shortestName = name;
            }
        }
        System.out.println("SHORTEST: ");
        System.out.println(shortestName);

        // Find and print the total amount of characters in the list
        int totalCharacters = 0;
        for (String name : names) {
            totalCharacters += name.length();
        }
        System.out.println("TOTAL CHARACTERS: ");
        System.out.println(totalCharacters);

        // Swap the first and last names in the list
        String firstName = names.get(0);
        String lastName = names.get(names.size() - 1);
        names.set(0, lastName);
        names.set(names.size() - 1, firstName);
        System.out.println("SWAPPED: ");
        System.out.println(names);
        names.set(0, names.get(names.size() - 1));
        names.set(names.size() - 1, firstName);
        System.out.println("UNSWAPPED: ");
        System.out.println(names);
    }
}
