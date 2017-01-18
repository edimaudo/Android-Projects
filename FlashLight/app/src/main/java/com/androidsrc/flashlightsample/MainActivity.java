package com.androidsrc.flashlightsample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	private Camera camera;
	private Camera.Parameters parameters;
	private ImageButton flashLightButton;
	boolean isFlashLightOn = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		flashLightButton = (ImageButton)findViewById(R.id.flashlight_button);
		flashLightButton.setOnClickListener(new FlashOnOffListener());
		
		if (isFlashSupported()) {
			camera = Camera.open();
			parameters = camera.getParameters();
		} else {
			showNoFlashAlert();
		}
	}
	
	private class FlashOnOffListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			if(isFlashLightOn){
				flashLightButton.setImageResource(R.drawable.flashlight_off);
				parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
				camera.setParameters(parameters);
				camera.stopPreview();
				isFlashLightOn = false;
			}else{
				flashLightButton.setImageResource(R.drawable.flashlight_on);
				parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
				camera.setParameters(parameters);
				camera.startPreview();
				isFlashLightOn = true;
			}
			
		}
		
	}

	private void showNoFlashAlert() {
		new AlertDialog.Builder(this)
				.setMessage("Your device hardware does not support flashlight!")
				.setIcon(android.R.drawable.ic_dialog_alert).setTitle("Error")
				.setPositiveButton("Ok", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						finish();
					}
				}).show();
	}

	private boolean isFlashSupported() {
		PackageManager pm = getPackageManager();
		return pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
	}
	
	@Override
	protected void onDestroy() {
		if(camera != null){
			camera.stopPreview();
			camera.release();
			camera = null;
		}
		super.onDestroy();
	}

}
