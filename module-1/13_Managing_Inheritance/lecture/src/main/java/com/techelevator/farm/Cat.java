package com.techelevator.farm;

public class Cat extends FarmAnimal{

    public Cat(){
        super("Cat", "Meow!");
    }

    @Override
    public String getFavoriteFood() {
        return "Tuna";
    }

//    @Override
//    public String getSound(){
//        return "Meow!";
//    }


}
