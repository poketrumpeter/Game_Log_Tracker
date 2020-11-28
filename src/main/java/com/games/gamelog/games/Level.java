package com.games.gamelog.games;

public class Level {

    String levelNumber;
    String completionTime;
    String score;

    public Level() {
    }

    public Level(String levelNumber, String completionTime, String score) {
        this.levelNumber = levelNumber;
        this.completionTime = completionTime;
        this.score = score;
    }

    public String getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(String levelNumber) {
        this.levelNumber = levelNumber;
    }

    public String getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
