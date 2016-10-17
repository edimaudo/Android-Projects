import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by edima on 2016-10-16.
 */

public class circleClass extends View {
  private Paint paint;

  public circleClass(Context context) {
    super(context);

    // create the Paint and set its color
    paint = new Paint();
    paint.setColor(Color.GRAY);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    canvas.drawColor(Color.BLUE);
    canvas.drawCircle(200, 200, 100, paint);
  }
}

/*
  public void generateCircle(){

    bg = Bitmap.createBitmap(800, 800, Bitmap.Config.ARGB_8888);
    canvas = new Canvas(bg);
    //canvas.drawARGB(0,48,63,159);
    //canvas.drawColor(Color.parseColor("#303F9F"));
    //canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

    paint = new Paint();

    canvas.drawPaint(paint);

    final int RADIUS = 50;
    paint.setColor(Color.parseColor("#e82c2c"));
    Random random = new Random ();

    if (roundsLeft == 10){
      width =1000;//random.nextInt() * MAX_X_VALUE;
      height =1000;//random.nextInt() * MAX_Y_VALUE;
      canvas.drawCircle(width, height, RADIUS, paint);
    } else {
      int circlesShow = random.nextInt() + 10;
      for (int i = 0; i < circlesShow; i++){
        width =random.nextInt() * MAX_X_VALUE;
        height =random.nextInt() * MAX_Y_VALUE;
        canvas.drawCircle(width, height, RADIUS, paint);
      }
    }

    relativeLayout.setBackground(new BitmapDrawable(bg));
    relativeLayout.setBackgroundColor(Color.parseColor("#303F9F"));

  }
 */