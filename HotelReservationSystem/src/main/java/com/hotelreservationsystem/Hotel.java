package com.hotelreservationsystem;

public class Hotel {

	private String name;
	private int weekDayRatesForRegular;
	private int weekEndRatesForRegular;
	int weekDayRatesForRewards;
	int weekEndRatesForRewards;
	private int rating;

	/**
	 * @param name
	 * @param weekDayRatesForRegular
	 * @param weekEndRatesForRegular
	 * @param weekDayRatesForRewards
	 * @param weekEndRatesForRewards
	 * @param rating
	 */
	public Hotel(String name, int weekDayRatesForRegular, int weekEndRatesForRegular, int weekDayRatesForRewards,
			int weekEndRatesForRewards, int rating) {
		super();
		this.name = name;
		this.weekDayRatesForRegular = weekDayRatesForRegular;
		this.weekEndRatesForRegular = weekEndRatesForRegular;
		this.weekDayRatesForRewards = weekDayRatesForRewards;
		this.weekEndRatesForRewards = weekEndRatesForRewards;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeekDayRatesForRegular() {
		return weekDayRatesForRegular;
	}

	public void setWeekDayRatesForRegular(int weekDayRates) {
		this.weekDayRatesForRegular = weekDayRates;
	}

	public int getWeekEndRatesForRegular() {
		return weekEndRatesForRegular;
	}

	public void setWeekEndRatesForRegular(int weekEndRatesForRegular) {
		this.weekEndRatesForRegular = weekEndRatesForRegular;
	}

	public int getWeekDayRatesForRewards() {
		return weekDayRatesForRewards;
	}

	public void setWeekDayRatesForRewards(int weekDayRatesForRewards) {
		this.weekDayRatesForRewards = weekDayRatesForRewards;
	}

	public int getWeekEndRatesForRewards() {
		return weekEndRatesForRewards;
	}

	public void setWeekEndRatesForRewards(int weekEndRatesForRewards) {
		this.weekEndRatesForRewards = weekEndRatesForRewards;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
