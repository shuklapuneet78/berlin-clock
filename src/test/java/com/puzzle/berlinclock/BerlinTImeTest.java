package com.puzzle.berlinclock;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BerlinTImeTest {

	BerlinClock berlinClock;
	
	@Before
	public void setUp() throws Exception {
		berlinClock = new BerlinClock();
	}

	@Test
	public void testMidnightTime_00_00_00 () {
		String expected = new StringBuffer()
			.append("Y").append(BerlinClock.LINE_SEP)
			.append("OOOO").append(BerlinClock.LINE_SEP)
			.append("OOOO").append(BerlinClock.LINE_SEP)
			.append("OOOOOOOOOOO").append(BerlinClock.LINE_SEP)
			.append("OOOO")
			.toString();
		
		assertEquals(expected , berlinClock.convertTime("00:00:00"));
	}

	@Test
	public void testJustBeforeMidnightTime_23_59_59 () {
		String expected = new StringBuffer()
			.append("O").append(BerlinClock.LINE_SEP)
			.append("RRRR").append(BerlinClock.LINE_SEP)
			.append("RRRO").append(BerlinClock.LINE_SEP)
			.append("YYRYYRYYRYY").append(BerlinClock.LINE_SEP)
			.append("YYYY")
			.toString();
		
		assertEquals(expected , berlinClock.convertTime("23:59:59"));
	}	
	
	@Test
	public void testMorningHoursTime_01_51_11 () {
		String expected = new StringBuffer()
			.append("O").append(BerlinClock.LINE_SEP)
			.append("OOOO").append(BerlinClock.LINE_SEP)
			.append("ROOO").append(BerlinClock.LINE_SEP)
			.append("YYRYYRYYRYO").append(BerlinClock.LINE_SEP)
			.append("YOOO")
			.toString();
		
		assertEquals(expected , berlinClock.convertTime("01:51:11"));
	}
	
	@Test
	public void testEveningHoursTime_17_45_29 () {
		String expected = new StringBuffer()
			.append("O").append(BerlinClock.LINE_SEP)
			.append("RRRO").append(BerlinClock.LINE_SEP)
			.append("RROO").append(BerlinClock.LINE_SEP)
			.append("YYRYYRYYROO").append(BerlinClock.LINE_SEP)
			.append("OOOO")
			.toString();
		
		assertEquals(expected , berlinClock.convertTime("17:45:29"));
	}	
	
	@Test
	public void testMidnightTime_24_00_00 () {
		String expected = new StringBuffer()
			.append("Y").append(BerlinClock.LINE_SEP)
			.append("RRRR").append(BerlinClock.LINE_SEP)
			.append("RRRR").append(BerlinClock.LINE_SEP)
			.append("OOOOOOOOOOO").append(BerlinClock.LINE_SEP)
			.append("OOOO")
			.toString();
		
		assertEquals(expected , berlinClock.convertTime("24:00:00"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidHours_24_01_01() {
		berlinClock.convertTime("25:01:01");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidMin_14_61_01() {
		berlinClock.convertTime("14:61:01");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidSec_14_41_71() {
		berlinClock.convertTime("14:41:71");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidRangeHours_4_34_51() {
		berlinClock.convertTime("-4:34:51");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidRangeMin_14_3_51() {
		berlinClock.convertTime("14:-3:51");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidRangeSec_14_34_5() {
		berlinClock.convertTime("14:34:-5");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testIncompleteTime_14_34() {
		berlinClock.convertTime("14:34");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNullTime_NULL() {
		berlinClock.convertTime(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEmptyTime_EMPTY() {
		berlinClock.convertTime("");
	}	
	
	@Test (expected = IllegalArgumentException.class)
	public void testEmptyTime_SPACES() {
		berlinClock.convertTime("        ");
	}
}