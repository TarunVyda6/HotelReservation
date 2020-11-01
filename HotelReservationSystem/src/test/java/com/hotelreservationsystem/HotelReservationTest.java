package com.hotelreservationsystem;

import java.text.ParseException;
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
	public void givenDateRangeOfWeekDays_WhenAnalyse_ShouldReturnCheapestHotelName() throws ParseException {

		HotelReservation hotelReservation = new HotelReservation();
		Hotel cheapestHotel = hotelReservation.cheapestHotelOfWeekDayRates("10Sep2020", "11Sep2020");
		Assert.assertEquals("Lakewood", cheapestHotel.getName());

	}

	/**
	 * checks for cheapest hotel between given date range which consists of both
	 * week days and weekend days and returns hotels names
	 */
	@Test
	public void givenDateRangeOfWeekDaysAndWeekend_WhenAnalyse_ShouldReturnCheapestHotelName() throws ParseException {

		HotelReservation hotelReservation = new HotelReservation();
		List<String> actualList = hotelReservation.cheapestHotelOfBothWeekDayAndWeekendRates("11Sep2020", "12Sep2020");
		List<String> expectedList = new ArrayList<>(Arrays.asList("Lakewood", "Bridgewood"));
		System.out.println(actualList);
		Assert.assertEquals(expectedList, actualList);

	}

	@Test
	public void givenDateRangeForCheapestAndBestRatedHotelForRegularCustomer_WhenAnalyse_ShouldReturnHotelName()
			throws ParseException {
		HotelReservation hotelReservationMain = new HotelReservation();
		String hotel = hotelReservationMain.cheapestBestRatedHotelForRegulars("11Sep2020", "12Sep2020");
		Assert.assertEquals("Bridgewood", hotel);
	}

	@Test
	public void givenDateRangeForBestRatedHotelForRegularCustomer_WhenAnalyse_ShouldReturnHotelName()
			throws ParseException {
		HotelReservation hotelReservationMain = new HotelReservation();
		String hotel = hotelReservationMain.bestRatedHotelForRegulars("11Sep2020", "12Sep2020");
		Assert.assertEquals("Ridgewood", hotel);
	}

	@Test
	public void givenDateRangeForCheapestAndBestRatedHotelForRewardCustomer_WhenAnalyse_ShouldReturnHotelName()
			throws ParseException {
		HotelReservation hotelReservationMain = new HotelReservation();
		String hotel = hotelReservationMain.cheapestBestRatedHotelForRewardCustomer("11Sep2020", "12Sep2020");
		Assert.assertEquals("Ridgewood", hotel);
	}

	@Test
	public void givenInvalidDate_WhenAnalyse_ShouldReturnMessage() {
		HotelReservation hotelReservationMain = new HotelReservation();
		try {
			hotelReservationMain.bestRatedHotelForRegulars("10092020", "12Sep20");
		} catch (Exception e) {
			Assert.assertEquals("Text '10092020' could not be parsed at index 2", e.getMessage());
		}
	}

}
