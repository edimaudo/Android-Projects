package com.edimaudo.passwordcreator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

  /**
   * The {@link android.support.v4.view.PagerAdapter} that will provide
   * fragments for each of the sections. We use a
   * {@link FragmentPagerAdapter} derivative, which will keep every
   * loaded fragment in memory. If this becomes too memory intensive, it
   * may be best to switch to a
   * {@link android.support.v4.app.FragmentStatePagerAdapter}.
   */
  private SectionsPagerAdapter mSectionsPagerAdapter;

  /**
   * The {@link ViewPager} that will host the section contents.
   */
  private ViewPager mViewPager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    // Create the adapter that will return a fragment for each of the three
    // primary sections of the activity.
    mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

    // Set up the ViewPager with the sections adapter.
    mViewPager = (ViewPager) findViewById(R.id.container);
    mViewPager.setAdapter(mSectionsPagerAdapter);


  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }


  /**
   * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
   * one of the sections/tabs/pages.
   */
  public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      // getItem is called to instantiate the fragment for the given page.
      // Return a PlaceholderFragment (defined as a static inner class below).
      return PlaceholderFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
      // Show 3 total pages.
      return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
      switch (position) {
        case 0:
          return "SECTION 1";
        case 1:
          return "SECTION 2";
        //case 2:
        //  return "SECTION 3";
      }
      return null;
    }
  }

  /**
   * A placeholder fragment containing a simple view.
   */
  public static class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
      PlaceholderFragment fragment = new PlaceholderFragment();
      Bundle args = new Bundle();
      args.putInt(ARG_SECTION_NUMBER, sectionNumber);
      fragment.setArguments(args);
      return fragment;
    }

    //first section
    EditText userInput;
    TextView userOutput;

    //Second section
    EditText specialCharacters, numbers;
    TextView passwordOutput;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      int choice = getArguments().getInt(ARG_SECTION_NUMBER);
      View rootView = inflater.inflate(R.layout.section1, container, false);

      if (choice == 1) {
        userInput = (EditText) rootView.findViewById(R.id.userInput);
        userOutput = (TextView) rootView.findViewById(R.id.validationOutput);
        userInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
          @Override
          public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == EditorInfo.IME_ACTION_DONE) {
              validatePassword();
              return true;
            } else {
              return false;
            }
          }
        });
      } else if (choice == 2) {
        rootView = inflater.inflate(R.layout.section2, container, false);
        specialCharacters = (EditText) rootView.findViewById(R.id.specialCharacters);
        numbers = (EditText) rootView.findViewById(R.id.numbers);
        passwordOutput = (TextView) rootView.findViewById(R.id.passwordOutput);
        numbers.setOnEditorActionListener(new TextView.OnEditorActionListener() {
          @Override
          public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == EditorInfo.IME_ACTION_DONE) {
              getPassword();
              return true;
            } else {
              return false;
            }
          }
        });
        specialCharacters.setOnEditorActionListener(new TextView.OnEditorActionListener() {
          @Override
          public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == EditorInfo.IME_ACTION_DONE) {
              getPassword();
              return true;
            } else {
              return false;
            }
          }
        });

      }


      return rootView;
    }

    public void getPassword(){
      String  characterInput = specialCharacters.getText().toString();
      String numInput = numbers.getText().toString();
      boolean genPassword = true;
      //validate inputs
      if (characterInput.equals("")){
        specialCharacters.setBackgroundColor(Color.RED);
        passwordOutput.setText("Please enter a number between 1 and 5");
        genPassword = false;
      } else if (Integer.parseInt(characterInput) < 0 || Integer.parseInt(characterInput) > 5){
        specialCharacters.setBackgroundColor(Color.RED);
        passwordOutput.setText("Please enter a number between 1 and 5");
        genPassword = false;
      }

      if (numInput.equals("")){
        numbers.setBackgroundColor(Color.RED);
        passwordOutput.setText("Please enter a number between 1 and 5");
        genPassword = false;
      } else if (Integer.parseInt(numInput) < 0 || Integer.parseInt(numInput) > 5){
        numbers.setBackgroundColor(Color.RED);
        passwordOutput.setText("Please enter a number between 1 and 5");
        genPassword = false;
      }

      if(genPassword){
        specialCharacters.setBackgroundColor(Color.WHITE);
        numbers.setBackgroundColor(Color.WHITE);
        int charData = Integer.parseInt(characterInput);
        int numData = Integer.parseInt(numInput);
        final int pwdToGenerate = 5;
        StringBuilder stringInfo = new StringBuilder();
        for (int i = 0; i < pwdToGenerate;i++){
          stringInfo.append(generatePassword(charData,numData) + "\n");
        }
        passwordOutput.setText(stringInfo.toString());

      }



    }

    public String generatePassword(int charInfo,int numInfo){

      Random rand = new Random();
      int max = 20;
      int min = 8;

      int extra = charInfo + numInfo;
      int other = rand.nextInt(max - min - extra + 1) + min;
      ArrayList<String> charArraylist = new ArrayList<>();
      ArrayList<String> numArraylist = new ArrayList<>();
      ArrayList<String> letterArraylist = new ArrayList<>();
      ArrayList<String> finallist = new ArrayList<>();

      char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
      char[] num = "0123456789".toCharArray();
      char[] chars = "!@#$z%&*?_".toCharArray();

      for (int i = 0; i < charInfo;i++){
         charArraylist.add(String.valueOf(chars[rand.nextInt(chars.length)]));
      }

      for (int i = 0; i < numInfo;i++){
        numArraylist.add(String.valueOf(num[rand.nextInt(num.length)]));
      }

      for (int i = 0; i < other;i++){
        letterArraylist.add(String.valueOf(letters[rand.nextInt(letters.length)]));
      }


      finallist.addAll(charArraylist);
      finallist.addAll(numArraylist);
      finallist.addAll(letterArraylist);

      Collections.shuffle(finallist);

      StringBuilder sb = new StringBuilder();
      for (String s : finallist)
      {
        sb.append(s);
      }

      return sb.toString();
    }

    public void validatePassword() {
      String passwordData = userInput.getText().toString();
      int letterCount = 0;
      int charCount = 0;
      int lengthCount = 0;
      int numCount = 0;
      int TotalCount = 0;
      String output = "weak";


      if (passwordData.equals("")) {

      } else {
        Pattern NumberPattern = Pattern.compile("[0-9]+");
        Matcher mnp = NumberPattern.matcher(passwordData);
        Pattern charPattern = Pattern.compile("[!@#$%&*_?]+");
        Matcher mcp = charPattern.matcher(passwordData);
        Pattern letterPattern = Pattern.compile("[aA-Zz]+");
        Matcher mlp = letterPattern.matcher(passwordData);
        if (passwordData.length() >= 8) {
          lengthCount = 1;
        }

        if (mnp.find()) {
          numCount = 1;
        }

        if (mcp.find()) {
          charCount = 1;
        }

        if (mlp.find()) {
          letterCount = 1;
        }

        TotalCount = letterCount + charCount + lengthCount + numCount;

        if (TotalCount == 3) {
          output = "strong";
        } else if (TotalCount == 4) {
          output = "very strong";
        }
      }

      if (output=="weak"){
        userOutput.setText(passwordData + " is a weak password");
        userInput.setBackgroundColor(Color.RED);
      } else if (output == "strong"){
        userOutput.setText(passwordData + " is a strong password");
        userInput.setBackgroundColor(Color.YELLOW);
      } else {
        userOutput.setText(passwordData + " is a very strong password");
        userInput.setBackgroundColor(Color.GREEN);
      }

    }
  }

}







