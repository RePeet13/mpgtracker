package com.unrulyrecursion.mpgtracker.test;

import java.util.ArrayList;
import java.util.List;

import com.unrulyrecursion.mpgtracker.data.Car;

public class CarTestData {
	
	public List<Car> carTestList;
	public Car[] carTestArray;

	public CarTestData () {
		carTestList = new ArrayList<Car>();
		
		Car limpingOx = new Car("Limping Ox", "White", "Toyota", "Pick-up", 1990);
		carTestList.add(limpingOx);
		Car scarletStreak = new Car("Scarlet Streak", "DarkRed", "Mitsubishi", "Eclipse", 2003);
		carTestList.add(scarletStreak);
		Car lumberingElephant = new Car("Lumbering Elephant", "Green", "Toyota", "Sienna", 2011);
		carTestList.add(lumberingElephant);
		Car silverBullet = new Car("Silver Bullet", "Silver", "Dodge", "Stratus", 1990);
		carTestList.add(silverBullet);
		Car littleRedSportsCar = new Car("Little Red Sports Car", "Red", "Mazda", "Miata", 1991);
		carTestList.add(littleRedSportsCar);
		

		carTestArray = new Car[] {limpingOx, scarletStreak, lumberingElephant, silverBullet, littleRedSportsCar};
	}
}
