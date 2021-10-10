package CalculatorTest;

import org.junit.*;
import static org.junit.Assert.*;
import Calculator.Calculator;
import Exceptions.WrongModeException;

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
		try {
			assertEquals(result, calc.calculateBiImpl(Calculator.BiOperatorModes.add, 1.0, 4.0));
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	@Test
	public void testErrorThrowBiOperations() {
		WrongModeException thrown = assertThrows(
				WrongModeException.class,
				() -> calc.calculateBiImpl(Calculator.BiOperatorModes.normal, 1.0, 2.0));
		
		assertTrue(thrown.getMessage().contains("Wrong Bi Mode"));
	}
	
	@Test
	public void testErrorThrowMonoOperations() {
		WrongModeException thrown = assertThrows(
				WrongModeException.class,
				() -> calc.calculateMono(Calculator.MonoOperatorModes.notImplementedMode, 20.0));
		
		assertTrue(thrown.getMessage().contains("Wrong Mono Mode"));
	}

}
