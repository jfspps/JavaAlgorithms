package ArrayList.algorithms;

public class PermutationOfAPalindrome {

    // a palindrome contains characters which have an even number of appearances or none at all;
    // only one character can have an odd number of appearances

    private final String input;
    private final int[] tally;

    public PermutationOfAPalindrome(String input) {
        this.input = input;
        this.tally = new int[128];     //need only concern with alphabetical characters
    }

    // time complexity is O(n + 128) or just O(n)
    public void stringIsAPermutationOfAPalindrome(){
        //tally up the characters
        for (int i = 0; i < this.input.length(); i++){
            this.tally[this.input.charAt(i)]++;
        }

        int numberOfOdd = 0;
        //scan tally
        for (int i : this.tally) {
            if (i % 2 != 0) {
                numberOfOdd++;
            }

            if (numberOfOdd > 1) {
                System.out.println(this.input + " is not a permutation of a palindrome");
                return;
            }
        }
        System.out.println(this.input + " is a permutation of a palindrome");
    }
}
