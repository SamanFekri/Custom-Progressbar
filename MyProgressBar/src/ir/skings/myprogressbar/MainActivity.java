package ir.skings.myprogressbar;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity implements android.view.View.OnClickListener{

	private Handler progressBarHandler = new Handler();
	private ProgressBar progressbar;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		progressbar = (ProgressBar) findViewById(R.id.progressBar1);
		progressbar.setMax(1000);
		
		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(this);
	}
	
	public void start(){
		
		Toast.makeText(getApplicationContext(), "hi", 0).show();
		this.runOnUiThread(new Runnable() {
			
			int pos = 0;
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
//				while (pos < 1000) {
					pos += 10;
					progressbar.setProgress(pos);
//					try {
//						Thread.sleep(50);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
			}
		});
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		start();
		
	}
	

}