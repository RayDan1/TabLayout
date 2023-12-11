package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;//Seleccionar:androix.compat.widget al importar la libreria
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private iscFragment iscFragment;
    private idgdFragment idgdFragment;
    private iicFragment iicFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        iscFragment = new iscFragment();
        idgdFragment = new idgdFragment();
        iicFragment = new iicFragment();

        tabLayout.setupWithViewPager(viewPager);//(ViewPager viewPager)

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);//create inner class
        viewPagerAdapter.addFragment(iscFragment, "ISC");
        viewPagerAdapter.addFragment(idgdFragment, "IDGD");
        viewPagerAdapter.addFragment(iicFragment, "IIC");
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_isc);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_idgd);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_iic);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter{

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTile = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm, int behavior){
            super(fm,behavior);
        }
        public void addFragment(Fragment fragment, String title){
            fragments.add(fragment);
            fragmentTile.add(title);
        }

        @NonNull
        @Override
        public  Fragment getItem(int position){
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position){
            return fragmentTile.get(position);
        }
    }
}