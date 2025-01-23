public class MyStringTester {
    public static void main(String[] args) {
        System.out.println(MyString.getEmail("Elijah Mathew"));
        
        MyString s1 = new MyString("Hello World");
        MyString s2 = new MyString("I think therefore I am");

        int index = s1.indexOf('o');
        System.out.println(index);

        System.out.println(s1.reverse());
        System.out.println(s2.reverse());

        System.out.println(s1.frontBack());

    }
}
