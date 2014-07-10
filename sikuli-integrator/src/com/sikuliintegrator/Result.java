package com.sikuliintegrator;

public class Result {
	private static int status;
	private static String output;

	public static int getStatus() {
		return status;
	}
	
	public static String getOutput() {
		return output;
	}
	
	public static void success()
	{
		output = Constants.SUCCESS_INDICATOR;
		System.out.println(Constants.SUCCESS_INDICATOR);
		status = 0;
	}
	
	public static void failure()
	{
		failure(null);
	}
	
	public static void failure(String failureText)
	{
		if(failureText != null && !failureText.isEmpty())
		{
			output = Constants.IDENTIFICATOR + failureText;
			System.out.println(Constants.IDENTIFICATOR + failureText);
		}
		output = Constants.FAILURE_INDICATOR;
		System.out.println(Constants.FAILURE_INDICATOR);
		status = 1;
	}
	
}
