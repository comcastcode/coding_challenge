package com.comcast.wrapper;

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
			// tokenize the string input
			String []tokens = str.split(" ");

			for (String string : tokens) {
				// throw Exception if each token length is greater than MAX_CHARACTERS
				if (string.length() > MAX_CHARACTERS) {
					throw new Exception(String.format(" word: \'%s\' has more than %s characters. ", string, MAX_CHARACTERS));
				}
			}

			String textWrapToken = "";
			for (String string : tokens) {

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

			if (textWrapToken!="") {
				System.out.println(textWrapToken.trim());
			}
			
			return true;
		} else {
			throw new Exception("input string cannot be empty");
		}
	}
}
