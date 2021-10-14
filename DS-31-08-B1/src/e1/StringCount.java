package e1;

public class StringCount {
    public static int countWords ( String text ) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        if(text.startsWith(" ")){
            String[] frase = text.split("\\s+");
            return frase.length-1;
        }
        String[] frase = text.split("\\s+");
        return frase.length;
    }

    public static int countChar ( String text , char c) {
        int counter = 0;
        if (text == null || text.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == c) {
                counter++;
            }
        }
        return counter;
    }

    public static int countCharIgnoringCase ( String text , char c ) {
        int counter = 0;
        if (text == null || text.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < text.length(); i++) {

            if (text.toLowerCase().charAt(i) == c) {
                counter++;
            }
            if (text.toUpperCase().charAt(i) == c) {
                counter++;
            }
        }
        return counter;
    }

    public static boolean isPasswordSafe ( String password ) {

        char charr;
        boolean mayus = false;
        boolean minus = false;
        boolean digit = false;
        boolean special = false;

        if(password.length()<8) {
            return false;
        }
        for(int i=0;i<password.length();i++) {
            charr = password.charAt(i);
            if(Character.isDigit(charr)){
                digit = true;
            }
            else if (Character.isUpperCase(charr)){
                mayus = true;
            }
            else if(Character.isLowerCase(charr)){
                minus = true;
            }
            else if(password.contains("?") || password.contains("@") || password.contains("#") ||
                    password.contains("$") || password.contains(".") || password.contains(",")){
                special = true;
            }
            if(digit && mayus && minus && special){
                return true;
            }
        }
        return false;
    }
}