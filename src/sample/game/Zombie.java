package sample.game;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.GameController;

public abstract class Zombie extends Unit {
    private int speed;
    private int biteDamage;
    private int timeBeforeNextZombie;
    private transient ImageView imageView;
    public transient Timeline timeline;
    static int counter = 0;

    Zombie(String name, int health, int speed, int timeBeforeNextZombie, int posX, int posY, int rowNum) {
        this.setBiteDamage(1);
        this.setTimeBeforeNextZombie(timeBeforeNextZombie);
        this.setName(name);
        this.setHealth(health);
        this.setSpeed(speed);
        this.setPositionX(posX);
        this.setPositionY(posY);
        this.setRowNum(rowNum);
        this.setImageView(new ImageView());

        if (this instanceof NormalZombie) {
            this.getImageView().setImage(new Image("resources/zombie_normal.gif"));
            this.getImageView().setFitWidth(50);
            this.getImageView().setFitHeight(70);
            this.getImageView().setTranslateY(20);
        }

        else if (this instanceof FootballZombie) {
            this.getImageView().setImage(new Image("resources/zombie_football.gif"));
            this.getImageView().setFitWidth(50);
            this.getImageView().setFitHeight(60);
            this.getImageView().setTranslateY(30);
//            setRowNum(getRowNum() + 1);

        }

        else if (this instanceof ConeheadZombie) {
            this.getImageView().setImage(new Image("resources/zombie_newspaper.gif"));
            this.getImageView().setFitWidth(100);
            this.getImageView().setFitHeight(60);
            this.getImageView().setTranslateY(30);
        }

//        this.getImageView().setFitWidth(56);
//        this.getImageView().setFitHeight(99);
    }

    public void move() {
        this.getImageView().setLayoutX(this.getImageView().getLayoutX() - this.getSpeed());
        this.setPositionX(this.getImageView().getLayoutX());
    }

    public void kill(Game game) {
        game.listOfWalkingZombies.remove(this);
        timeline.stop();
        this.getImageView().setLayoutX(-1000);
    }

    public int bite(Plant plant) {
        plant.setHealth(plant.getHealth() - this.getBiteDamage());

        if (plant.getHealth() <= 0) {
            return -1;
        }

        else {
            return 0;
        }
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getBiteDamage() {
        return biteDamage;
    }

    public void setBiteDamage(int biteDamage) {
        this.biteDamage = biteDamage;
    }

    public int getTimeBeforeNextZombie() {
        return timeBeforeNextZombie;
    }

    public void setTimeBeforeNextZombie(int timeBeforeNextZombie) {
        this.timeBeforeNextZombie = timeBeforeNextZombie;
    }
}

class NormalZombie extends Zombie {
    NormalZombie(String name, int health, int speed, int timeBeforeNextZombie, int posX, int posY, int rowNum) {
        super(name, health, speed, timeBeforeNextZombie, posX, posY, rowNum);
    }
}

class FootballZombie extends Zombie {
    FootballZombie(String name, int health, int speed, int timeBeforeNextZombie, int posX, int posY, int rowNum) {
        super(name, health, speed, timeBeforeNextZombie, posX, posY, rowNum);
    }
}

class ConeheadZombie extends Zombie{
    ConeheadZombie(String name, int health, int speed, int timeBeforeNextZombie, int posX, int posY, int rowNum) {
        super(name, health, speed, timeBeforeNextZombie, posX, posY, rowNum);
    }
}


