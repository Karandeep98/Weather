package cz.martykan.forecastie.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

import cz.martykan.forecastie.R;
import cz.martykan.forecastie.utils.UI;

public class AboutAppActivity extends AppCompatActivity {
private String textcolor="#000000";
private String background="#ffffff";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int theme;
        setTheme(theme = UI.getTheme(PreferenceManager.getDefaultSharedPreferences(this).getString("theme", "fresh")));

        boolean darkTheme = theme == R.style.AppTheme_NoActionBar_Dark ||
                theme == R.style.AppTheme_NoActionBar_Classic_Dark;
        boolean blackTheme = theme == R.style.AppTheme_NoActionBar_Black ||
                theme == R.style.AppTheme_NoActionBar_Classic_Black;

        UI.setNavigationBarMode(AboutAppActivity.this, darkTheme, blackTheme);


        setContentView(R.layout.activity_about_app);
        setupHyperlink();
        Toolbar tb=findViewById(R.id.tb);
        setSupportActionBar(tb);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Button bt=findViewById(R.id.bt);
        bt.setOnClickListener(view -> {
            Intent i=new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:karandeep041998@gmail.com"));
            startActivity(Intent.createChooser(i,"Send Email"));
        });

if(darkTheme){
    textcolor="#ffffff";
    background="#303030";
    TextView tv=findViewById(R.id.tv);
    tv.setTextColor(Color.parseColor(textcolor));
    LinearLayout l=findViewById(R.id.aboutlayout);
    l.setBackgroundColor(Color.parseColor(background));
}
    }
    private void setupHyperlink() {
        TextView linkTextView = findViewById(R.id.tv);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
//        linkTextView.setLinkTextColor(Color.);
    }
    }

