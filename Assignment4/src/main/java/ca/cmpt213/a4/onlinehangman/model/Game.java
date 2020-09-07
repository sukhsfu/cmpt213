package ca.cmpt213.a4.onlinehangman.model;

public class Game {
    public enum Status {Active,Won,Loss};
    private Status status;
    private String progress;

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    private long id;
    private String word;
    private int totalGuesses;
    private String guess;

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    private int wrongGuesses;
    public  Game(){

    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getTotalGuesses() {
        return totalGuesses;
    }

    public void setTotalGuesses(int totalGuesses) {
        this.totalGuesses = totalGuesses;
    }

    public int getWrongGuesses() {
        return wrongGuesses;
    }

    public void setWrongGuesses(int wrongGuesses) {
        this.wrongGuesses = wrongGuesses;
    }
}
