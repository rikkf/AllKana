package com.codanimex.android.allkana;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.codanimex.android.allkana.fragment.HiraganaFragment;
import com.codanimex.android.allkana.fragment.HomeFragment;
import com.codanimex.android.allkana.fragment.KatakanaFragment;
import com.codanimex.android.allkana.learn.HiraganaTab;
import com.codanimex.android.allkana.learn.KatakanaTab;

public class MainActivity extends AppCompatActivity {

    private enum NavigationFragment {
        Home,
        Hiragana,
        Katakana
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    ChangeFragment(NavigationFragment.Home);
                    return true;
                case R.id.navigation_hiragana:
                    ChangeFragment(NavigationFragment.Hiragana);
                    return true;
                case R.id.navigation_katakana:
                    ChangeFragment(NavigationFragment.Katakana);
                    return true;
            }
            return false;
        }

    };

    private void ChangeFragment(NavigationFragment value) {
        Fragment fragment = null;
        switch (value) {
            case Home:
                fragment = new HomeFragment();
                break;
            case Hiragana:
                fragment = new HiraganaFragment();
                break;
            case Katakana:
                fragment = new KatakanaFragment();
                break;
        }
        if (fragment != null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, fragment)
                    .commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);//Menu Resource, Menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.theme:
                Toast.makeText(getApplicationContext(), "Theme Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.rate:
                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                }
                return true;
            case R.id.support:
                Toast.makeText(getApplicationContext(), "Support Selected", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void onHiraganaLearnClicked(View view) {
        Intent intent = new Intent(this, HiraganaTab.class);
        startActivity(intent);
    }

    public void onKatakanaLearnClicked(View view) {
        Intent intent = new Intent(this, KatakanaTab.class);
        startActivity(intent);
    }
}
