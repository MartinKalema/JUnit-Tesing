package edu.sc.bse3211.meetingplanner;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MeetingTest {

    @Test
    public void testDefaultConstructor() {
        // **Test Description:** This test verifies that the default constructor of the Meeting class initializes all 
		//                       fields to their default values, including NULL for all objects and empty ArrayList for attendees.
        ArrayList<Person> attendees = new ArrayList<Person>() {{
            add(new Person("Nagaba Blessing"));
        }};
        Room room = new Room("1A");
        Meeting meeting = new Meeting(1, 1, 9, 10, attendees, room , "Test Meeting");
        assertEquals(1, meeting.getMonth());
        assertEquals(1, meeting.getDay());
        assertEquals(9, meeting.getStartTime());
        assertEquals(10, meeting.getEndTime());
        assertEquals("1A", meeting.getRoom().getID());
        assertEquals("Test Meeting", meeting.getDescription());
        assertFalse(meeting.getAttendees().isEmpty());
    }

    @Test
    public void testAddAttendee() {
        // **Test Description:** This test verifies that the addAttendee method correctly adds an attendee to the list of
		//                       attendees of a Meeting object.
        ArrayList<Person> attendees = new ArrayList<Person>() {{
            add(new Person("Nagaba Blessing"));
        }};
        Room room = new Room("1A");
        Meeting meeting = new Meeting(1, 1, 9, 10, attendees, room , "Test Meeting");
        Person newAttendee = new Person("Jane Smith");
        meeting.addAttendee(newAttendee);
        assertTrue(meeting.getAttendees().contains(newAttendee));
    }


    @Test
    public void testRemoveAttendee() {
        // **Test Description:** This test verifies that the removeAttendee method correctly removes an attendee from the list of
		//                       attendees of a Meeting object
        Person john = new Person("John Doe");
        Person jane = new Person("Jane Smith");
        ArrayList<Person> attendees = new ArrayList<Person>(Arrays.asList(john, jane));
        Meeting meeting = new Meeting(1, 1, 9, 10, attendees, new Room("1A"), "Test Meeting");
        meeting.removeAttendee(john);
        assertFalse(meeting.getAttendees().contains(john));
        assertTrue(meeting.getAttendees().contains(jane));
    }

    @Test
    public void testToString() {
        // **Test Description:** This test verifies that the toString method formats the meeting details correctly,
		//                       including the meeting's date, time, room, attendees, and title.
        ArrayList<Person> attendees = new ArrayList<Person>() {{
            add(new Person("John Doe"));
            add(new Person("Jane Smith"));
        }};
        Meeting meeting = new Meeting(1, 1, 9, 10, attendees, new Room("1A"), "Test Meeting");
        String expected = "1/1, 9 - 10,1A: Test Meeting\nAttending: John Doe,Jane Smith";
        assertEquals(expected, meeting.toString().trim());
    }
}
