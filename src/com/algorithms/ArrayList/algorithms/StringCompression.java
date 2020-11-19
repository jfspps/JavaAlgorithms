package com.algorithms.ArrayList.algorithms;

public class StringCompression {

    // this converts a string from dooodleZOOOoM to do3dleZO3oM

    private final String input;

    public StringCompression(String input){
        this.input = input;
    }

    // time complexity is O(i + j) (higher indices i would reduce j, and vice versa for consecutive elements) or just O(n)
    public void compress(){
        System.out.println("Before compression: " + this.input);

        //i tail pointer, j lead pointer, k traverses temp[]
        int i = 0, j, k = 0;
        char[] temp = new char[this.input.length()];
        while (i < this.input.length()){
            temp[k++] = this.input.charAt(i);
            int tally = 1;      // there is one of temp[i]

            for (j = i+1; j < this.input.length(); j++){
                if (this.input.charAt(i) == this.input.charAt(j)){
                    tally++;
                } else {
                    break;
                }
            }
            i = j;

            // add digit
            if (tally > 1) {
                temp[k++] = Character.forDigit(tally, 10);
            }
        }
        System.out.println("After compression: " + new String(temp));
    }
}
