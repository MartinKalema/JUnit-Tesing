package edu.sc.bse3211.meetingplanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class PersonTest {
	@Test
    public void testDefaultConstructor() {
        // **Test Description:** Verifies the behavior of the default constructor in the Person class.
        //                       It ensures that a new Person object is created with an empty name.
        Person person = new Person();
        assertEquals("", person.getName());
    }

    @Test
    public void testParameterizedConstructor() {
        // **Test Description:** Verifies the behavior of the parameterized constructor in the Person class.
        //                       It ensures that a new Person object is created with the provided name.
        Person person = new Person("Shiphra");
        assertEquals("Shiphra", person.getName());
    }

    @Test
    public void testNullNameConstructor() {
        // **Test Description:** Verifies the behavior of the constructor in the Person class when a null name is provided.
        //                       It ensures that a new Person object is created with a null name.
        Person person = new Person(null);
        assertNull(person.getName());
    }


}
