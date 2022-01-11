package pl.pjwstk.s13119.tau;

import pl.pjwstk.s13119.tau.app.MagicCalculator;
import pl.pjwstk.s13119.tau.app.Calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.*;
public class MockitoTest {

	
	@Test
	public void testMagicAddWhen() {
		MagicCalculator mCalc = mock(MagicCalculator.class);
		when(mCalc.magicAdd(1, 2)).thenReturn(3);
		int result = mCalc.magicAdd(1, 2);
		assertEquals(3, result);
	}
	
	@Test
	public void testMagicSubGiven() {
		MagicCalculator mCalc = mock(MagicCalculator.class);
		given(mCalc.magicSub(3.0, 2.0)).willReturn(1.0);
		Double result = mCalc.magicSub(3.0, 2.0);
		assertEquals(1.0, result);
	}
	
	@Test 
	public void testMagicMultiplyWhen() {
		MagicCalculator mCalc = mock(MagicCalculator.class);
		when(mCalc.magicMultiply(3, 4)).thenReturn("12");
		String result = mCalc.magicMultiply(3, 4);
		assertEquals("12", result);
	}
	
	
	@Test
	public void testSimpleAddingGiven() {
		Calculator calc = mock(Calculator.class);
		given(calc.simpleAdd(2.0, 3.0)).willReturn(5.0);
		Double result = calc.simpleAdd(2.0, 3.0);
		assertEquals(5.0, result);
	}
	
	@Test
	public void testSimpleSubtractWhen() {
		Calculator calc = mock(Calculator.class);
		when(calc.simpleSubtract(10.0, 5.0)).thenReturn(5.0);
		Double result = calc.simpleSubtract(10.0, 5.0);
		assertEquals(5.0, result);
	}
	
	@Test
	public void testSimpleMultiplyGiven() {
		Calculator calc = mock(Calculator.class);
		given(calc.simpleMultiply(2.0, 5.0)).willReturn(10.0);
		Double result = calc.simpleMultiply(2.0, 5.0);
		assertEquals(10.0, result);
	}
}
