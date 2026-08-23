package com.chaoscube.ultimate;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String selectedVersion = "1.21.1";
    int selectedRam = 2048;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScrollView scroll = new ScrollView(this);
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(40,40,40,40);
        root.setBackgroundColor(Color.parseColor("#0B0B12"));
        scroll.addView(root);
        setContentView(scroll);

        TextView title = new TextView(this);
        title.setText("CHAOS CUBE ULTIMATE");
        title.setTextColor(Color.WHITE);
        title.setTextSize(24f);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        root.addView(title);

        TextView vLabel = new TextView(this);
        vLabel.setText("Select Version:");
        vLabel.setTextColor(Color.WHITE);
        vLabel.setPadding(0,30,0,10);
        root.addView(vLabel);

        String[] versions = {"26.2 (NEW)", "26.1", "1.21.1", "1.20.1", "1.8.9"};
        Spinner verSpin = new Spinner(this);
        verSpin.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, versions));
        root.addView(verSpin);

        TextView ramLabel = new TextView(this);
        ramLabel.setText("RAM: 2048 MB (Recommended)");
        ramLabel.setTextColor(Color.WHITE);
        ramLabel.setPadding(0,50,0,10);
        root.addView(ramLabel);

        SeekBar ramSeek = new SeekBar(this);
        ramSeek.setMax(3);
        ramSeek.setProgress(1);
        root.addView(ramSeek);

        ramSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar s, int p, boolean b) {
                int[] rams = {1024, 2048, 4096, 6144};
                selectedRam = rams[p];
                ramLabel.setText("RAM: " + selectedRam + " MB");
            }
            public void onStartTrackingTouch(SeekBar s) {}
            public void onStopTrackingTouch(SeekBar s) {}
        });

        Button launchBtn = new Button(this);
        launchBtn.setText("LAUNCH GAME");
        launchBtn.setBackgroundColor(Color.parseColor("#00FF88"));
        root.addView(launchBtn);

        launchBtn.setOnClickListener(v -> {
            Toast.makeText(this, "Launching " + selectedVersion + " with " + selectedRam + "MB", Toast.LENGTH_LONG).show();
        });
    }
  }
