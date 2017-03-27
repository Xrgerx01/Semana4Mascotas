package com.zyxdimensions.petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.zyxdimensions.petagram.adapters.PageAdapter;
import com.zyxdimensions.petagram.fragments.ListadoMascotas;
import com.zyxdimensions.petagram.fragments.PerfilMascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId()){
            case R.id.mStar:
                intent = new Intent(MainActivity.this, MascotasRaiting.class);
                startActivity(intent);
                break;
            case R.id.mContacto:
                intent = new Intent(MainActivity.this, Contacto.class);
                startActivity(intent);
                break;
            case R.id.mAcercaDe:
                intent = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    private ArrayList<Fragment> agregarFragments(){
      ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ListadoMascotas());
        fragments.add(new PerfilMascota());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.dog_house_48);
        tabLayout.getTabAt(1).setIcon(R.drawable.in_love_48);
    }
}
