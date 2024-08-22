public class Juego {
    public int lives;
    public Juego(int lives) {
        this.lives = lives;
    }
    public void showRemainingLives(){
        System.out.println("Vidas restantes: " + this.lives);
    }
}
