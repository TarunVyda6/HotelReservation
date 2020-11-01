package com.hotelreservationsystem;

public class Hotel {

	private String name;
	private int weekDayRatesForRegular;

	/**
	 * @param name
	 * @param weekDayRatesForRegular
	 */
	public Hotel(String name, int weekDayRatesForRegular) {
		super();
		this.name = name;
		this.weekDayRatesForRegular = weekDayRatesForRegular;
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

}
