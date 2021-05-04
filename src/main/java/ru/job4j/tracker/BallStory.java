package ru.job4j.tracker;

public class BallStory {
    public static class Ball {
        public void tryEat(Ball ball) {
        }
    }

   public static class Hare {
       public void tryEat(Ball ball) {
       }
   }

    public static  class Wolf {
        public void tryEat(Ball ball) {
        }
    }

    public static class Fox {
        public void tryEat(Ball ball) {
        }
    }

    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();

        ball.tryEat(ball);
        hare.tryEat(ball);
        wolf.tryEat(ball);
        fox.tryEat(ball);
    }
}
