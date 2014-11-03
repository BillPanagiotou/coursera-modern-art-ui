package billpan.modernart;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract.Colors;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends ActionBarActivity {

	static final String TAG = "MainActivity";
	static final String MOMA_URI = "http://www.moma.org/";
	private AlertDialogFragment mDialog;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final LinearLayout redLayout = (LinearLayout) findViewById(R.id.red_rect);
		final LinearLayout purpleLayout = (LinearLayout) findViewById(R.id.purple_rect);
		final LinearLayout limeLayout = (LinearLayout) findViewById(R.id.lime_rect);
		final LinearLayout blueGrayLayout = (LinearLayout) findViewById(R.id.blue_grey_rect);

		final int[] red = getResources().getIntArray(R.array.red);
		final int[] purple = getResources().getIntArray(R.array.purple);
		final int[] lime = getResources().getIntArray(R.array.lime);
		final int[] blue_gray = getResources().getIntArray(R.array.blue_gray);

		final SeekBar sk = (SeekBar) findViewById(R.id.mSeekBar);
		sk.setMax(8);
		sk.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub

				Log.i(TAG, String.valueOf(progress));

				redLayout.setBackgroundColor(red[progress]);
				purpleLayout.setBackgroundColor(purple[progress]);
				limeLayout.setBackgroundColor(lime[progress]);
				blueGrayLayout.setBackgroundColor(blue_gray[progress]);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.more_information) {

			// Create a new AlertDialogFragment
			mDialog = AlertDialogFragment.newInstance();

			// Show AlertDialogFragment
			mDialog.show(getFragmentManager(), "Alert");

			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// Class that creates the AlertDialog
	public static class AlertDialogFragment extends DialogFragment {

		public static AlertDialogFragment newInstance() {
			return new AlertDialogFragment();
		}

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			return new AlertDialog.Builder(getActivity())
					.setMessage(R.string.dialog_message)
					.setTitle(R.string.dialog_title)
					.setNegativeButton("Visit MOMA", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							Intent intent = new Intent(Intent.ACTION_VIEW, Uri
									.parse(MOMA_URI));
							startActivity(intent);
						}
					}).setPositiveButton("Not Now", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							dialog.dismiss();
						}
					}).create();
		}

	}

}
