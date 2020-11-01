package com.hotelreservationsystem;

public class Hotel {

	private String name;
	private int weekDayRatesForRegular;
	private int weekEndRatesForRegular;

	/**
	 * @param name
	 * @param weekDayRatesForRegular
	 */
	public Hotel(String name, int weekDayRatesForRegular, int weekEndRatesForRegular) {
		super();
		this.name = name;
		this.weekDayRatesForRegular = weekDayRatesForRegular;
		this.weekEndRatesForRegular = weekEndRatesForRegular;
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

}
