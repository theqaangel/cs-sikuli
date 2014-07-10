package tests;

import org.junit.After;
import org.junit.Before;

import com.sikuliintegrator.Pointer;

public class BaseTest {
	
	protected Pointer pointer;

	@Before
	public void setUp() throws Exception {
		Pointer.setInTestMode();
		Executor.runMsPaint("img\\demo.png");
	}

	@After
	public void tearDown() throws Exception {
		Executor.killProcess("mspaint.exe");
	}

}
