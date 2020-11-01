package com.hotelreservationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class HotelReservation {

	Hotel LakeWood = new Hotel("Lakewood", 110, 90, 3);
	Hotel BridgeWood = new Hotel("Bridgewood", 150, 50, 4);
	Hotel RidgeWood = new Hotel("Ridgewood", 220, 150, 5);

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
		return hotelList.parallelStream().filter(hotel -> hotel.getWeekDayRatesForRegular() * noOfDays == minPrice)
				.findFirst().orElse(null);

	}

	/**
	 * @param startDate
	 * @param endDate
	 * @return list of cheapest hotels of given date range
	 */
	public List<String> cheapestHotelOfBothWeekDayAndWeekendRates(String startDate, String endDate) {
		int days = getTotalDays(startDate, endDate);
		int weekends = getWeekEndDays(startDate, endDate);
		int weekdays = days - weekends;
		List<Integer> price = hotelList.stream().map(hotel -> totalPrice(hotel, weekends, weekdays))
				.collect(Collectors.toList());
		int minPrice = Collections.min(price);
		List<String> cheapestHotelList = hotelList.stream()
				.filter(hotel -> totalPrice(hotel, weekends, weekdays) == minPrice).map(hotel -> hotel.getName())
				.collect(Collectors.toList());
		for (String hotel : cheapestHotelList)
			System.out.println("Cheapest hotel: " + hotel + " cost: " + minPrice);
		return cheapestHotelList;
	}

	/**
	 * @param startDate
	 * @param endDate
	 * @return cheapest and best rated hotel for regular between given date range
	 */
	public String cheapestBestRatedHotelForRegulars(String startDate, String endDate) {
		int days = getTotalDays(startDate, endDate);
		int weekends = getWeekEndDays(startDate, endDate);
		int weekdays = days - weekends;
		List<Integer> price = hotelList.stream().map(hotel -> totalPrice(hotel, weekends, weekdays))
				.collect(Collectors.toList());
		int minPrice = Collections.min(price);
		List<Hotel> cheapestHotelList = hotelList.stream()
				.filter(hotel -> totalPrice(hotel, weekends, weekdays) == minPrice).collect(Collectors.toList());
		Hotel hotel = cheapestHotelList.stream().max(Comparator.comparing(Hotel::getRating))
				.orElseThrow(NoSuchElementException::new);
		System.out
				.println("Cheapest hotel: " + hotel.getName() + " Rating: " + hotel.getRating() + " cost: " + minPrice);
		return hotel.getName();
	}

	/**
	 * @param startDate
	 * @param endDate
	 * @return best rated hotel for regular between given date range
	 */
	public String bestRatedHotelForRegulars(String startDate, String endDate) {
		int days = getTotalDays(startDate, endDate);
		int weekends = getWeekEndDays(startDate, endDate);
		int weekdays = days - weekends;
		Hotel hotel = hotelList.stream().max(Comparator.comparing(Hotel::getRating))
				.orElseThrow(NoSuchElementException::new);
		int price = totalPrice(hotel, weekends, weekdays);
		System.out.println("Hotel: " + hotel.getName() + " ratings: " + hotel.getRating() + " cost: " + price);
		return hotel.getName();
	}

	/**
	 * @param hotel
	 * @param weekends
	 * @param weekdays
	 * @return total price of a hotel in the given date range
	 */
	public int totalPrice(Hotel hotel, int weekends, int weekdays) {
		return hotel.getWeekDayRatesForRegular() * weekdays + hotel.getWeekEndRatesForRegular() * weekends;
	}

	/**
	 * @param checkInDate
	 * @param checkOutDate
	 * @return week end days
	 */
	private int getWeekEndDays(String checkInDate, String checkOutDate) {

		int totalDays = getTotalDays(checkInDate, checkOutDate);
		int weekends = 0;

		for (int i = 0; i < totalDays; i++) {

			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
			LocalDate currentDate = LocalDate.parse(checkInDate, dateTimeFormatter);
			LocalDate date = currentDate.plusDays(i);
			DayOfWeek day = date.getDayOfWeek();
			if (day == DayOfWeek.SUNDAY || day == DayOfWeek.SATURDAY) {
				weekends++;
			}
		}
		return weekends;
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
