package com.hotelreservationsystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	/**
	 * checks for cheapest hotel between given date range which consists of both
	 * week days and weekend days and returns hotels names
	 */
	@Test
	public void givenDateRangeOfWeekDaysAndWeekend_WhenAnalyse_ShouldReturnCheapestHotelName() {

		HotelReservation hotelReservation = new HotelReservation();
		List<String> actualList = hotelReservation.cheapestHotelOfBothWeekDayAndWeekendRates("11Sep2020", "12Sep2020");
		List<String> expectedList = new ArrayList<>(Arrays.asList("Lakewood", "Bridgewood"));
		System.out.println(actualList);
		Assert.assertEquals(expectedList, actualList);

	}

	@Test
	public void givenDateRangeForCheapestAndBestRatedHotel_WhenAnalyse_ShouldReturnHotelName() {
		HotelReservation hotelReservationMain = new HotelReservation();
		String hotel = hotelReservationMain.cheapestBestRatedHotelForRegulars("11Sep2020", "12Sep2020");
		Assert.assertEquals("Bridgewood", hotel);
	}

	@Test
	public void givenDateRangeForBestRatedHotel_WhenAnalyse_ShouldReturnHotelName() {
		HotelReservation hotelReservationMain = new HotelReservation();
		String hotel = hotelReservationMain.bestRatedHotelForRegulars("11Sep2020", "12Sep2020");
		Assert.assertEquals("Ridgewood", hotel);
	}
}
