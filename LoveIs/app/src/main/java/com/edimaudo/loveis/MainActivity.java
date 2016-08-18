package com.edimaudo.loveis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
  private String output = "Love is ...";
  private TextView loveText;
  private Button nextButton, shareButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    loveText = (TextView) findViewById(R.id.loveText);
    nextButton = (Button) findViewById(R.id.nextButton);
    shareButton = (Button) findViewById(R.id.shareButton);

    nextButton.setOnClickListener(this);
    shareButton.setOnClickListener(this);

  }

  @Override
  public void onClick(View view) {
    switch(view.getId()){
      case R.id.nextButton:
        output = generateQuote();
        loveText.setText(output);
        break;
      case R.id.shareButton:
        shareInfo();
        break;
    }
  }

  public void shareInfo(){
    Intent intentInfo = new Intent();
    intentInfo.setAction(Intent.ACTION_SEND);
    intentInfo.putExtra(Intent.EXTRA_TEXT,output);
    intentInfo.setType("text/plain");
    startActivity(intentInfo);
  }

  public String generateQuote(){
    Random rand = new Random();
    String [] quote = {"Love is ... knowing how to disguise the vegetables.",
            "Love is ... comforting away the nightmare.",
            "Love is ... what makes a chore a pleasure.",
            "Love is ... like hitting the jackpot.",
            "Love is ... getting constant cuddles.",
            "Love is ... when two hearts are better than one.",
            "Love is ... in the air!",
            "Love is ... baking his favorite pi when you're on a diet.",
            "Love is ... someone who always remembers.",
            "Love is ... a very long goodnight kiss.",
            "Love is ... the clear winner.",
            "Love is ... thinking of the best thing in your lives - each other.",
            "Love is ... when he starts noticing as you walk by.",
            "Love is ... a uniting force.",
            "Love is ... picking the right star to make your dreams come true.",
            "Love is ... two mugs together.",
            "Love is ... driving his golf cart so you can spend time with him.",
            "Love is ... a little Old-fashioned \"courting.\"",
            "Love is ... the sound of your man around the home.",
            "Love is ... when you can't wait for his text messages.",
            "Love is ... a \"must have.\"",
            "Love is ... having to go on with just a memory.",
            "Love is ... something that can tie you up in knots.",
            "Love is ... two sets of footprints in the sand.",
            "Love is ... getting his favorite song played on the radio.",
            "Love is ... finding his laugh infectious.",
            "Love is ... printing out his romantic e-mails to read later.",
            "Love is ... having the best mom in the world.",
            "Love is ... dreaming of starting a family.",
            "Love is ... when it's nice being near you.",
            "Love is ... being an indispensable part of each other's lives.",
            "Love is ... getting up to see him off before dawn.",
            "Love is ... trying to take his tie seriously!",
            "Love is ... when your relationship starts to sizzle.",
            "Love is ... making him monitor his cholesterol levels.",
            "Love is ... taking the wheel so he can enjoy the scenery.",
            "Love is ... making him take his personal alarm when he jogs at night.",
            "Love is ... something you give without strings attached.",
            "Love is ... letting the \"back seat driver\" think you're listening.",
            "Love is ... when he finally puts it in writing.",
            "Love is ... something you get back after you've given it away.",
            "Love is ... what makes you feel good about yourself.",
            "Love is ... playing golf with him when you'd rather be playing tennis.",
            "Love is ... what can cause you to miss the train.",
            "Love is ... heaven on earth.",
            "Love is ... thinking of someone else before you think of yourself.",
            "Love is ... promising not to stay more than two lips away.",
            "Love is ... the spell you cast on him.",
            "Love is ... making her feel twenty, after twenty years together.",
            "Love is ... telling him he looks sexy at sixty.",
            "Love is ... making up before you think of breaking up.",
            "Love is ... when the wait seems endless.",
            "Love is ... helping her to succeed.",
            "Love is ... sharing your wrinkle-prevention cream.",
            "Love is ... a get-well card from her.",
            "Love is ... when he won't stop sending you flowers.",
            "Love is ... hunting for her contact lens.",
            "Love is ... wearing matching pajamas.",
            "Love is ... steering your own course to happiness.",
            "Love is ... a great wave of emotion.",
            "Love is ... when even a parking ticket can't spoil your evening.",
            "Love is ... bringing them a delicious home-cooked meal.",
            "Love is ... trading compliments.",
            "Love is ... kissing al fresco.",
            "Love is ... not worrying about your chic decor!",
            "Love is ... riding close behind as he struggles with his first two-wheeler bike.",
            "Love is ... your passport to a new life together.",
            "Love is ... touching him to make sure he's not just a dream.",
            "Love is ... letting him take a snooze after dinner.",
            "Love is ... someone supportive and comforting.",
            "Love is ... wanting to be alone with him.",
            "Love is ... not leaving the paper in a mess!",
            "Love is ... when your life starts right here.",
            "Love is ... when no one else in the room seems to matter.",
            "Love is ... when your presence dazzles him.",
            "Love is ... taking your curlers out before he comes home.",
            "Love is ... bargain-hunting together.",
            "Love is ... browsing the mail-order catalogs together.",
            "Love is ... knowing how to push her buttons.",
            "Love is ... working out together.",
            "Love is ... knowing what her favorite perfume is.",
            "Love is ... knowing just how he likes his coffee.",
            "Love is ... an act of remembrance.",
            "Love is ... praying he will come home safely.",
            "Love is ... staying watchful.",
            "Love is ... seeing your future together.",
            "Love is ... giving one hundred and ten percent of yourself.",
            "Love is ... the small gestures that keep your relationship vibrant.",
            "Love is ... giving her your \"sole\" attention.",
            "Love is ... when he comes up to scratch.",
            "Love is ... when she's up front.",
            "Love is ... sharing each joy and every sorrow.",
            "Love is ... making every day a fiesta.",
            "Love is ... working out your problems together.",
            "Love is ... a change of emphasis.",
            "Love is ... giving him a lick of your ice cream.",
            "Love is ... the deliciousness of shared sleep.",
            "Love is ... stepping into his life.",
            "Love is ... helping him stick to his diet.",
            "Love is ... leaving love notes between his paperwork.",
            "Love is ... papering the wall with \"I Love You.\"",
            "Love is ... letting her sit in front of the air conditioner.",
            "Love is ... occasionally tempestuous.",
            "Love is ... sometimes being at each other's throats, but always in each other's arms.",
            "Love is ... something that can shape the world.",
            "Love is ... his infectious smile.",
            "Love is ... still being able to do your own thing.",
            "Love is ... not trying to run every minute of his life.",
            "Love is ... a chocolatey mess!",
            "Love is ... that tug at your heartstrings on his first day at school.",
            "Love is ... a safe pair of hands.",
            "Love is ... a picture of him as your screensaver.",
            "Love is ... showing up on his radar.",
            "Love is ... that moment to treasure.",
            "Love is ... a steadying hand.",
            "Love is ... not expecting too much of each other.",
            "Love is ... being met with flowers.",
            "Love is ... x-periencing the same feelings.",
            "Love is ... having his photo on your mirror.",
            "Love is ... doing his 4 a.m. Shift from him when he's ill.",
            "Love is ... sharing the housework.",
            "Love is ... feeling like a couple of adolescents.",
            "Love is ... remembering.",
            "Love is ... worrying more about him than the damaged car.",
            "Love is ... when he falls under your spell.",
            "Love is ... picking out the seeds from her watermelon.",
            "Love is ... great teamwork.",
            "Love is ... praying together.",
            "Love is ... champagne from France, chocolates from Belgium, which love from him.",
            "Love is ... looking at you, kid!",
            "Love is ... when every little silence hurts.",
            "Love is ... when he's always there for you.",
            "Love is ... jumping to conclusions!",
            "Love is ... like quicksilver in your hands.",
            "Love is ... someone you want to be tied to.",
            "Love is ... trying to grind your teeth quietly at night.",
            "Love is ... when he invites you over for a dinner he's cooked.",
            "Love is ... when you trigger the \"wow\" factor.",
            "Love is ... being spoiled rotten!",
            "Love is ... hoping you'll always be as happy as they are!",
            "Love is ... when you can't stop your heart from going with him.",
            "Love is ... an anniversary dinner.",
            "Love is ... holding on tight.",
            "Love is ... making him a marked man.",
            "Love is ... awakening your sleeping beauty with a kiss.",
            "Love is ... an evening together to remember.",
            "Love is ... when he steps into your dreams.",
            "Love is ... not saying \"I told you so!\"",
            "Love is ... meeting same place, same time, every day.",
            "Love is ... when his presence is like a ray of sunshine.",
            "Love is ... someone to share things with.",
            "Love is ... caring.",
            "Love is ... not just someone you want to be with, but someone you can't bear to be without!",
            "Love is ... when you can see he's putting his heart into it.",
            "Love is ... her familiar cold feet!",
            "Love is ... when you're smiling on the inside as well.",
            "Love is ... not caring if the fish don't bite.",
            "Love is ... when there's no distance between your hearts, wherever you are.",
            "Love is ... feeling the feelings you hope he's feeling.",
            "Love is ... delicate, even talking about it can change it forever.",
            "Love is ... when you think about someone even when they are not around you. And simple everyday things trigger recollections of when you were together",
            "Love is ...  the knowing commitment & duties that are needed to be performed when the time comes for your specific loved one.",
            "Love is ...  sweet and addictive.",
            "Love is ... , that is an unconditional attachment to someone but have never been in love personally.",
            "Love is ...  the ultimate freedom of choice to attach and invest.",
            "Love is ...  sweet addiction that penetrates deep inside that depth of uncertainty.",
            "Love is ...  like Ash and Pikachu --unconditionally and always having the other person's back.",
            "Love is ...  a buffet for life for both partners.",
            "Love is ...  both amazing and scary, yet it's one of the greatest feelings you can go through.",
            "Love is ...  positive thinking or vibration or energy of everyone's inner feeling.",
            "Love is ...  essential, a basic necessity, like water--we need it and we give it away to sustain life",
            "Love is ...  is being empathetic to people everyday.",
            "Love is ...  an emotional, spiritual connection with someone. Hard to find, but it is possible.",
            "Love is ...  just as thick as bacon!!! ;)",
            "Love is ...  allowing yourself to be vulnerable.",
            "Love is ...  a bitch.",
            "Love is ...  being in a healthy committed relationship built on honesty, trust and mutual respect for each other.",
            "Love is ...  like a breath, it comes and goes",
            "Love is ...  immesuarable and irreplaceable",
            "Love is ...  hard to find these days",
            "Love is ...  like a rose petal, beautiful and vibrant in colour,soft and delicate like a serving of desert that can't be finished no matter how you try, but who would want to finish it cause it's beautiful.",
            "Love is ...  feeling comfortable being with someone and feeling used to as well."};
    return quote[rand.nextInt(quote.length)];
  }
}
