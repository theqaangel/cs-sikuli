package com.sikuliintegrator;

import org.sikuli.basics.Settings;

import com.sikuliintegrator.arguments.ArgumentsMapping;
import com.sikuliintegrator.exceptions.ExceptionHandler;
import com.sikuliintegrator.exceptions.UnknownCommandException;
import com.sikuliintegrator.exceptions.WrongArgumentCountException;

public class Pointer {
	
	private static boolean isInTestMode = false;
	
	public static void setInTestMode()
	{
		isInTestMode = true;
	}
	
	public static void main(String[] args) {

		/*
		args = new String[4];
		args[0] = "C:\\Users\\Angel\\Dropbox\\Projects\\SikuliModule\\SikuliModule\\TestResults\\Angel_ANGEL 2013-07-27 09_16_27\\Out\\pattern.png";
		args[1] = "EXISTS";
		args[2] = "0.9";
		args[3] = "5000";
		*/				
		
		/*
		args = new String[5];
		args[0] = "E:\\Temp\\pepita.png";
		args[1] = "CLICK";
		args[2] = "0.9";
		args[3] = "5000";
		args[4] = "";
		*/
		
		/*
		args = new String[5];
		args[0] = "E:\\Temp\\pepita.png";
		args[1] = "HOVER";
		args[2] = "0.9";
		args[3] = "5000";
		args[4] = "";
		*/
		
		/*
		args = new String[5];
		args[0] = "E:\\Temp\\pepita.png";
		args[1] = "WAIT_VANISH";
		args[2] = "0.9";
		args[3] = "5000";
		args[4] = "";
		*/
				
		/*
		args = new String[5];
		args[0] = "E:\\Temp\\pepita.png";
		args[1] = "WAIT";
		args[2] = "0.9";
		args[3] = "500005";
		args[4] = "";
		*/
		
		
		/*
		args[0] = "E:\\Temp\\pepita.png";
		args[1] = "DRAG_DROP";
		args[2] = "0.9";
		args[3] = "500005";
		args[4] = "E:\\Temp\\carpeta.png";			
		*/
		
		/*
		args = new String[4];
		args[0] = "E:\\Temp\\dot.png";
		args[1] = "FIND_ALL";
		args[2] = "0.9";
		args[3] = "5000";
		//args[4] = "1;1;274;399";
		*/
		
		/*
		System.out.println("<Arguments are>");
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		System.out.println(args[3]);
		//System.out.println(args[4]);
		System.out.println("</Arguments are>");
		*/
		
		try {

			if (args.length == (Constants.ARGUMENTS_COUNT - 1)
					|| args.length == Constants.ARGUMENTS_COUNT) {
				
				ArgumentsMapping arguments = new ArgumentsMapping(args);
				

				disableCommandLineLogs();

				Settings.MinSimilarity = arguments
						.getSimilarity();

				if (arguments.getCommand() == null) {
					throw new UnknownCommandException();
				} else {

					switch (arguments.getCommand()) 
					{
						case EXISTS: {
							Operation.GetPoint(arguments);
							break;
						}						
						case CLICK: {
							Operation.Click(arguments);
							break;
						}						
						case DOUBLE_CLICK: {
							Operation.DoubleClick(arguments);
							break;
						}						
//						case RIGHT_CLICK: {
//							Operation.RightClick(arguments);
//							break;
//						}											
//						case HOVER: {
//							Operation.Hover(arguments);
//							break;
//						}											
//						case FIND_ALL: {
//							Operation.FindAll(arguments);
//							break;
//						}										
//						case WAIT_VANISH: {
//							Operation.WaitVanish(arguments);
//							break;
//						}										
//						case WAIT: {
//							Operation.Wait(arguments);
//							break;
//						}												
//						case DRAG_DROP: {
//							Operation.DragDrop(arguments);
//							break;
//						}
//						case TYPE: {
//							Operation.Type(arguments);
//							break;
//						}
//						case PASTE: {
//							Operation.Paste(arguments);
//							break;
//						}
						default: {
							throw new UnknownCommandException();
						}
					}

				}
			} else {
				throw new WrongArgumentCountException();
			}

		} catch (Exception ex) {
			ExceptionHandler.handle(ex);
		}
		
		if(!isInTestMode)
		{
			System.exit(Result.getStatus());
		}
	}

	private static void disableCommandLineLogs() {
		Settings.InfoLogs = false;
		Settings.DebugLogs = false;
		Settings.ProfileLogs = false;
		Settings.ActionLogs = false;
	}
}
