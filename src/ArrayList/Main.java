package ArrayList;

import ArrayList.algorithms.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to ArraysAndStrings");
		System.out.println("--------------------------------------------------");

//		allUniqueChars();

//		isAPermutation();

//		URLify();

//		permutationOfAPalindrome();

//		isOneAway();

//		stringCompression();

//		rotateMatrix();

//		zeroAMatrix();

		isARotatedString();
	}

	private static void isARotatedString() {
		System.out.println("Checking if given string is a rotation of object string");
		StringRotation stringRotation = new StringRotation("brittlebottle");
		stringRotation.compareTo("ttlebrittlebo");

		stringRotation.compareTo("ttlebrittleba");
		stringRotation.compareTo("ttlabrittlebo");
		System.out.println("==============================================");
	}

	private static void zeroAMatrix() {
		System.out.println("Setting all elements of a row or column with a zero element, to zero");
		int[][] newMatrix = {
				{1, 2, 3, 1, 2, 3},
				{4, 0, 6, 0, 5, 6},
				{7, 8, 9, 7, 8, 9}
		};
		ZeroAMatrix matrix = new ZeroAMatrix(newMatrix);
		matrix.printMatrix();
		matrix.setToZero();
		matrix.printMatrix();
		System.out.println("==============================================");
	}

	private static void rotateMatrix() {
		System.out.println("Rotating a matrix 90 degrees to the right");
		int[][] newMatrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		RotateMatrix matrix = new RotateMatrix(newMatrix);
		matrix.printMatrix();
		matrix.rotateNinetyDegrees();
		matrix.printMatrix();
		System.out.println("==============================================");
	}

	private static void stringCompression(){
		System.out.println("Compressing a string");
		StringCompression stringCompression = new StringCompression("dooodleZOOOoM");
		stringCompression.compress();

		StringCompression stringCompression2 = new StringCompression("dooodleZOOOoMMMM");
		stringCompression2.compress();
		System.out.println("==============================================");
	}

	private static void isOneAway(){
		System.out.println("Checking if a string is one op away from becoming another");
		OneAway oneAway = new OneAway("xyzpa");
		oneAway.isOneAway("xypa");

		oneAway.isOneAway("xyzpap");

		oneAway.isOneAway("xyzpapp");
		System.out.println("==============================================");
	}

	private static void permutationOfAPalindrome(){
		System.out.println("Checking if a string is a permutation of a palindrome");
		PermutationOfAPalindrome permutation1 = new PermutationOfAPalindrome("wwjjtti");
		permutation1.stringIsAPermutationOfAPalindrome();

		PermutationOfAPalindrome permutation2 = new PermutationOfAPalindrome("wwjjtt");
		permutation2.stringIsAPermutationOfAPalindrome();

		PermutationOfAPalindrome permutation3 = new PermutationOfAPalindrome("eorituiire");
		permutation3.stringIsAPermutationOfAPalindrome();
		System.out.println("==============================================");
	}

	private static void URLify(){
		System.out.println("URLify a string");
		URLify urLify = new URLify("Here  is some space   ");
		urLify.URLifyString();
		System.out.println("==============================================");
	}

	private static void isAPermutation() {
		System.out.println("Is the string a permutation?");
		StringIsAPermutation stringIsAPermutation1 = new StringIsAPermutation("abcdefg");
		stringIsAPermutation1.isAPermutation("gfedcba");

		StringIsAPermutation stringIsAPermutation2 = new StringIsAPermutation("asdfghjkl");
		stringIsAPermutation2.isAPermutation("asdfgthjl");
		System.out.println("==============================================");
	}

	private static void allUniqueChars() {
		System.out.println("Checking if a string contains unique characters");
		AllUniqueChars allUniqueChars2 = new AllUniqueChars("dood");
		allUniqueChars2.areAllUniqueChars();
		allUniqueChars2.areAllUniqueChars_selfCheck();

		AllUniqueChars allUniqueChars3 = new AllUniqueChars("abcdefg");
		allUniqueChars3.areAllUniqueChars();
		allUniqueChars3.areAllUniqueChars_selfCheck();
		System.out.println("==============================================");
	}

	private void dynamicArray(){
		DynArray<Integer> newArrayOfIntegers = new DynArray<>(8);
		System.out.println("New array has size: " + newArrayOfIntegers.getSize());
	}

}
