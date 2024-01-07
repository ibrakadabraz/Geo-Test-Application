package com.example.quiz.quizapp;
import android.graphics.Color;
/**
 * Created by Sushant on 23-11-2016.
 */
import java.util.Random;
public class BackgroundColor {
    private String[] mColors = {
            "#b7c0c7" // light gray}
    };
public int getColor(){
    //Randomly generate a color
    String color;
    Random randomGenerator = new Random();
    int randomNumber = randomGenerator.nextInt(mColors.length);
    color = mColors[randomNumber];
    int colorAsInt;
    colorAsInt = Color.parseColor(color);
    return colorAsInt;
}
}
