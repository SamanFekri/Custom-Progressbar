package ir.skings.myprogressbar;

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
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity implements
		android.view.View.OnClickListener {

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

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		new LongOperation().execute("");

	}

	private class LongOperation extends AsyncTask<String, Void, String> {

		int pos = 0;
		
		@Override
		protected String doInBackground(String... params) {
			while (pos < 1000) {
				try {
					pos += 10;
					onProgressUpdate();
					Thread.sleep(100);
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
		protected void onProgressUpdate(Void... values) {
			progressbar.setProgress(pos);
		}
	}

}