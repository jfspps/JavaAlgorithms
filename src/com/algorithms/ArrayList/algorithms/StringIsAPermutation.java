package com.algorithms.ArrayList.algorithms;

public class StringIsAPermutation {
    private final String input;
    private final int[] tallyArray;

    public StringIsAPermutation(String input) {
        this.input = input;
        tallyArray = new int[128];  //all elements are padded with zeros
    }

    // time complexity is O(n + 128) or O(n)
    public void isAPermutation(String compareToString){
        //build the tally arrays (char's likely to appear in different orders) and then compare
        if (this.input.length() != compareToString.length()){
            System.out.println("Can only compare strings of equal length");
            return;
        }
        int[] compareToStringTally = new int[128];
        for (int i = 0; i < this.input.length(); i++){
            this.tallyArray[this.input.charAt(i)]++;
            compareToStringTally[compareToString.charAt(i)]++;
        }

        if (talliesAreEqual(compareToStringTally)){
            System.out.println("Entered string is an anagram (permutation) of " + this.input);
        } else {
            System.out.println("Entered string is not an anagram (permutation) of " + this.input);
        }
    }

    private Boolean talliesAreEqual(int[] compareToString){
        for (int i = 0; i < this.tallyArray.length; i++){
            if (this.tallyArray[i] != compareToString[i]){
                return false;
            }
        }
        return true;
    }
}
