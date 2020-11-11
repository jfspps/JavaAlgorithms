package arrayList.algorithms;

public class AllUniqueChars {
    private final String input;
    private final int[] tallyArray;

    public AllUniqueChars(String input) {
        this.input = input;
        //assume ASCII here
        this.tallyArray = new int[128];     //all elements are padded with zeros
    }

    //algorithms given below, one with and one without other ADTs

    // with ADT is O(n)
    public void areAllUniqueChars(){
        for (int i = 0; i < this.input.length(); i++){
            tallyArray[this.input.charAt(i)]++;

            if (tallyArray[this.input.charAt(i)] > 1){
                System.out.println("With ADT. Duplicated character found: " + this.input.charAt(i));
                return;
            }
        }
        System.out.println("With ADT. All characters are unique");
    }

    // without ADT is O(n^2)
    public void areAllUniqueChars_selfCheck(){
        for (int i = 0; i < this.input.length(); i++){
            for (int j = i+1; j < this.input.length(); j++){
                if (this.input.charAt(i) == this.input.charAt(j)){
                    System.out.println("Without ADT. Duplicated character found: " + this.input.charAt(i));
                    return;
                }
            }
        }
        System.out.println("Without ADT. All characters are unique");
    }
}
