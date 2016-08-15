package com.edimaudo.presentvaluecalculator;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private Toolbar toolbar;
  private TabLayout tabLayout;
  private ViewPager viewPager;

  //basic
  private TextInputLayout input_basic_interest,input_basic_years,input_basic_revenue;
  private EditText basic_interest,basic_years,basic_revenue;
  private Button basic_submit;

  //constant growth
  private TextInputLayout input_constant_growth_growth_rate,input_constant_growth_interest,
          input_constant_growth_num_years;
  private EditText constant_growth_revenue,constant_growth_interest,constant_growth_growth_rate, constant_growth_num_years;
  private Button constant_growth_submit;

  //offset growth
  private TextInputLayout input_offset_growth_interest, input_offset_growth_growth_rate,
          input_offset_growth_revenue, input_offset_growth_tot_years,
          input_offset_growth_years_no_revenue;
  private EditText offset_growth_interest, offset_growth_growth_rate, offset_growth_revenue,
          offset_growth_tot_years, offset_growth_years_no_revenue;
  private Button offset_growth_submit;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    toolbar = (Toolbar) findViewById(R.id.toolbar);
    //setSupportActionBar(toolbar);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    viewPager = (ViewPager) findViewById(R.id.viewpager);
    setupViewPager(viewPager);

    tabLayout = (TabLayout) findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(viewPager);




  }

  public void setupViewPager(ViewPager viewPager){
    ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
    adapter.addFragment(new Basic(), "Basic");
    adapter.addFragment(new ConstantGrowth(), "Constant Growth");
    adapter.addFragment(new OffsetGrowth(), "Offset Growth");
    viewPager.setAdapter(adapter);

    Log.i("Check",String.valueOf(viewPager.getCurrentItem()));
    Log.i("Check",String.valueOf(viewPager.toString()));
    Log.i("Check",String.valueOf(viewPager.getId()));


  }



  class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
      super(manager);
    }

    @Override
    public Fragment getItem(int position) {
      return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
      return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
      mFragmentList.add(fragment);
      mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return mFragmentTitleList.get(position);
    }
  }

}
