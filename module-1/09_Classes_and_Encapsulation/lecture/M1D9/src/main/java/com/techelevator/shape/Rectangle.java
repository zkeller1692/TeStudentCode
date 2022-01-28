package com.techelevator.shape;

public class Rectangle {
    public static final String SHAPE_NAME= "Rectangle";

    public static final int NUM_SIDES = 4;
    private static int numInstances;

    private int width;
    private  int height;

    public Rectangle(){
//        System.out.println("Default constructing a rectangle.");
//        numInstances++;
        this(0,0);//calls Rectangle (int width, int height) with zeros
    }

     public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
        numInstances++;

     }
    public void setWidth(int width){

        this.width = width;
    }

    public int getWidth(){

        return width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getHeight(){
        return height;
    }

    public int getArea(){
        return this.width * this.height;
    }

    public int getPerimeter(){
        return (this.width * 2) + (this.height *2);
    }

    public boolean isSquare(){
        return this.height == this.width;
    }
    public static int getNumInstances(){
        return numInstances;
    }
}
