package tests;

import java.io.IOException;

public class Executor {
	
	public static void runMsPaint(String imagePath) throws IOException
	{
		try {
			new ProcessBuilder("mspaint",imagePath).start();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void killProcess(String processName) throws IOException
	{
		try {
			Runtime.getRuntime().exec("TASKKILL /F /IM " + processName);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
