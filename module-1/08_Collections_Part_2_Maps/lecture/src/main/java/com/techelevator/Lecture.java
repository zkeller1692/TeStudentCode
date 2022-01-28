package com.techelevator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lecture {

    public static void main(String[] args) {

        Set<String> names = new HashSet<>();
        names.add("Zach");
        names.add("Alex");
        names.add("Cameron");

        if (names.contains("Zach")) {
            System.out.println("Name contains Zach");
        }

        for (String name : names) {
            System.out.println(name);
        }

        System.out.println(names.size());

        Set<Integer> randomNums = new HashSet<>();
//		for (int i =0; i <50; ++i){
        while (randomNums.size() < 50) {
            double randDouble = Math.random();

            int randInt = (int) ((randDouble * 100) + 1);

            if (!randomNums.add(randInt)) {
                System.out.println("Didn't re-add " + randInt);
            }
        }
        System.out.println("randomNums size = " + randomNums.size());

        System.out.println("####################");
        System.out.println("        MAPS");
        System.out.println("####################");
        System.out.println();

        Map<String, String> stateAbbrevs = new HashMap<>();

        stateAbbrevs.put("OH", "Ohio");
        stateAbbrevs.put("KY", "Kentucky");
        stateAbbrevs.put("WV", "West Virginia");
        stateAbbrevs.put("HI", "Hawaii");


        String kentucky = stateAbbrevs.get("KY");
        String hawaii = stateAbbrevs.get("HI");

        if (hawaii == null) {
            System.out.println("HI not found");
        }
        System.out.println(kentucky);
        System.out.println(hawaii);

        Lecture lecture = new Lecture();
        String result = lecture.getStateName(stateAbbrevs, "HI");
        System.out.println(result);

		Set<String > stateKeys = stateAbbrevs.keySet();

		for (String stateKey: stateKeys){
			System.out.println(stateKey + " : " + stateAbbrevs.get(stateKey));
		}

		Map<Integer, String> statuses = new HashMap<>();
		statuses.put(1, "Order Received");
		statuses.put(2, "Label Printed");
		statuses.put(3, "In Transit");
		statuses.put(4, "Delivered");

        Map<String, Boolean> swJedi = new HashMap<String, Boolean>();
        swJedi.put("Luke", true);
        Boolean isLandoJedi = swJedi.get("Lando");
        System.out.println(isLandoJedi);


    }

    public String getStateName(Map<String, String> states, String stateAbbrev) {
/*        String stateName = states.get(stateAbbrev);
        if (stateName == null) {
            stateName = "Unkown";
        }*/

		if (states.containsKey(stateAbbrev)){
			return states.get(stateAbbrev);
		}else{
        return "Unknown";
    	}
	}
}
