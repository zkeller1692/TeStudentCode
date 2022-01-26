package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {

		Lecture lecture = new Lecture();
		lecture.testAutoBoxing();

		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		List<String> names = new ArrayList<>();
		names.add("Zach");
		names.add("Alex");
		names.add("Cameron");

		System.out.println(names.get(0));
		System.out.println(names);

		List<Integer> zipCodes = new ArrayList<>(Arrays.asList(45236, 45302, 45356));
		zipCodes.add(45677);
		zipCodes.add(0,45678);
		System.out.println(zipCodes);

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		System.out.println(names);
		System.out.println("Number of items in names " + names.size());

		List<String> planets = new ArrayList<>();
		planets.add("Mars");
		planets.add("Earth");
		planets.add("Venus");

		for (int i = 0; i< names.size(); i++){
			System.out.println(planets.get(i));
		}
		planets.remove(1);
		System.out.println(planets);


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		List<String> boardGames =  new ArrayList<>();
		boardGames.add("Catan");
		boardGames.add("Monopoly");
		boardGames.add("Candy Land");

		boolean foundMonopoly = lecture.doesListContin(boardGames, "Monopoly");
		if (foundMonopoly){
			System.out.println("Found Monopoly");
		}
		System.out.println(boardGames);
		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		int indexOfMonopoly = boardGames.indexOf("Monopoly");
		System.out.println(indexOfMonopoly);

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");
		String[] boardGamesAsArray = boardGames.toArray(new String[0]);


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		System.out.println("Before Sort:" + boardGames);
		Collections.sort(boardGames);
		System.out.println("After Sort:" + boardGames);


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(boardGames);
		System.out.println("Reverse:" + boardGames);

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for ( String boardgame: boardGames){
			System.out.print( boardgame + ", " );
		}

	}

	public void testAutoBoxing(){
		System.out.println("In testAutoBoxing");

		//Autoboxing
		Integer x = 5;
		Double PI= 3.4159;

		//Unboxing
		double dPI=PI;
	}

	public boolean doesListContin(List<String> listToSearch, String strToFind){
		listToSearch.add("Some string");
		boolean found= listToSearch.contains(strToFind);
		return found;
	}
}
