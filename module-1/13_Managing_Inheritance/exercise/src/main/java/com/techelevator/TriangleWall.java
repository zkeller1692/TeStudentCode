package com.techelevator;

public class TriangleWall extends Wall {
    private int base;
    private int height;

    public TriangleWall(String name, String color, int base, int height){
        super(name, color);
        this.base = base;
        this.height = height;
    }

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int getArea() {
        return (base * height)/2;
    }
    public String toString(){
        return getName() + " (" + base + "x" + height + ") " + "triangle";
    }
}
