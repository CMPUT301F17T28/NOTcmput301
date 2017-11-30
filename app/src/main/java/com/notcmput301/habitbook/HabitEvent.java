package com.notcmput301.habitbook;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.media.Image;
import android.util.Base64;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Cole on 2017-10-20.
 */

public class HabitEvent {

    //private HabitType habitType;
    private String habit;
    private String comment;
    private String image;
    private Date date;
    private int likes;
    private int dislikes;
    private Location location;

    public HabitEvent(String habit,String comment, String image){
        this.habit = habit;
        this.comment = comment;
        this.image = image;
        this.date = new Date();
        this.likes = 0;
        this.dislikes = 0;
        this.location = null;
    }

    public HabitEvent(String habit,String comment, String image, Location location){
        this.habit = habit;
        this.comment = comment;
        this.image = image;
        this.date = new Date();
        this.likes = 0;
        this.dislikes = 0;
        this.location = location;
    }


    public void setHabit(String habit){
        this.habit = habit;
    }

    public String getHabit(){
        return habit;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date creationDate) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Bitmap imageToBitmap(){
        byte[] decodedString = Base64.decode(image, Base64.DEFAULT);
        return  BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (o instanceof  HabitEvent){
            HabitEvent test = (HabitEvent) o;
            if ( this.comment.equals(test.getComment())
                    && this.image.equals(test.getImage()) &&  this.date.equals(test.getDate()) &&
                    this.likes == test.getLikes() && this.dislikes == test.getDislikes() &&
                    this.location.equals(test.getLocation())) return true; }
        return false;
    }*/

    @Override
    public String toString(){
        return this.comment;
    }
}
