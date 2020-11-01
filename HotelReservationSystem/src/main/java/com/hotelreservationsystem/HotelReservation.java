package com.hotelreservationsystem;

import java.util.ArrayList;
import java.util.List;

public class HotelReservation {

	public static void main(String[] args) {
		System.out.println("Welcome To Hotel Reservation Program");

		Hotel LakeWood = new Hotel("Lakewood", 110);
		Hotel BridgeWood = new Hotel("Bridgewood", 160);
		Hotel RidgeWood = new Hotel("Ridgewood", 220);

		List<Hotel> hotelList = new ArrayList<Hotel>();
		hotelList.add(LakeWood);
		hotelList.add(BridgeWood);
		hotelList.add(RidgeWood);

	}
}
