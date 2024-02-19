import static org.junit.jupiter.api.Assertions.*;


	import java.util.GregorianCalendar;
	import java.util.Calendar;

	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;

	import calendar.Meeting;
	import calendar.MeetingCalendar;

	class CalendarEventTest {

        String description = "description";
        String location = "tajikistan";
        String description2 = "description2";
        String location2 = "usa";
        
		GregorianCalendar startA = new GregorianCalendar(2023,8,14,5,23);
		GregorianCalendar endA = new GregorianCalendar(2023,8,14,10,25);
		GregorianCalendar repeatUntilA = new GregorianCalendar(2023,8,22,5,30);
		GregorianCalendar startB = new GregorianCalendar(2023,8,15,9,23);
		GregorianCalendar endB = new GregorianCalendar(2023,8,15,18,25);
		GregorianCalendar repeatUntilB = new GregorianCalendar(2023,8,23,5,30);
        GregorianCalendar startC = new GregorianCalendar(2023,8,21,5,23);
		GregorianCalendar endC = new GregorianCalendar(2023,8,21,10,25);
        GregorianCalendar startD = new GregorianCalendar(2023,8,28,5,23);
		GregorianCalendar endD = new GregorianCalendar(2023,8,28,10,25);
        
        
		int[] daysA = {Calendar.MONDAY, Calendar.SUNDAY, Calendar.THURSDAY};
		int[] daysB = {Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.FRIDAY, Calendar.SATURDAY};
		
		
		WeeklyEvent we;
		WeeklyEvent we2;
		
		MultiDayPerWeekEvent mdpw;
		MultiDayPerWeekEvent mdpw2;
		
		OneTimeEvent ote;
		OneTimeEvent ote2;
		
		PriorityEvent pe;
		PriorityEvent pe2;
		
		MeetingCalendar cal;
		
		Meeting meetingA;
		Meeting meetingB;
		Meeting meetingC;
		Meeting meetingD;
		
		@BeforeEach
		void setUp() throws Exception {
			ote = new OneTimeEvent(description, location, startA, endA);
		    ote2 = new OneTimeEvent(description2, location2, startB, endB);
		    mdpw = new MultiDayPerWeekEvent(description, location, startA, endA, repeatUntilA, daysA);
		    mdpw2 = new MultiDayPerWeekEvent(description2, location2, startB, endB, repeatUntilB, daysB);
		    pe = new PriorityEvent(description2, location2, startA, endA);
		    cal = new MeetingCalendar();
		    meetingA = new Meeting(description, location, startA, endA);
		    meetingB = new Meeting(description2, location2, startA, endA);
		    meetingC = new Meeting(description, location, startC, endC);
		    meetingD = new Meeting(description, location, startD, endD);
		    we = new WeeklyEvent(description2, location2, startA, endA, repeatUntilA);
		}
		
		@Test
		void testGetDesciption(){
		    assertEquals(description, ote.getDescription());
		}
		
		@Test
		void testSetDesciption(){
		    ote2.setDescription(description);
		    assertEquals(description, ote2.getDescription());
		}
		
		@Test
		void testGetLocation(){
		    assertEquals(location,ote.getLocation());
		}
		
		
		@Test
		void testSetLocation(){
		    ote2.setLocation(location);
		    assertEquals(location,ote2.getLocation());
		}
		
		@Test
		void testGetStartTime(){
		    assertEquals(startA,ote.getStartTime());
		}
		
		@Test
		void testGetEndTime(){
		    assertEquals(endA,ote.getEndTime());
		}
		
		@Test
		void testSetStartTime(){
		    ote2.setStartTime(startA);
		    assertEquals(startA,ote2.getStartTime());
		}
		
		@Test
		void testSetEndTime(){
		    ote2.setEndTime(endA);
		    assertEquals(endA,ote2.getEndTime());
		}
		
		@Test
		void testOneTimeEvent(){
		    //assertEquals(description, ote.getDescription());
		    //assertEquals(location, ote.getLocation());
		    //assertEquals(startA, ote.getStartTime());
		   // assertEquals(endA, ote.getEndTime());
		    OneTimeEvent ONE = new OneTimeEvent(description, location, startA, endA);

            OneTimeEvent ON = new OneTimeEvent(description2, location2, startA, endA);

            MeetingCalendar calen = new MeetingCalendar(); 
            Meeting test1M = new Meeting (description, location, startA, endA);

            Meeting test2M = new Meeting (description2, location2, startA, endA);

            ONE.scheduleEvent(calen); 
            
            assertEquals(test1M, calen.findMeeting(startA));

            ON.scheduleEvent(calen);

            assertEquals(test1M, calen.findMeeting(startA));
		}
		
		@Test
		void testGetRepeatUntil(){
		    assertEquals(repeatUntilA, mdpw.getRepeatUntil());
		}
		
		@Test
		void testSetRepeatUntil(){
		    mdpw2.setRepeatUntil(repeatUntilA);
		    assertEquals(repeatUntilA, mdpw2.getRepeatUntil());
		}
		
		@Test
		void testGetDays(){
		    assertEquals(daysA, mdpw.getDays());
		}
		
		@Test
		void testSetDays(){
		    mdpw2.setDays(daysA);
		    assertEquals(daysA, mdpw2.getDays());

		}
		
		//comment
		@Test
		void testOverlap(){
		    ote.scheduleEvent(cal);
		    assertEquals(meetingA, cal.findMeeting(startA));
		    pe.scheduleEvent(cal);
		    assertEquals(meetingB, cal.findMeeting(startA));
		    ote2.scheduleEvent(cal);
		    assertEquals(meetingB, cal.findMeeting(startA));
		}
		
		
		@Test
		void testEventAgain(){
		    ote.scheduleEvent(cal);
		    assertEquals(meetingA, cal.findMeeting(startA));
		    we.scheduleEvent(cal);
		    assertEquals(meetingA, cal.findMeeting(startA));
		}
		
		@Test
		void testEventMultiD() {
	        OneTimeEvent ONE = new OneTimeEvent (description, location, startA, endA);

            MultiDayPerWeekEvent WD = new MultiDayPerWeekEvent (description2, location2, startA, endA, repeatUntilA, daysA);

            MeetingCalendar calen = new MeetingCalendar();

            Meeting testOdin = new Meeting(description, location, startA, endA);

            Meeting testDva = new Meeting(description2, location2, startA, endA);

            ONE.scheduleEvent(calen);

            assertEquals(testOdin, calen.findMeeting(startA));

            WD.scheduleEvent(calen);

            assertEquals(testOdin, calen.findMeeting(startA));
		}
		
		@Test
		void testConstructorOneTime(){
		    assertEquals(description, ote.getDescription());
		    assertEquals(location, ote.getLocation());
		    assertEquals(startA, ote.getStartTime());
		    assertEquals(endA, ote.getEndTime());
		}
		
		@Test
		void testConstructorPriority(){
		    assertEquals(description2, pe.getDescription());
		    assertEquals(location2, pe.getLocation());
		    assertEquals(startA, pe.getStartTime());
		    assertEquals(endA, pe.getEndTime());
		}
		@Test
		void testConstructorWE(){
		    assertEquals(description2, we.getDescription());
		    assertEquals(location2, we.getLocation());
		    assertEquals(startA, we.getStartTime());
		    assertEquals(endA, we.getEndTime());
		    assertEquals(repeatUntilA, we.getRepeatUntil());
		}
		
		@Test
		void testConstructorMDPW(){
		    assertEquals(description, mdpw.getDescription());
		    assertEquals(location, mdpw.getLocation());
		    assertEquals(startA, mdpw.getStartTime());
		    assertEquals(endA, mdpw.getEndTime());
		    assertEquals(repeatUntilA, mdpw.getRepeatUntil());
		    assertEquals(daysA, mdpw.getDays());
		}
		
		
		@Test
		void testMDPW(){
		    MultiDayPerWeekEvent mdpww = new MultiDayPerWeekEvent(description, location, startA, endA, repeatUntilA, daysA);
		    MeetingCalendar calen = new MeetingCalendar();
		    Meeting testOne = new Meeting(description, location, startB, endB);
		    mdpww.scheduleEvent(calen);
		    assertFalse(calen.doesMeetingConflict(testOne));
		}
		
		@Test
		void testWeekly(){
		    WeeklyEvent w = new WeeklyEvent(description, location, startA, endA, repeatUntilA);
		    Meeting testM1 = new Meeting(description, location, startC, endC);
		    Meeting testM2 = new Meeting(description, location, startD, endD);
		    w.scheduleEvent(cal);
		    assertEquals(testM1, cal.findMeeting(startC));
		    assertFalse(testM2 == cal.findMeeting(startD));
		}
		
		@Test
		void testWeeklyStop(){
		    we.scheduleEvent(cal);
		    Meeting test2 = new Meeting(description, location, startD, repeatUntilA);
		    assertNull (cal.findMeeting(startD));
		}
		

}

