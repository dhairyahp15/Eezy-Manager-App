package com.example.calendar;

import android.os.Bundle;

import androidx.annotation.Nullable;

public class CalendarLight extends Calendar {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_view);
    }
}
