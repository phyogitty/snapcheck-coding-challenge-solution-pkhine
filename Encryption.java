import java.util.*;
/*
	author: Phyo Khine
	date: August 1, 2020
*/

public class Encryption {
	// testing
	public static void main(String[] args) {
        String testStr1 = "have a nice day";
        System.out.println("\nInput1: " + testStr1);
        System.out.println("Output1: " + encrypt(testStr1) + "\n");

        String testStr2 = "if man was meant to stay on the ground god would have given us roots";
        System.out.println("Input2: " + testStr2);
        System.out.println("Output2: " + encrypt(testStr2) + "\n");
	}

	// function starts here
	public static String encrypt(String str) {
		String strRefined = str.replaceAll("[^A-Za-z]+", "");	// remove white spaces

		double l = Math.sqrt(strRefined.length());
        int row = (int) Math.floor(l);	// get the floor; use as number of rows
		int col = (int) Math.ceil(l);   // get the ceiling; use as number of columns

		while (row * col < strRefined.length()) {	// get appropriate dimension
			if (row == Math.min(row, col)) {
				row++;
			} else {
				col++;
			}
		}

		char[] charArr = strRefined.toCharArray();
		String resultStr = "";

		for (int j = 0; j < col; j++) {		// want column number of groups
			for (int k = j; k < charArr.length; k=k+col) {
				resultStr += charArr[k];
			}
			resultStr += " ";
		}
        return resultStr;

	}
}