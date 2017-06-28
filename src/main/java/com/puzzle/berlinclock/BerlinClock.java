package com.puzzle.berlinclock;

import java.util.Arrays;

public class BerlinClock 
	implements TimeConverter {

	private static String INVALID_TIME_FMT = "Invalid Time Format. Expected format - HH:MM:SS (24 Hrs)";
	private static String INVALID_TIME_RNG = "Invalid Range Supplied. Expected : 0 < HH < 24 , 0 < MM < 60 , 0 < SS < 60";
	public static String LINE_SEP = "\n";
	
	@Override
	public String convertTime(String aTime) 
			throws IllegalArgumentException {

		return getBerlinTimeString (
				getValidTimeFormatArr (aTime));
	}
	
	// Format the Time as per Berlin Time standards
	private String getBerlinTimeString (int[] arr){
		
		StringBuffer sb = new StringBuffer();
		sb.append(getLights(1,  arr[2] % 2 == 0 ? 1 : 0 , 'Y', false)).append(LINE_SEP); // line # 1 - Seconds "Y" for even , "0" for odd
		
		sb.append(getLights(4,  arr[0] / 5 , 'R', false)).append(LINE_SEP); // line # 2 - Hours - "R" for every 5th hour
		sb.append(getLights(4,  arr[0] % 5 , 'R', false)).append(LINE_SEP); // line # 3 - Hours - "R" for every modulo of 5th hour
		sb.append(getLights(11, arr[1] / 5 , 'Y', true)).append(LINE_SEP);  // line # 4 - Hours - "Y" for every 5th min
		sb.append(getLights(4,  arr[1] % 5 , 'Y', false)); 					// line # 5 - Hours - "Y" for every modulo of 5th min

		return sb.toString();
	}
	
	private String getLights(int totLights , int switchedOnLights, char color, boolean isQuarter){
		char[] arr = new char[totLights];
		Arrays.fill(arr, 'O');
		
		for (int i = 0 ; i < switchedOnLights ; i++)
			arr[i] = color;
			
		return isQuarter ? String.valueOf(arr).replaceAll("YYY", "YYR") : String.valueOf(arr);
	}
	
	private int[] getValidTimeFormatArr (String timeStr) {

		// Check for empty or null string
		if (null == timeStr || timeStr.trim().length() != 8)
			throw new IllegalArgumentException(INVALID_TIME_FMT);
		
		// Split the string using ":"
		String [] timeArr = timeStr.trim().split(":");
		
		if (null == timeArr || timeArr.length != 3)
			throw new IllegalArgumentException(INVALID_TIME_FMT);

		// Validate & get the HH MM SS as int[]s
		int hour , minutes , seconds;
		try {
			hour = Integer.valueOf(timeArr[0]);
			minutes = Integer.valueOf(timeArr[1]);
			seconds = Integer.valueOf(timeArr[2]);			
		} catch (NumberFormatException nEx){
			throw new IllegalArgumentException(INVALID_TIME_FMT);
		}
		
		// Check range for HH MM SS
		if (( hour > 24 || hour < 0 ) ||
			( minutes > 59 || minutes < 0 ) ||
			( seconds > 59 || seconds < 0 ))
			throw new IllegalArgumentException(INVALID_TIME_RNG);
		
		// Return array of int with valid HH MM SS
		return new int[]{hour, minutes, seconds};
	}
}