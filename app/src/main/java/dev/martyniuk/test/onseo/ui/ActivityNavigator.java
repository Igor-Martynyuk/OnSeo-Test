package dev.martyniuk.test.onseo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import dev.martyniuk.test.onseo.R;

public class ActivityNavigator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_navigator);
    }
}
