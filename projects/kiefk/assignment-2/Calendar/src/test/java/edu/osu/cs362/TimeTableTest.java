package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test //create a time Table range
	  public void test01()  throws Throwable  {
		 //construct a calendar
		 GregorianCalendar cal = new GregorianCalendar();
		 CalDay calDay = new CalDay(cal);
		 TimeTable table = new TimeTable();
		 //create an appointment
		 Appt appt = new Appt(10,30, 20, 4,
				 2017, "Real", "Birthday");
		 //add the appointment to the calendar
		 calDay.addAppt(appt);
		 appt = new Appt(10,30, 5, 4,
				 2017, "Fake", "Birthday");
		 //add the appointment to the calendar
		 calDay.addAppt(appt);
		 //get the calendar appointments
		 LinkedList<Appt> list = calDay.getAppts();
		 //today
		 GregorianCalendar today = new GregorianCalendar();
		 //20 days from today
		 GregorianCalendar lastday = (GregorianCalendar)today.clone();
		 lastday.add(Calendar.DAY_OF_MONTH,20);

		 LinkedList<CalDay> range = table.getApptRange(list,today,lastday);

		 System.out.print(range);
	 }


		//catch exception for schedule
	@Test(expected=IllegalArgumentException.class)
	public void test02()  throws Throwable  {
		//construct a calendar
		GregorianCalendar cal = new GregorianCalendar();
		CalDay calDay = new CalDay(cal);
		TimeTable table = new TimeTable();
		//create an appointment
		Appt appt = new Appt(10,30, 31, 4,
				2017, "Real", "Birthday");
		//add the appointment to the calendar
		calDay.addAppt(appt);
		appt = new Appt(10,30, 5, 4,
				2017, "Fake", "Birthday");
		//add the appointment to the calendar
		calDay.addAppt(appt);
		//get the calendar appointments
		LinkedList<Appt> list = calDay.getAppts();

		//today
		GregorianCalendar today = new GregorianCalendar();
		//20 days from now
		GregorianCalendar lastday = (GregorianCalendar)today.clone();
		lastday.add(Calendar.DAY_OF_MONTH,20);

		LinkedList<CalDay> range = table.getApptRange(list,lastday,today);

	}

	@Test //First occurance after the last day
	public void test03()  throws Throwable  {
		//construct a calendar
		GregorianCalendar cal = new GregorianCalendar();
		CalDay calDay = new CalDay(cal);
		TimeTable table = new TimeTable();
		//create an appointment
		Appt appt = new Appt(10,30, 20, 7,
				2017, "Real", "Birthday");
		//add the appointment to the calendar
		calDay.addAppt(appt);
		appt = new Appt(10,30, 5, 7,
				2017, "Fake", "Birthday");
		//add the appointment to the calendar
		calDay.addAppt(appt);

		//get the calendar appointments
		LinkedList<Appt> list = calDay.getAppts();

		//today
		GregorianCalendar today = new GregorianCalendar();
		//20 days from today
		GregorianCalendar lastday = (GregorianCalendar)today.clone();
		lastday.add(Calendar.DAY_OF_MONTH,20);

		LinkedList<CalDay> range = table.getApptRange(list,today, lastday);

		System.out.print("\n\n" + range);
	}

	@Test //delete a time Table range
	public void test04()  throws Throwable  {
		//construct a calendar
		GregorianCalendar cal = new GregorianCalendar();
		CalDay calDay = new CalDay(cal);
		TimeTable table = new TimeTable();
		//create an appointment
		Appt appt = new Appt(10,30, 20, 4,
				2017, "Real", "Birthday");
		//add the appointment to the calendar
		calDay.addAppt(appt);
		appt = new Appt(10,30, 5, 4,
				2017, "Fake", "Birthday");
		//add the appointment to the calendar
		calDay.addAppt(appt);
		//get the calendar appointments
		LinkedList<Appt> list = calDay.getAppts();
		//today
		//delete a value
		LinkedList<Appt> delete = table.deleteAppt(list , appt);

		System.out.print(delete);
	}


	@Test //delete a null time Table range
	public void test05()  throws Throwable  {
		//construct a calendar
		GregorianCalendar cal = new GregorianCalendar();
		CalDay calDay = new CalDay(cal);
		TimeTable table = new TimeTable();
		//create an appointment
		Appt appt = null;

		//get the calendar appointments
		LinkedList<Appt> list = calDay.getAppts();
		//today
		//attempting to delete a null value returns a null value.
		assertNull(table.deleteAppt(list , appt));

	}

	@Test //delete from a null calendar
	public void test06()  throws Throwable  {
		//construct a calendar
		CalDay calDay = new CalDay();
		TimeTable table = new TimeTable();

		//create an appointment
		Appt appt = new Appt(10,30, 20, 4,
				2017, "Real", "Birthday");
		//add the appointment to the calendar

		//get the calendar appointments
		LinkedList<Appt> list = calDay.getAppts();
		//today
		//attempting to delete from a null value returns a null value.
		assertNull(table.deleteAppt(list , appt));

	}




}
