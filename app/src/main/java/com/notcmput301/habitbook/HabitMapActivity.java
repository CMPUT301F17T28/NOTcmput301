package com.notcmput301.habitbook;

import android.graphics.drawable.shapes.Shape;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class HabitMapActivity extends AppCompatActivity {
    private User loggedInUser;
    private ArrayList<HabitEvent> events;
    private TextView habitMapTitle;
    private ImageView map; //ImageView only temp class,
                           //likely use diff class in final vers
    private ToggleButton highlightHabits;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_map);
    }


}
