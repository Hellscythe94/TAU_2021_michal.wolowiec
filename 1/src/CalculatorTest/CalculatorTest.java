package CalculatorTest;

import org.junit.*;
import static org.junit.Assert.*;
import Calculator.Calculator;

public class CalculatorTest {
	private Calculator calc;
	
	@Before
	public void setUp(){
		calc = new Calculator();
		System.out.println("Before");
	}
	
	@After
	public void tearDown(){
		calc = null;
		System.out.println("After");
	}
	
	@Test
	public void TestAdding() {
		Double result = 5.0;
		assertEquals(result, calc.calculateBiImpl(Calculator.BiOperatorModes.add, 1.0, 4.0));
	}

}
