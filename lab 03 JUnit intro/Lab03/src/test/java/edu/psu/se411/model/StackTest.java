package edu.psu.se411.model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

public class StackTest {
	@Test
	public void testPushAndPop() {
		
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);

		assertEquals(3, stack.pop());
		assertEquals(2, stack.pop());
		assertEquals(1, stack.pop());
	}
	
	@Test
	public void testPopEmptyStack() {
		Stack<Integer> stack = new Stack<>();
		assertThrows(NoSuchElementException.class, () -> stack.pop());
	}
	
	@Test
	public void testPopEmptyStackAfterElements() {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.pop();
		assertThrows(NoSuchElementException.class, () -> stack.pop());
	}
	
	@Test
	public void testSingleElement() {
		Stack<String> stack = new Stack<>();
		stack.push("Hello");
		assertEquals("Hello", stack.pop());
	}
	
	@Test
	public void testMultipleElements() {
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i <= 5; i++) {
			stack.push(i);
		}
		for (int i = 5; i >= 1; i--) {
			assertEquals(i, stack.pop());
		}
	}
	
	@Test
	public void testLIFOOrder() {
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		assertEquals(30, stack.pop());
		stack.push(40);
		assertEquals(40, stack.pop());
		assertEquals(20, stack.pop());
	}
	
	@Test
	public void testWithDifferentTypes() {
		Stack<Double> doubleStack = new Stack<>();
		doubleStack.push(1.5);
		doubleStack.push(2.7);
		assertEquals(2.7, doubleStack.pop());
		assertEquals(1.5, doubleStack.pop());
		
		Stack<String> stringStack = new Stack<>();
		stringStack.push("First");
		stringStack.push("Second");
		assertEquals("Second", stringStack.pop());
		assertEquals("First", stringStack.pop());
	}
	
	@Test
	public void testLargeNumberOfElements() {
		Stack<Integer> stack = new Stack<>();
		int size = 1000;
		for (int i = 0; i < size; i++) {
			stack.push(i);
		}
		for (int i = size - 1; i >= 0; i--) {
			assertEquals(i, stack.pop());
		}
	}
	
	@Test
	public void testConstructorWithCapacity() {
		Stack<Integer> stack = new Stack<>(20);
		for (int i = 0; i < 15; i++) {
			stack.push(i);
		}
		for (int i = 14; i >= 0; i--) {
			assertEquals(i, stack.pop());
		}
	}
	
	@Test
	public void testConstructorWithInvalidCapacity() {
		Stack<Integer> stack = new Stack<>(-5);
		stack.push(1);
		assertEquals(1, stack.pop());
	}
	
	@Test
	public void testNullElements() {
		Stack<Object> stack = new Stack<>();
		stack.push(null);
		stack.push("NotNull");
		assertEquals("NotNull", stack.pop());
		assertNull(stack.pop());
	}
}
