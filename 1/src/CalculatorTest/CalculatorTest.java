package CalculatorTest;

import org.junit.*;
import static java.lang.Double.NaN;
import static org.junit.Assert.*;
import java.lang.Math;
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
	}

}