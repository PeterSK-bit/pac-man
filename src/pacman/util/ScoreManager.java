package pacman.util;

public class ScoreManager {
    private final int startScore;
    private int score;
    private final int startLives;
    private int lives;

    public ScoreManager() {
        this.startScore = 0;
        this.score = 0;
        this.startLives = 0;
        this.lives = 3;
    }

    public ScoreManager(int score, int lives) {
        this.startScore = score;
        this.score = score;
        this.startLives = lives;
        this.lives = lives;
    }

    // todo find exact values
    public void addDotPoints() {
        this.score++;
    }

    public void addPowerPelletPoints() {
        this.score += 10;
    }

    public void reset()  {
        this.score = this.startScore;
        this.lives = this.startLives;
    }

    public int getScore() {
        return this.score;
    }
}
