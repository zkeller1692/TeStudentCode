package com.techelevator.farm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {

		FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken(), new Pig() };

		Singable happyCow = new Cow();

		Singable[] singables = new Singable[] { new Cow(), new Chicken(), new Pig(), new Tractor()};

		for (Singable animal : singables) {
			String name = animal.getName();
			String sound = animal.getSound();
			String aOrAn = animal.getAOrAn();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With " + aOrAn + " " + sound + " " + sound + " here");
			System.out.println("And " + aOrAn + " " + sound + " " + sound + " there");
			System.out.println("Here " + aOrAn + " " + sound + " there " + aOrAn + " " + sound + " everywhere "
					+ aOrAn + " " + sound + " " + sound);
			System.out.println();
		}

		List<Sellable> sellables = new ArrayList<>();
		sellables.add(new Egg());
		sellables.add(new Cow());
		sellables.add(new Chicken());

		BigDecimal sum = new BigDecimal(0);
		for (Sellable sellable : sellables){
			BigDecimal price = sellable.getPrice();
			System.out.println("Price is " + price);
			sum = sum.add(price);

		}
		System.out.println("The total is " + sum);
	}
}