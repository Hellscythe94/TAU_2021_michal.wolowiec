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
			e.printStackTrace();
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
	
	@Test 
	public void testIfReturnsDouble(){
		try {
			assertFalse(Double.isNaN(calc.calculateMono(Calculator.MonoOperatorModes.square, 9.0)));
		} catch (WrongModeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testSquareRoot() {
		Double result = 3.0;
		try {
			assertEquals(result, calc.calculateMono(Calculator.MonoOperatorModes.squareRoot, 9.0));
		} catch (WrongModeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestSub() {
		Double result = 3.0;
		try {
			assertEquals(result, calc.calculateBiImpl(Calculator.BiOperatorModes.minus, 4.0, 1.0));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void TestMultiply() {
		Double result = 8.0;
		try {
			assertEquals(result, calc.calculateBiImpl(Calculator.BiOperatorModes.multiply, 2.0, 4.0));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void TestDivide() {
		Double result = 2.0;
		try {
			assertEquals(result, calc.calculateBiImpl(Calculator.BiOperatorModes.divide, 8.0, 4.0));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void TestxPowerOfY() {
		Double result = 9.0;
		try {
			assertEquals(result, calc.calculateBiImpl(Calculator.BiOperatorModes.xpowerofy, 3.0, 2.0));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void TestAbs() {
		Double result = 5.0;
		try {
			assertEquals(result, calc.calculateMono(Calculator.MonoOperatorModes.abs, -5.0));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
