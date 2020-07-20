package com.thoughtworks.basic;

import java.util.List;

public class Frame {
    private List<Integer> rolls;

    public Frame(List<Integer> rolls) {
        this.rolls = rolls;
    }

    public List<Integer> getRolls() {
        return rolls;
    }

    public void roll(int hits) {
        rolls.add(new Integer(hits));
    }

    public int getScore() {
        int total = 0;
        for (Integer score : rolls) {
            total += score;
        }
        return total;
    }

    public boolean isEnd() {
        if (rolls.size() >= 2) {
            return true;
        }
        return false;
    }
}
