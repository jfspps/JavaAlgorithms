package com.algorithms.ArrayList.algorithms;

public class URLify {
    private final char[] input;

    public URLify(String input) {
        this.input = new char[input.length() * 3];
        for (int i = 0; i < input.length(); i++){
            this.input[i] = input.charAt(i);
        }
        System.out.println("Before processing: " + input);
    }

    // without copying to a temporary array, time complexity is O(n * n^2) or just O(n^3)
    public void URLifyString(){
        for (int i = 0; i < this.input.length; i++){
            if (this.input[i] == ' '){
                // shuffle elements along three places to the right
                int j = i;

                // send j to the end and back again, shifting each character
                // combined iterations is at worst 2[O(i-1) + O(i-2) + ... 1] which is 2[O(i(i-1)/2)]
                while (this.input[j] != '\0')
                    j++;

                while (j > i){
                    this.input[j+2] = this.input[j];
                    j--;
                }
                this.input[i++] = '%';
                this.input[i++] = '2';
                this.input[i] = '0';
            }
        }
        System.out.println("After processing: " + new String(this.input));
    }
}
