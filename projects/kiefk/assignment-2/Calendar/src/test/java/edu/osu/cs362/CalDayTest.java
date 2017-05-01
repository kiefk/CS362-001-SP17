package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.*;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test //Check constructor with Gregorian Calendar
	  public void test01()  throws Throwable  {
		//create a GregorianCalendar object
		 GregorianCalendar cal = new GregorianCalendar();
		 //create a CalDay object, constructed with a gregorian calendar
		 CalDay calDay = new CalDay(cal);

		 assertEquals(1, calDay.getDay());
		 //months are indexed 0-11
		 assertEquals(4, calDay.getMonth());
		 assertEquals(2017, calDay.getYear());

		  //valid should be set to true
		 assertTrue(calDay.isValid());

	 }

	@Test //Check adding an appointment
	public void test02()  throws Throwable  {
		//construct a calendar
	 	GregorianCalendar cal = new GregorianCalendar();
		CalDay calDay = new CalDay(cal);
		//create an appointment
		Appt appt = new Appt(10,30, 31, 8,
				2017, "Real", "Birthday");
		//add the appointment to the calendar
		calDay.addAppt(appt);

		//get the calendar appointments
		LinkedList<Appt> list = calDay.getAppts();
		//hold the first appointment
		Appt hold = list.getFirst();

		//valid should be set to true
		assertTrue(calDay.isValid());
		//hold should be the same apointment entered
		assertSame(appt, hold);

	}


	@Test //Check adding 10 appointments with random start hours
	public void test03()  throws Throwable {
		//construct a calendar
		GregorianCalendar cal = new GregorianCalendar();
		CalDay calDay = new CalDay(cal);
		//create an appointment
		Appt appt = new Appt(10, 30, 31, 8,
				2017, "Real", "Birthday");
		//add the appointment to the calendar
		calDay.addAppt(appt);

		appt = new Appt(3, 30, 31, 8,
				2017, "Real", "Birthday");
		//add the appointment to the calendar
		calDay.addAppt(appt);

		appt = new Appt(15, 30, 31,8,
				2017, "Real", "Birthday");
		//add the appointment to the calendar
		calDay.addAppt(appt);

		appt = new Appt(16, 30, 31, 8,
				2017, "Real", "Birthday");
		//add the appointment to the calendar
		calDay.addAppt(appt);
		appt = new Appt(7, 30, 31, 8,
				2017, "Real", "Birthday");
		//add the appointment to the calendar
		calDay.addAppt(appt);
		appt = new Appt(2, 30, 31, 8,
				2017, "Real", "Birthday");
		//add the appointment to the calendar
		calDay.addAppt(appt);
		appt = new Appt(5, 30, 31, 8,
				2017, "Real", "Birthday");
		//add the appointment to the calendar
		calDay.addAppt(appt);
		appt = new Appt(12, 30, 31, 8,
				2017, "Real", "Birthday");
		//add the appointment to the calendar
		calDay.addAppt(appt);
		appt = new Appt(22, 30, 31, 8,
				2017, "Real", "Birthday");
		//add the appointment to the calendar
		calDay.addAppt(appt);
		appt = new Appt(1, 30, 31, 8,
				2017, "Real", "Birthday");
		//add the appointment to the calendar
		calDay.addAppt(appt);

		String print = calDay.toString();
		System.out.print(print);
	}

	@Test //Check constructor without Gregorian Calendar
	public void test04()  throws Throwable  {
		//empty constructor
		CalDay calDay = new CalDay();

		//valid should be set to false
		assertFalse(calDay.isValid());

	}

	@Test //Check adding an invalid appointment
	public void test05()  throws Throwable  {
		//construct a calendar
		GregorianCalendar cal = new GregorianCalendar();
		CalDay calDay = new CalDay(cal);
		//create an appointment
		Appt appt = new Appt(-5,30, 31, 8,
				2017, "Real", "Birthday");
		//add the appointment to the calendar
		calDay.addAppt(appt);

		//an invalid appointment is not added so size should be zero
		int size = calDay.getSizeAppts();
		assertEquals(0, size);
		assertFalse(appt.getValid());

	}


	@Test //Check iterator
	public void test06()  throws Throwable  {
		//construct a calendar
		GregorianCalendar cal = new GregorianCalendar();
		CalDay calDay = new CalDay(cal);
		//create an appointment
		Appt appt = new Appt(10,30, 31, 8,
				2017, "Real", "Birthday");
		//add the appointment to the calendar
		calDay.addAppt(appt);

		Iterator move = calDay.iterator();

		//valid should be set to true
		assertTrue(calDay.isValid());
		//assert that the iterator has a value
		assertTrue(move.hasNext());

		Object hold = move.next();

		assertEquals(hold, appt);
	}

	@Test //Check null calendar tostring
	public void test07()  throws Throwable  {
		//empty constructor
		CalDay calDay = new CalDay();

		//valid should be set to false
		assertFalse(calDay.isValid());


		//while I'm at it, attempt to tostring the calendar
		String test = calDay.toString();
		assertEquals("",test);
	}

	@Test //Check null appointment set
	public void test08()  throws Throwable  {
		//empty constructor
		CalDay calDay = new CalDay();

		//valid should be set to false
		assertFalse(calDay.isValid());


		//while I'm at it, attempt to tostring the calendar
		String test = calDay.toString();
		assertEquals("",test);
	}

	@Test //Check null iterator
	public void test09()  throws Throwable  {
		//empty constructor
		CalDay calDay = new CalDay();

		//valid should be set to false
		assertFalse(calDay.isValid());

		Iterator move = calDay.iterator();

		assertEquals(null, move);
	}

	}
