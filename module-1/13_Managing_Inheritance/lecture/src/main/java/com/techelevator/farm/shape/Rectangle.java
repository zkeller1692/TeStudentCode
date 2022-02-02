package com.techelevator.farm.shape;

public class Rectangle extends Shape{
private int height;
private int width;
private int instanceNum;

public Rectangle(int height, int width){
    super("Rectangle");
    this.height = height;
    this.width = width;
    this.instanceNum = Shape.numInstances;
}
    @Override
    public int getArea() {
        return width * height;
    }
}
