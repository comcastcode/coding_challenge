package com.comcast.wrapper;

import org.junit.Test;
import static org.junit.Assert.*;

public class TextWrapTest {
	TextWrap textWrap;

	// positive test case
	@Test
	public void testTextWrap() {

		String str = "Four score and seven years ago our fathers brought forth upon this continent a new nation, conceived in liberty and dedicated to the proposition that all men are created equal";
		textWrap = new TextWrap();
		boolean result;
		try {
			result = textWrap.textWrap(str);
			assertTrue(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//positive test case2
	@Test
	public void testPositiveUsecase2() {

		String str = "success";
		textWrap = new TextWrap();
		boolean result;
		try {
			result = textWrap.textWrap(str);
			assertTrue(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	// negative test case, Expected exception
	@Test(expected = Exception.class)
	public void testNegativeCase() throws Exception {
		String str = "Infrastructure and Communications fails this test case";
		textWrap = new TextWrap();
		textWrap.textWrap(str);
	}

	// negative test case2, Expected NullPointerException
	@Test(expected = NullPointerException.class)
	public void testNegativeCase2() throws Exception {
		String str = null;
		textWrap = new TextWrap();
		textWrap.textWrap(str);
	}

	// negative test case3, Expected Exception
	@Test(expected = Exception.class)
	public void testNegativeCase3() throws Exception {
		String str = "";
		textWrap = new TextWrap();
		textWrap.textWrap(str);
	}

}
