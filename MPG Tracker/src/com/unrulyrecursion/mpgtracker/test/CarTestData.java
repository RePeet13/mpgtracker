package com.unrulyrecursion.mpgtracker.test;

import java.util.ArrayList;
import java.util.List;

import com.unrulyrecursion.mpgtracker.data.Car;

public class CarTestData {
	
	public List<Car> carTestList; 

	public CarTestData () {
		carTestList = new ArrayList<Car>();
		
		Car limpingOx = new Car("Limping Ox", 1, "Toyota", "Pick-up", 1990, "White");
		carTestList.add(limpingOx);
		Car scarletStreak = new Car("Scarlet Streak", 2, "Mitsubishi", "Eclipse", 2003, "DarkRed");
		carTestList.add(scarletStreak);
		Car lumberingElephant = new Car("Lumbering Elephant", 3, "Toyota", "Sienna", 2011, "Green");
		carTestList.add(lumberingElephant);
		Car silverBullet = new Car("Silver Bullet", 4, "Dodge", "Stratus", 1990, "Silver");
		carTestList.add(silverBullet);
		Car littleRedSportsCar = new Car("Little Red Sports Car", 5, "Mazda", "Miata", 1991, "Red");
		carTestList.add(littleRedSportsCar);
	}
}
