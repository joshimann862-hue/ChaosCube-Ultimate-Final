package com.chaoscube.launcher;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Button btn = new Button(this);
        btn.setText("Launch Minecraft");
        btn.setOnClickListener(v -> {
            Toast.makeText(this, "ChaosCube Starting...", Toast.LENGTH_SHORT).show();
            // Yaha par Pojav Launcher ka engine call hoga
            try {
                File gameDir = new File(getExternalFilesDir(null), "minecraft");
                if(!gameDir.exists()) gameDir.mkdirs();
                Toast.makeText(this, "Game Dir: " + gameDir.getPath(), Toast.LENGTH_LONG).show();
                // Abhi ke liye test, next step me full launch code dunga
            } catch (Exception e) {
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        setContentView(btn);
    }
                  }
