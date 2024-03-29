package sample.game;

import java.io.Serializable;

public abstract class Unit implements Serializable {
    private String name;
    private int health;
    private double positionX;
    private double positionY;
    private int rowNum;

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
//        if (posY < 99)
//            this.rowNum = 1;
//        else if (posY < 169)
//            this.rowNum = 2;
//        else if (posY < 230)
//            this.rowNum = 3;
//        else if (posY < 299)
//            this.rowNum = 4;
//        else
//            this.rowNum = 5;
    }

    public int getHealth() {
        return health;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

}

