package tests;

import org.junit.Test;

import static org.junit.Assert.*;

import com.sikuliintegrator.Constants;
import com.sikuliintegrator.Pointer;
import com.sikuliintegrator.Result;

public class EndToEndTests extends BaseTest {
	
	@Test
	public void testWrongCommandName() throws InterruptedException {
		Pointer.main(new String[] {"img\\pattern1.png", "TEST", "0.95", "5"});
		assertEquals(Result.getStatus(), 1);
		assertEquals(Result.getOutput(), Constants.FAILURE_INDICATOR);
	}

	@Test
	public void testLessArgumentsCount() throws InterruptedException {
		Pointer.main(new String[] {"CLICK", "0.95", "5"});
		assertEquals(Result.getStatus(), 1);
		assertEquals(Result.getOutput(), Constants.FAILURE_INDICATOR);
	}
	
	@Test
	public void testMoreArgumentsCount() throws InterruptedException {
		Pointer.main(new String[] {"CLICK", "0.95", "5", "sd", "sadas"});
		assertEquals(Result.getStatus(), 1);
		assertEquals(Result.getOutput(), Constants.FAILURE_INDICATOR);
	}
	
	@Test
	public void testWrongPatternPath() throws InterruptedException {
		Pointer.main(new String[] {"img\\pattern12.png", "CLICK", "0.95", "5"});
		assertEquals(Result.getStatus(), 1);
		assertEquals(Result.getOutput(), "###FAILURE");
	}
	
	@Test
	public void testClick() throws InterruptedException {
		Pointer.main(new String[] {"img\\pattern1.png", "CLICK", "0.95", "5"});
		assertEquals(Result.getStatus(), 0);
		assertEquals(Result.getOutput(), Constants.SUCCESS_INDICATOR);
	}
	
	@Test
	public void testDoubleClick() throws InterruptedException {
		Pointer.main(new String[] {"img\\pattern1.png", "DOUBLE_CLICK", "0.95", "5"});
		assertEquals(Result.getStatus(), 0);
		assertEquals(Result.getOutput(), Constants.SUCCESS_INDICATOR);
	}
	
	@Test
	public void testRightClick() throws InterruptedException {
		Pointer.main(new String[] {"img\\pattern1.png", "RIGHT_CLICK", "0.90", "5"});
		assertEquals(Result.getStatus(), 0);
		assertEquals(Result.getOutput(), Constants.SUCCESS_INDICATOR);
	}
	
	@Test
	public void testHover() throws InterruptedException {
		Pointer.main(new String[] {"img\\pattern1.png", "HOVER", "0.90", "5"});
		assertEquals(Result.getStatus(), 0);
		assertEquals(Result.getOutput(), Constants.SUCCESS_INDICATOR);
	}
	
	@Test
	public void testExists() throws InterruptedException {
		Pointer.main(new String[] {"img\\pattern1.png", "EXISTS", "0.95", "5"});
		assertEquals(Result.getStatus(), 0);
		assertEquals(Result.getOutput(), Constants.SUCCESS_INDICATOR);
	}
	
	@Test
	public void testNotExists() throws InterruptedException {
		Pointer.main(new String[] {"img\\patternNo.png", "EXISTS", "0.95", "3"});
		assertEquals(Result.getStatus(), 1);
		assertEquals(Result.getOutput(), Constants.FAILURE_INDICATOR);
	}
	
	@Test
	public void testDragAndDrop() throws InterruptedException {
		Pointer.main(new String[] {"img\\pattern1.png", "EXISTS", "0.95", "3", "img\\pattern1.png"});
		assertEquals(Result.getStatus(), 1);
		assertEquals(Result.getOutput(), Constants.FAILURE_INDICATOR);
	}


}
