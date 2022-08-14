package com.example.thithu1.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.thithu1.HomeFragment;
import com.example.thithu1.ViewFragment2;

public class AdapteFragment extends FragmentStateAdapter {
    public AdapteFragment(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       switch (position)
       {
           case 0:
               return new HomeFragment();
           case 1:
               return new ViewFragment2();
       }
       return new HomeFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
