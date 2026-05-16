public class StringManipulation {

    public static void main(String[] args) {

        String str = "Java is awesome";

        System.out.println("Original String     : " + str);
        System.out.println("=".repeat(45));
        System.out.println("1. Length           : " + str.length());
        System.out.println("2. Uppercase        : " + str.toUpperCase());
        System.out.println("3. Lowercase        : " + str.toLowerCase());
        System.out.println("4a. Substring(5)    : " + str.substring(5));
        System.out.println("4b. Substring(0,4)  : " + str.substring(0, 4));
        System.out.println("5. Replace          : " + str.replace("awesome", "powerful"));
        System.out.println("6. Concatenate      : " + str.concat(" and fun!"));
        System.out.println("7a. indexOf('a')    : " + str.indexOf('a'));
        System.out.println("7b. indexOf(\"is\")   : " + str.indexOf("is"));
        System.out.println("8. lastIndexOf('a') : " + str.lastIndexOf('a'));
        System.out.println("\n--- Additional String Methods ---");
        System.out.println("charAt(0)           : " + str.charAt(0));
        System.out.println("contains(\"awesome\") : " + str.contains("awesome"));
        System.out.println("startsWith(\"Java\")  : " + str.startsWith("Java"));
        System.out.println("endsWith(\"awesome\") : " + str.endsWith("awesome"));
        System.out.println("isEmpty()           : " + str.isEmpty());
        System.out.println("equals check        : " + str.equals("Java is awesome"));
        System.out.println("equalsIgnoreCase    : " + str.equalsIgnoreCase("JAVA IS AWESOME"));
        System.out.println("trim example        : '" + "  hello  ".trim() + "'");

        String[] words = str.split(" ");
        System.out.println("Word count (split)  : " + words.length);
    }
}
