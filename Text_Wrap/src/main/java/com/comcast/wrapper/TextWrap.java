package com.comcast.wrapper;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/* Write a program that takes an input string and prints 
 it as multiple lines of text such that no line of text 
 is greater than 13 characters and words are kept whole.

 eg:

For example, the first line of the Gettysburg address:
Four score and seven years ago our fathers brought forth upon this continent a new nation, conceived in liberty and dedicated to the proposition that all men are created equal

Becomes:

Four score

and seven

years ago our

fathers

 */

public class TextWrap {

	private final static int MAX_CHARACTERS = 13;

	public boolean textWrap(String str) throws Exception {

		if (str == null)
			throw new NullPointerException("input string cannot be null");

		if (str.length() > 0) {
			// tokenize the string input and write it to list
			StringTokenizer defaultTokenizer = new StringTokenizer(str);
			List<String> listOfTokens = new LinkedList<String>();

			while (defaultTokenizer.hasMoreTokens()) {

				String token = defaultTokenizer.nextToken();

				// Exit the application if each token length is greater than MAX_CHARACTERS
				if (token.length() > MAX_CHARACTERS) {
					throw new Exception(String.format(" word: \'%s\' has more than %s characters. ", token, MAX_CHARACTERS));
				}

				listOfTokens.add(token);
			}

			String textWrapToken = "";
			for (String string : listOfTokens) {

				// give a space after the string
				string = string + " ";
				if ((textWrapToken.length() + string.length()) <= MAX_CHARACTERS)
					textWrapToken += string;
				else {
					System.out.println(textWrapToken.trim());
					textWrapToken = "";
					textWrapToken = string;
				}
			}
			System.out.println(textWrapToken.trim());
			return true;
		} else {
			throw new Exception("input string cannot be empty");
		}
	}
}
