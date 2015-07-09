package ir.skings.myprogressbar;

import java.security.PublicKey;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements
		android.view.View.OnClickListener {

	private TextView percent;
	private ProgressBar progressbar;
	private final int MaxValueOfProgressbar = 1000, MaxValueOfProgressbarDivide100 = 10 , stepOfProgressbar = 10;
	private int stopValue = 900;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		percent = (TextView) findViewById(R.id.percent);

		progressbar = (ProgressBar) findViewById(R.id.progressBar1);
		progressbar.setMax(MaxValueOfProgressbar);

		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		new LongOperation().execute("");

	}

	private class LongOperation extends AsyncTask<String, String, String> {

		int pos = 0;

		@Override
		protected String doInBackground(String... params) {
			while (pos < stopValue) {
				try {
					pos += stepOfProgressbar;
					onProgressUpdate();
					Thread.sleep(50);
				} catch (InterruptedException e) {
					Thread.interrupted();
				}
			}
			return "Executed";
		}

		@Override
		protected void onPostExecute(String result) {
		}

		@Override
		protected void onPreExecute() {
		}

		@Override
		protected void onProgressUpdate(String... values) {
			super.onProgressUpdate();
			progressbar.setProgress(pos);
			runOnUiThread(new Runnable() {
				public void run() {
					percent.setText((pos/MaxValueOfProgressbarDivide100)+"%");
				}
			});

			// setPercent((pos/progressbar.getMax()*100));
		}
	}

}