package com.thoughtworks.basic;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<Frame> frames;
    private Frame currentFrame;

    public BowlingGame(List<Frame> frames, Frame currentFrame) {
        this.frames = frames;
        this.currentFrame = currentFrame;
        frames.add(currentFrame);
    }

    public void roll(int hits) {
        if(currentFrame.isEnd()){
            currentFrame = new Frame(new ArrayList<>());
            frames.add(currentFrame);
        }
        currentFrame.roll(hits);
    }

    public int getScore() {
        int total=0;
        for(int i=0;i<frames.size();i++){
            Frame f = frames.get(i);
            if(f.getScore()==10&&i<frames.size()-1){
                total+=f.getScore();
                total+=frames.get(i+1).getRolls().get(0);
            }else{
                total+=f.getScore();
            }
        }

        return total;
    }

    public boolean isEnd() {
        if (frames.size() >= 10) {
            return true;
        }
        return false;
    }

    public String showFramesScore() {

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<frames.size();i++){
            int score = frames.get(i).getScore();
            if(score==10&&i<frames.size()-1){
                score+=frames.get(i+1).getRolls().get(0);
            }
            if(i==0){
                sb.append(String.valueOf(score));
            }else{
                sb.append(String.valueOf("|"+score));
            }
        }
        return sb.toString();
    }
}
