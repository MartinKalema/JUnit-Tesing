package edu.sc.bse3211.meetingplanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class OrganizationTest {

	@Test 
    public void testGetEmployees() { 
        // Test Description: This test verifies that the Organization class returns the correct number of employees.
        Organization org = new Organization(); 
        assertEquals(5, org.getEmployees().size()); 
    }

    @Test 
    public void testGetRooms() { 
        // Test Description: This test verifies that the Organization class returns the correct number of rooms.
        Organization org = new Organization(); 
        assertEquals(5, org.getRooms().size()); 
    }

    @Test 
    public void testGetRoom() throws Exception { 
        // Test Description: This test verifies that the Organization class returns the correct Room object for a given ID.
        Organization org = new Organization(); 
        Room room = org.getRoom("LLT6A"); 
        assertEquals("LLT6A", room.getID()); 
    }

    @Test 
    public void testGetEmployee() throws Exception { 
        // Test Description: This test verifies that the Organization class returns the correct Person object for a given name.
        Organization org = new Organization(); 
        Person employee = org.getEmployee("Namugga Martha"); 
        assertEquals("Namugga Martha", employee.getName()); 
    }

    @Test 
    public void testGetRoomException() throws Exception { 
        // Test Description: This test verifies that the Organization class throws an exception when a non-existent room ID is passed to the getRoom method.
        Organization org = new Organization(); 
        try { 
            org.getRoom("Invalid ID"); 
            fail("Expected exception not thrown."); 
        } catch (Exception e) { 
            assertEquals("Requested room does not exist", e.getMessage()); 
        } 
    }
}
