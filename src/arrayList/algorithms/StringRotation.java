package arrayList.algorithms;

public class StringRotation {
    
    // check if one string is a rotation of another e.g 'brittlebottle' and 'ttlebrittlebo'
    
    private final String stringA;

    public StringRotation(String stringA) {
        this.stringA = stringA;
    }
    
    // scan stringA until two consecutive chars match beginning sequence of chars in compareToString;
    // index i always advances one place and the while loop terminates at the end of stringA, hence O(n)
    public void compareTo(String compareToString){
        if (this.stringA.length() != compareToString.length()){
            System.out.println("Can only compare two strings of equal length");
            return;
        }
        
        int i = 0, j = 0;
        while (i < this.stringA.length()){
            if (this.stringA.charAt(i) == compareToString.charAt(j)){
                // if we have reached the end of stringA
                if (i == this.stringA.length() - 1){
                    // scanned end of stringA, compare the remainder of compareToString
                    checkIsSubstring(compareToString, j);
                    return;
                } else {
                    // not at the end, advance i and j and repeat
                    i++;
                    j++;
                }
            } else {
                // mismatch, so restart j
                i++;
                j = 0;
            }
        }

        //traversed stringA without any match
        System.out.println("Supplied string \"" + compareToString + "\" is not a rotation of \"" + this.stringA + "\"");
    }

    private void checkIsSubstring(String compareToString, int j) {
        if (this.stringA.contains(compareToString.substring(j +1))){
            System.out.println("Supplied string \"" + compareToString + "\" is a rotation of \"" + this.stringA + "\"");
        } else {
            System.out.println("Supplied string \"" + compareToString + "\" is not a rotation of \"" + this.stringA + "\"");
        }
    }
}
