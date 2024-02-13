import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calendar.Meeting;

class CalendarEventTest {

	GregorianCalendar startA;
	GregorianCalendar endA;
	GregorianCalendar startB;
	GregorianCalendar endB;
	GregorianCalendar repeatUntilA;
	GregorianCalendar repeatUntilB;
	
	WeeklyEvent weeklyEventTest;
	MultiDayPerWeekEvent multiDayPerWeekTest;
	
	Meeting A;
	Meeting B;
	
	int[] daysA = {1,4,5,2};
	int[] daysB = {1,2,3,6};
	
	@BeforeEach
	void setUp() throws Exception {
		
		startA = new GregorianCalendar(2023,8,28,8,30);
		endA = new GregorianCalendar(2023,8,28,9,30);
		startB = new GregorianCalendar(2023,8,31,8,30);
		endB = new GregorianCalendar(2023,8,31,9,30);
		repeatUntilA = new GregorianCalendar(2023,10,1,9,30);
		repeatUntilB = new GregorianCalendar(2023,11,1,9,30);

		weeklyEventTest = new WeeklyEvent("Swimming","Pool",startA, endA);
		weeklyEventTest.setRepeatUntil(repeatUntilA);
		
		multiDayPerWeekTest = new MultiDayPerWeekEvent("Swimming","Pool",startA, endA);
		multiDayPerWeekTest.setDays(daysA);
		
		
		A = new Meeting("A","ALoc",startA,endA);
		B = new Meeting("B","BLoc",endA,endB);

	}
	
	/*
	@Test
	void testScheduleEventWeekly() {
		
	}
	*/
	
	
	@Test
	void testGetDays() {
		assertEquals(daysA, multiDayPerWeekTest.getDays());
	}
	@Test
	void testSetDays() {
		multiDayPerWeekTest.setDays(daysB);
		assertEquals(daysB, multiDayPerWeekTest.getDays());
	}
	
	@Test
	void testGetRepeatUntil() {
		assertEquals(repeatUntilA, weeklyEventTest.getRepeatUntil());
	}
	
	@Test
	void testSetRepeatUntil() {
		weeklyEventTest.setRepeatUntil(repeatUntilB);
		assertEquals(repeatUntilB, weeklyEventTest.getRepeatUntil());
	}

	@Test
	void testGetDescription() {
		assertEquals("Swimming",weeklyEventTest.getDescription());
	}

	@Test
	void testSetDescription() {
		weeklyEventTest.setDescription("To Swim");
		assertEquals("To Swim",weeklyEventTest.getDescription());
	}

	@Test
	void testGetLocation() {
		assertEquals("Pool",weeklyEventTest.getLocation());
	}

	@Test
	void testSetLocation() {
		weeklyEventTest.setLocation("Gym");
		assertEquals("Gym",weeklyEventTest.getLocation());	
	}

	@Test
	void testGetStartTime() {
		assertEquals(startA, weeklyEventTest.getStartTime());
	}

	@Test
	void testSetStartTime() {
		weeklyEventTest.setStartTime(startB);
		assertEquals(startB, weeklyEventTest.getStartTime());
	}

	@Test
	void testGetEndTime() {
		assertEquals(endA, weeklyEventTest.getEndTime());
	}

	@Test
	void testSetEndTime() {
		weeklyEventTest.setEndTime(endB);
		assertEquals(endB, weeklyEventTest.getEndTime());
	}
}

