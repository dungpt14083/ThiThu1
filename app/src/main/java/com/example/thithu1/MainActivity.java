package com.example.thithu1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.thithu1.Adapter.AdapteFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout2;
    ViewPager2 viewPager2;
    AdapteFragment adapteFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout2 = findViewById(R.id.tablayout);
        viewPager2 = findViewById(R.id.viewpager2);
        FragmentManager fragmentManager = getSupportFragmentManager();
        adapteFragment = new AdapteFragment(fragmentManager,getLifecycle());
        viewPager2.setAdapter(adapteFragment);
        tabLayout2.addTab(tabLayout2.newTab().setText("Home"));
        tabLayout2.addTab(tabLayout2.newTab().setText("Contact"));
        tabLayout2.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout2.selectTab(tabLayout2.getTabAt(position));
            }
        });


    }
}