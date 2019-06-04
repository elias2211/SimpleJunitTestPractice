package io.javabrains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/* you can use the below annotation if you would like to create an instance per class
 * the risk still is though, junit does not guarantee you which method is going to run
 * first, so there's always a risk of the test not running. So, this is a bad practice
 */

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("When running MathUtils")
class MathUtilsTest {

	MathUtils mathUtils;
	/* If you would like to use the before all @BeforeAll annotation, the method needs to be 
	 Otherwise it wouldn't work. */
	
	@BeforeEach
	void init() {
		mathUtils = new MathUtils();
	}
	
	
	  @Nested
	  @DisplayName("add method") 
	  class AddTest{
	  
	  @Test
	  @DisplayName("When adding two positive numbers") //Display this message instead of method name 
	  void testAdd() { int expected = 2; int actual =
	  mathUtils.add(1, 1);
	  
	  assertEquals(expected, actual, "should add two numbers"); }
	  
	  @Test
	  @DisplayName("Testing add method for positive number") //Display this message instead of method name 
	  void test() { int expected = 2; int actual =
	  mathUtils.add(1, 1);
	  
	  assertEquals(expected, actual, "The add methood should add two numbers"); }
	  
	  }
	 
	
	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "testing"
				+ "divide method");
	}
	
	@Test
	@Disabled // Skips the method from being tested
	@DisplayName("Testing disabled method") //Display this message instead of method name
	void testDisabled() {
		fail("This test should fail");
	}
	
	@Test
	@DisplayName("testing multiplication using assertall and lamda")
	void testMultiply() {
		assertAll(
				()-> assertEquals(4, mathUtils.multiply(2, 2)),
				()-> assertEquals(0, mathUtils.multiply(2, 0))
				);
	}
	


}
