  
import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

public class TestCase {
	GojekPark gojekPark = new GojekPark();  
	
	@Test
    public void test_create_parking_lot() {
        assertEquals("Created a parking lot with 6 slots", gojekPark.create_parking_lot(6));
    }
	@Test
    public void test_park() {
		test_create_parking_lot();
        assertEquals("Allocated slot number: 1", gojekPark.park("KA-01-HH-1234","White"));
        assertEquals("Allocated slot number: 2", gojekPark.park("KA-01-HH-9999","White"));
        assertEquals("Allocated slot number: 3", gojekPark.park("KA-01-BB-0001","Black"));
        assertEquals("Allocated slot number: 4", gojekPark.park("KA-01-HH-7777","Red"));
        assertEquals("Allocated slot number: 5", gojekPark.park("KA-01-HH-2701","Blue"));
        assertEquals("Allocated slot number: 6", gojekPark.park("KA-01-HH-3141","Black"));
    }
	@Test
    public void test_leave() {
		test_park();
        assertEquals("Slot number 4 is free", gojekPark.leave(4));
    }
	@Test
    public void test_status() {
		test_leave();
		String message=
						"Slot No. Registration No Colour\n"
						+ "1 KA-01-HH-1234 White\n"
						+ "2 KA-01-HH-9999 White\n"
						+ "3 KA-01-BB-0001 Black\n"
						+ "5 KA-01-HH-2701 Blue\n"
						+ "6 KA-01-HH-3141 Black\n"; 
        assertEquals(message, gojekPark.status());
    }
	@Test
    public void test_registration_numbers_for_cars_with_colour() {
		test_leave();
		assertEquals("Allocated slot number: 4", gojekPark.park("KA-01-P-333","White"));
        assertEquals("Sorry, parking lot is full", gojekPark.park("DL-12-AA-9999","White"));
		String message="KA-01-HH-1234, KA-01-HH-9999, KA-01-P-333"; 
        assertEquals(message, gojekPark.registration_numbers_for_cars_with_colour("White"));
    }
	@Test
    public void test_slot_numbers_for_cars_with_colour() {
		test_registration_numbers_for_cars_with_colour();
		String message="1, 2, 4";  
        assertEquals(message, gojekPark.slot_numbers_for_cars_with_colour("White"));
    }
	@Test
    public void test_slot_number_for_registration_number() { 
		test_slot_numbers_for_cars_with_colour();
        assertEquals("6", gojekPark.slot_number_for_registration_number("KA-01-HH-3141"));
        assertEquals("Not found", gojekPark.slot_number_for_registration_number("MH-04-AY-1111"));
    }
}
