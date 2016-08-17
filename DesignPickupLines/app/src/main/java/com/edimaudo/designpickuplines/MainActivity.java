package com.edimaudo.designpickuplines;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private Button nextButton, shareButton;
  private TextView pickupText;
  private String output = "How you doin\\'? ;)";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    nextButton = (Button) findViewById(R.id.nextButton);
    shareButton = (Button) findViewById(R.id.shareButton);
    pickupText = (TextView) findViewById(R.id.pickupText);
    shareButton.setOnClickListener(this);
    nextButton.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()){
      case R.id.nextButton:
        output = randomQuote();
        pickupText.setText(output);
      break;
      case R.id.shareButton:
        shareInfo();
      break;
    }
  }

  public void shareInfo(){
    Intent sendIntent = new Intent();
    sendIntent.setAction(Intent.ACTION_SEND);
    sendIntent.putExtra(Intent.EXTRA_TEXT, output);
    sendIntent.setType("text/plain");
    startActivity(sendIntent);

  }

  public String randomQuote(){
    Random rand = new Random();
    String [] pickupLines = {"You look perfectly put together. Do you display this well in IE?",
            "I dig your look and feel.",
            "If you like what you see now, wait until you look below the fold.",
            "Mind if I take you for a usability test?",
            "I like my fonts sans-serif and you sans-pants.",
            "Are you helvetica? Because you are beautiful and extremely versatile.",
            "How do you like your coffee in the morning? I like mine #000000.",
            "I only handle the front-end but I know a good developer who can do your back-end.",
            "Can I examine your pixels?",
            "You're the CSS to my HTML.",
            "Are you Garamond? Because you are easy on the eyes.",
            "You must be italic because you're looking pretty elegant right now.",
            "That x-height of yours is lookin' mighty fine.",
            "That form definitely follows function.",
            "Am I seeing you through a retina display? Because you are absolutely stunning.",
            "Have you been working out? You're looking pretty condensed.",
            "Were you designed by Paul Renner? Because you look like you're from the futura.",
            "I don't need to apply the golden ratio to you, I already know you're perfect.",
            "You're just my type.",
            "Let's delete a few layers.",
            "I'd like to reduce our kerning to 0.",
            "Let's go back to my place and kern.",
            "You're like a 300 dpi file, I'm willing to wait for you.",
            "How would you like to lorem ipsum dolor sit on my lap?",
            "I could see us together in the futura.",
            "I've got just the right thing to fill up that negative space.",
            "I wouldn't mind horizontally distributing space with you.",
            "Can I smooth out those bezier curves of yours?",
            "Let's make history, baby.",
            "I want to wrap my lasso around you.",
            "Your pixel density is so tight.",
            "I don't need a magic wand, you fit perfectly.",
            "I wouldn't want to smudge that pretty face of yours.",
            "Even if you're 72 dpi, you're worth it.",
            "I don't letterspace black letter, but I wouldn't mind shagging you.",
            "You've got great assets.",
            "Your site structure is great.",
            "Your SASS is so neat.",
            "I can't wait to take you to print.",
            "How about we go back to my place and make some glyphs?",
            "I'd love to leave a kiss impression on you.",
            "You are almost as beautiful as Ikea.",
            "You must be swiss, you were perfectly designed.",
            "I want to CMD+S you all day long.",
            "I'm dying to get my hands on your touch sensitive device.",
            "You CTRL my heart, baby.",
            "Let's dim our screens down together.",
            "I'd power down my Mac for you.",
            "I won't force quit you.",
            "You've got such a nice glyph set.",
            "You auto-complete me.",
            "Can you copy and paste next to me?",
            "You deserve to be seen in full screen.",
            "Even if you were a 144p video, I'd give you time.",
            "Honey, you're perfectly aligned to my grid.",
            "I'd always respond to your emails.",
            "Your stylesheet cascades beautifully.",
            "If you were an update, I wouldn't put you off until later.",
            "I hear you like divs, mine's huge.",
            "Now that's a Kickstarter I can get behind.",
            "Haven't I worked on your file before?",
            "Will you be my final version?",
            "Let's go into the cloud together.",
            "Float on over this way, baby.",
            "I'd retweet anything you want me to.",
            "Let's make this Facebook official.",
            "You're just as beautiful without an Instagram filter.",
            "This post is all for you.",
            "I'd love to be in your profile picture.",
            "If MySpace was still a thing, you'd be in my top 8.",
            "All the heart emojis in the world can't express my love for you.",
            "I wish you were absolute positioned near me forever.",
            "You know just the right UX for me.",
            "If you were an app, I'd never shut you down.",
            "Can I analyze those features?",
            "Let's sync our devices, baby.",
            "I'd love to give you a private critique.",
            "Wow, you print out so perfectly.",
            "I can't take it, you're just so well designed.",
            "Haven't I seen your design talk before?",
            "Man, your web presence is so great.",
            "I'd let you touch my screen as much you want.",
            "Wow, even your photoshop file is organized nicely.",
            "Your name is already lettered on my Moleskine.",
            "Let's go to a coffee shop to work together.",
            "Are we 3rd connections on LinkedIn? I think we should get a little closer.",
            "That Medium article you wrote is phenomenal.",
            "I'd buy your Etsy prints.",
            "How many brushstrokes does it take for us to get together?",
            "That pattern on your dress is so seamless.",
            "I'd love to be in your closed beta.",
            "I'd match your eyes to a Pantone color, but there isn't a color for amazing yet.",
            "If you were a repository, I'd commit to you all day long.",
            "We're like git branches, we need to merge together.",
            "Extend that line height for me, baby.",
            "Your kerning is so tight.",
            "You won't have to do any revisions on me.",
            "If you were a stock photo, I'd buy the exclusive rights-managed license.",
            "I'd pursue you more persistently than the Adobe Reader updates.",
            "You and I should group our layers together.",
            "I'll be your passion project.",
            "If I said you had a great <body> would you let me work on it?",
            "I'd buy your Cotton Bureau shirt, any day.",
            "My server's always up for you, baby.",
            "I like my code like I like my dates, Sassy.",
            "I'll be positioned top and you can be positioned bottom.",
            "You and I should start a studio together.",
            "You've definitely got some nice elements.",
            "I know just where I'd put my selectors.",
            "Let's set our transparency to 1.",
            "You and I would make a great ligature together.",
            "You design my love.",
            "Oh baby, you make me say #000000",
            "I'd like to export your file right to my bed.",
            "Our workflow could be seamless.",
            "I wouldn't have any commit conflicts with you.",
            "Let me give you a sample of my magic wand.",
            "Baby, you're so !IMPORTANT, you're hard to ignore.",
            "You turn my sans serif into a slab serif.",
            "Let's clear both of our schedules.",
            "Iâ€™d like to drop my descender below your baseline.",
            "You've spot-healed my heart.",
            "I'd like to unhide all those layers.",
            "Can I have the password to your wifi?",
            "Are you a git repository? Because I'm checking you out",
            "I'm clean on the web but dirty in the sketchbook.",
            "You and I could cowork together.",
            "I don't need a clearfix at all, but let me check out those margins.",
            "Your proofs look great, I'd love to approve them.",
            "My inspiration folder is just pictures of you.",
            "I can think of some user tests I'd do on you.",
            "I'd like to do you ad-agency style: all night long for weeks on end.",
            "I'd like to pick you up with my magic wand.",
            "Your <body> is bangin', but I'd love to know what's in your <head>.",
            "Baby, I'll make an Impact on you.",
            "My life/work balance would be 100% you.",
            "These analytics say all of my traffic is to you.",
            "How about we go back to my place and look at each other's meta tags?",
            "I wish I had you all over my art board.",
            "I'd give you infinite rounds of revisions.",
            "You're like my favorite font, I never get tired of seeing you.",
            "You're so pretty, it's driving me dingbats.",
            "I'd hang a photo of you next to all of my favorite posters.",
            "You're so perfect, I don't even have to debug you.",
            "I'd need a lot of pica poles to measure my love for you.",
            "My second screen is devoted to you.",
            "I'd love you even if you used comic sans once.",
            "Print for me, baby.",
            "I'd never use shorthand hex codes on you.",
            "You're as elegant as a script typeface.",
            "Is that a T-square in your pocket or are you just happy to see me?",
            "I wouldnâ€™t mind curating something for you.",
            "I'd export you at high res.",
            "Your pixels per inch is astounding.",
            "Can I join your font family?",
            "Our workflow could be seamless.",
            "We could match our swatches.",
            "You fit right into my color palette.",
            "I'd pull an all nighter to work on you."};
    return pickupLines[rand.nextInt(pickupLines.length)];
  }
}
