package com.hotelreservationsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HotelReservation {

	Hotel LakeWood = new Hotel("Lakewood", 110, 90);
	Hotel BridgeWood = new Hotel("Bridgewood", 160, 50);
	Hotel RidgeWood = new Hotel("Ridgewood", 220, 150);

	List<Hotel> hotelList = new ArrayList<Hotel>();

	/**
	 * adds total hotels available in the city to hotel list
	 */
	public HotelReservation() {
		super();
		hotelList.add(LakeWood);
		hotelList.add(BridgeWood);
		hotelList.add(RidgeWood);

	}

	/**
	 * @param checkInDate
	 * @param checkOutDate
	 * @return cheapest hotel during week days
	 */
	public Hotel cheapestHotelOfWeekDayRates(String checkInDate, String checkOutDate) {

		int noOfDays = getTotalDays(checkInDate, checkOutDate);
		List<Integer> price = hotelList.parallelStream().map(hotel -> hotel.getWeekDayRatesForRegular() * noOfDays)
				.collect(Collectors.toList());
		int minPrice = Collections.min(price);
		return hotelList.parallelStream().filter(hotel -> hotel.getWeekDayRatesForRegular() * noOfDays == minPrice).findFirst()
				.orElse(null);

	}

	/**
	 * @param checkInDate
	 * @param checkOutDate
	 * @return total no of days between check in and check out
	 */
	private int getTotalDays(String checkInDate, String checkOutDate) {

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
		LocalDate checkInLocalDate = LocalDate.parse(checkInDate, dateTimeFormatter);
		LocalDate checkOutLocalDate = LocalDate.parse(checkOutDate, dateTimeFormatter);
		int noOfDays = (int) ChronoUnit.DAYS.between(checkInLocalDate, checkOutLocalDate);
		return noOfDays + 1;
	}
}
