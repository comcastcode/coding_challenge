package com.comcast.wrapper;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class TextWrap {

	private final static int MAX_CHARACTERS = 13;

	/**
	 * wraps the given input text into multiple lines of text 
	 * such that no line of text is greater than 13 characters 
	 * and words are kept whole.
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public boolean textWrap(String str) throws Exception {

		if (null == str)
			throw new NullPointerException("input string cannot be null");

		if (str.length() > 0) {
			// tokenize the string input and write it to list
			StringTokenizer defaultTokenizer = new StringTokenizer(str);
			
			//use LinkedList to store all the tokens in correct order
			List<String> listOfTokens = new LinkedList<String>();

			while (defaultTokenizer.hasMoreTokens()) {

				String token = defaultTokenizer.nextToken();

				// throw Exception if each token length is greater than MAX_CHARACTERS
				if (token.length() > MAX_CHARACTERS) {
					throw new Exception(String.format(" word: \'%s\' has more than %s characters. ", token, MAX_CHARACTERS));
				}

				listOfTokens.add(token);
			}

			String textWrapToken = "";
			for (String string : listOfTokens) {

				//As we have tokenized the input string based on spaces, now add a space at the end of each token
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
