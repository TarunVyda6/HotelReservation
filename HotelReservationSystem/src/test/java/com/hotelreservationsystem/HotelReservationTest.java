package com.hotelreservationsystem;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Tarun vyda
 *
 */
public class HotelReservationTest {

	/**
	 * checks for the cheapest hotel between given date range of week days and
	 * returns the cheapest hotel
	 */
	@Test
	public void givenDateRangeOfWeekDays_WhenAnalyse_ShouldReturnCheapestHotelName() {

		HotelReservation hotelReservation = new HotelReservation();
		Hotel cheapestHotel = hotelReservation.cheapestHotelOfWeekDayRates("10Sep2020", "11Sep2020");
		Assert.assertEquals("Lakewood", cheapestHotel.getName());

	}

}
