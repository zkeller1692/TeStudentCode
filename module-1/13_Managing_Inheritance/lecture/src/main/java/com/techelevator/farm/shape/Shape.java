package com.techelevator.farm.shape;

public abstract class Shape {

    private String name;

 protected static int numInstances = 0;

    public Shape(String name){
        numInstances ++;

        this.name = name;
    }

    public String getName(){
        return name;
    }
    public abstract int getArea();
}
