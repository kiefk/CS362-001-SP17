package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }


	@Test //testing isValid start hour <0
	public void test02()  throws Throwable {
		//create an appointment
	 	int startHour=-2;
		int startMinute=30;
		int startDay=10;
		int startMonth=4;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";

		//make the appointment
	 	Appt appt = new Appt(startHour, startMinute , startDay , startMonth ,
				startYear , title, description);

	 	//check that the appointment is invalid

		assertFalse(appt.getValid());
		assertEquals(-2, appt.getStartHour());

	 }

	@Test //testing isValid start hour >23
	public void test03()  throws Throwable {
		//create an appointment
		int startHour=25;
		int startMinute=30;
		int startDay=10;
		int startMonth=4;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";

		//make the appointment
		Appt appt = new Appt(startHour, startMinute , startDay , startMonth ,
				startYear , title, description);

		//check that the appointment is invalid

		assertFalse(appt.getValid());
		assertEquals(25, appt.getStartHour());

	}

	@Test //testing isValid start minute <0
	public void test04()  throws Throwable {
		//create an appointment
		int startHour=10;
		int startMinute=-5;
		int startDay=10;
		int startMonth=4;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";

		//make the appointment
		Appt appt = new Appt(startHour, startMinute , startDay , startMonth ,
				startYear , title, description);

		//check that the appointment is invalid

		assertFalse(appt.getValid());
		assertEquals(-5, appt.getStartMinute());

	}


	@Test //testing isValid start minute >59
	public void test05()  throws Throwable {
		//create an appointment
		int startHour=10;
		int startMinute=70;
		int startDay=10;
		int startMonth=4;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";

		//make the appointment
		Appt appt = new Appt(startHour, startMinute , startDay , startMonth ,
				startYear , title, description);

		//check that the appointment is invalid

		assertFalse(appt.getValid());
		assertEquals(70, appt.getStartMinute());

	}

	@Test //testing isValid start month <1, >12, setStartMonth(int)
	public void test06()  throws Throwable {
		//create an appointment
		int startHour=10;
		int startMinute=34;
		int startDay=10;
		int startMonth=0;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";

		//make the appointment
		Appt appt = new Appt(startHour, startMinute , startDay , startMonth ,
				startYear , title, description);

		//check that the appointment is invalid

		assertFalse(appt.getValid());
		assertEquals(0, appt.getStartMonth());

		//change the starting month to a valid month

		appt.setStartMonth(4);

		//check that the appointmetn is valid

		assertTrue(appt.getValid());
		assertEquals(4, appt.getStartMonth());

		//change the starting month to an invalid month
		appt.setStartMonth(24);

		//check that the appointment is invalid
		assertFalse(appt.getValid());
		assertEquals(24, appt.getStartMonth());

	}


	@Test //testing all of the setters
	public void test07()  throws Throwable {
		//create an appointment
		int startHour=10;
		int startMinute=30;
		int startDay=20;
		int startMonth=4;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";

		//make the appointment
		Appt appt = new Appt(startHour, startMinute , startDay , startMonth ,
				startYear , title, description);
		//change all of the appointment values using the setter
		appt.setStartHour(1);
		appt.setStartMinute(2);
		appt.setStartDay(3);
		appt.setStartMonth(5);
		appt.setStartYear(2018);
		appt.setTitle("The future");
		appt.setDescription("is coming on.");

		//assert that the appointment is still valid with the new values instead of the old
		assertTrue(appt.getValid());
		assertEquals(1, appt.getStartHour());
		assertEquals(2, appt.getStartMinute());
		assertEquals(3, appt.getStartDay());
		assertEquals(5, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("The future", appt.getTitle());
		assertEquals("is coming on.", appt.getDescription());

	}

	//checking null titles and description
	@Test
	public void test08()  throws Throwable {
		//create an appointment
		int startHour = 10;
		int startMinute = 30;
		int startDay = 20;
		int startMonth = 4;
		int startYear = 2017;
		String title = "Birthday Party";
		String description = "This is my birthday party.";

		//make the appointment
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth,
				startYear, title, description);
		//assert that the original appt is valid
		assertTrue(appt.getValid());

		//change to empty titles
		appt.setTitle(null);
		appt.setDescription(null);

		//expected to still be valid, with titles that are blank ""
		assertTrue(appt.getValid());
		assertEquals("", appt.getTitle());
		assertEquals("", appt.getDescription());
	}


	@Test //checking toString
	public void test09()  throws Throwable {

		//create an appointment
		int startHour = 10;
		int startMinute = 30;
		int startDay = 20;
		int startMonth = 4;
		int startYear = 2017;
		String title = "Birthday Party";
		String description = "This is my birthday party.";

		//make the appointment
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth,
				startYear, title, description);
		//assert that the original appt is valid
		assertTrue(appt.getValid());

		String hold = appt.toString();
		//print to double check that the string is being created properly
		System.out.print(hold);
		//assert that the string is not null
		assertNotNull(hold);

		//change to an hour > 11

		appt.setStartHour(15);
		assertEquals(15, appt.getStartHour());

		assertTrue(appt.getValid());
		//print to double check that the string is being created properly
		hold = appt.toString();
		System.out.print(hold);
		//assert that the string is not null
		assertNotNull(hold);

		//change hour to 0

		appt.setStartHour(0);
		assertEquals(0, appt.getStartHour());

		assertTrue(appt.getValid());
		//print to double check that the string is being created properly
		hold = appt.toString();
		System.out.print(hold);
		//assert that the string is not null
		assertNotNull(hold);

		//change hour to invalid value

		appt.setStartHour(30);
		assertEquals(30, appt.getStartHour());

		//check that the appointment is not valid
		assertFalse(appt.getValid());
		//check if null
		hold = appt.toString();
		assertNull(hold);




	}




}






