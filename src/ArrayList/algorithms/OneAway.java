package ArrayList.algorithms;

public class OneAway {

    // this checks if one string is one operation (add, replace, delete) away from equalling another string.
    // This means that the string is a substring (of another given string) such that there is only one difference

    private final String input;

    public OneAway(String input) {
        this.input = input;
    }

    // time complexity is O(n) (either by sameLengthCompare() or differentLengthCompare())
    public void isOneAway(String compareTo){
        if (compareTo.length() - this.input.length() > 1 || this.input.length() - compareTo.length() > 1){
            System.out.println("The supplied string " + compareTo + " is not one away from " + this.input);
            return;
        }

        int i = 0, j = 0;
        int shortestLength;
        if (compareTo.length() < this.input.length()){
            shortestLength = compareTo.length();
        } else
            shortestLength = this.input.length();

        //for strings with the same length, we can only replace one char
        if (this.input.length() == compareTo.length() && !sameLengthCompare(compareTo, shortestLength)){
            System.out.println("The supplied string " + compareTo + " is not one away from " + this.input);
            return;
        }

        //for strings which differ by one char (replacement op not applicable anymore)
        if (!differentLengthCompare(compareTo, shortestLength)){
            System.out.println("The supplied string " + compareTo + " is not one away from " + this.input);
            return;
        }

        System.out.println("The supplied string " + compareTo + " is one away from " + this.input);
    }

    // time complexity O(n)
    private boolean sameLengthCompare(String compareTo, int length){
        int i = 0, j = 0;
        int differences = 0;
        while (i < length){
            if (this.input.charAt(i) != compareTo.charAt(j)){
                differences++;
            }

            if (differences > 1){
                return false;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }

    // time complexity O(n + n+1) or O(n)
    private boolean differentLengthCompare(String compareTo, int shortest){
        // char replacement not applicable here
        int i = 0, j = 0;
        int differences = 0;
        // process the start of both strings (account for insertion)
        while (i < shortest && j < shortest && this.input.charAt(i) == compareTo.charAt(j)){
            i++;
            j++;
        }

        // if we have reached the end of either string then all good (both only differ by one char)
        if (i == shortest || j == shortest){
            return true;
        }

        // if different chars are found but we are not at the end of both strings...
        if (this.input.charAt(i+1) == compareTo.charAt(j)){
            i++;
            while (this.input.charAt(i) == compareTo.charAt(j) && i < shortest){
                i++;
                j++;
            }
        } else if (this.input.charAt(i) == compareTo.charAt(j+1)){
            j++;
            while (this.input.charAt(i) == compareTo.charAt(j) && j < shortest){
                i++;
                j++;
            }
        } else
            return false;

        return i == shortest - 1 || j == shortest - 1;
    }
}
