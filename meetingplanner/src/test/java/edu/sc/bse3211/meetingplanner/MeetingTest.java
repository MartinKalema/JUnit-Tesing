package edu.sc.bse3211.meetingplanner;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class MeetingTest {

    @SuppressWarnings("unused")
    @Test
    public void testDefaultConstructor() {
        // **Test Description:** This test verifies that the default constructor of the Meeting class initializes all 
		//                       fields to their default values, including NULL for all objects and empty ArrayList for attendees.
        Meeting meeting = new Meeting();
        assertNull(meeting.getMonth());
        assertNull(meeting.getDay());
        assertNull(meeting.getStartTime());
        assertNull(meeting.getEndTime());
        assertNull(meeting.getRoom());
        assertNull(meeting.getDescription());
        assertTrue(meeting.getAttendees().isEmpty());
    }

    @Test
    public void testAddAttendee() {
        // **Test Description:** This test verifies that the addAttendee method correctly adds an attendee to the list of
		//                       attendees of a Meeting object.
        ArrayList<Person> attendees = new ArrayList<Person>() {{
            add(new Person("Nagaba"));
        }};
        Room room = new Room("1A");
        Meeting meeting = new Meeting(1, 1, 9, 10, attendees, room , "Test Meeting");
        meeting.addAttendee(new Person("Jane Smith"));
        assertTrue(meeting.getAttendees().contains(new Person("Jane Smith")));
    }


    @Test
    public void testRemoveAttendee() {
        // **Test Description:** This test verifies that the removeAttendee method correctly removes an attendee from the list of
		//                       attendees of a Meeting object
        ArrayList<Person> attendees = new ArrayList<Person>() {{
            add(new Person("John Doe"));
            add(new Person("Jane Smith"));
        }};
        Meeting meeting = new Meeting(1, 1, 9, 10, attendees, new Room("1A"), "Test Meeting");
        meeting.removeAttendee(new Person("John Doe"));
        assertFalse(meeting.getAttendees().contains(new Person("John Doe")));
        assertTrue(meeting.getAttendees().contains(new Person("Jane Smith")));
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
        String expected = "1/1, 9 - 10,1A: Test Meeting\nAttending: John Doe, Jane Smith";
        assertEquals(expected, meeting.toString());
    }
}
