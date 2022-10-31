public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();

        hero.move(new Fly());
        hero.move(new HorseRide());
        hero.move(new Swim());
        hero.move(new Walk());
    }
}