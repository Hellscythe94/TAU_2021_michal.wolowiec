package pl.pjwstk.s13119.tau;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;

import pl.pjwstk.s13119.tau.exceptions.*;
import pl.pjwstk.s13119.tau.app.*;

public class CalculatorTest {
	private static Calculator calc;
	
	@BeforeAll
	public static void setUp(){
		calc = new Calculator();
		System.out.println("Before");
	}
	
	@AfterAll
	public static void tearDown(){
		calc = null;
		System.out.println("After");
	}
	
	
	@Test
	public void testSimpleAdding() {
		Double result = 5.0;
		assertEquals(result, calc.simpleAdd(2.0, 3.0));
	}
	
	@Test
	public void testSimpleSubtract() {
		Double result = 5.0;
		assertEquals(result, calc.simpleSubtract(10.0, 5.0));
	}
	
	@Test
	public void testSimpleMultiply() {
		Double result = 10.0;
		assertEquals(result, calc.simpleMultiply(2.0, 5.0));
	}
	
	@Test
	public void testSimpleDivide() {
		Double result = 5.0;
		assertEquals(result, calc.simpleDivide(25.0, 5.0));
	}
	
	@Test 
	public void testSimpleModulo() {
		Double result = 2.0;
		assertEquals(result, calc.simpleModulo(7.0, 5.0));
	}
	
	@Test
	public void testSimpleModulo2() {
		Double result = 10.0%3.0;
		assertEquals(result, calc.simpleModulo(10.0, 3.0));
	}
	
	@Test
	public void testSimpleAdd2() {
		Double result = 6.0+18.0;
		assertEquals(result, calc.simpleAdd(18.0, 6.0));
	}
	
	
	
	@Test
	public void testAdding() {
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
