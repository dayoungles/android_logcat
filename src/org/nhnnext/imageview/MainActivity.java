package org.nhnnext.imageview;

import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private ImageView imageview;
	private boolean changeImage = true;
	private String imgPath = "";
	private Button button;
	private String stri;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		imageview = (ImageView) findViewById(R.id.imageView);
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:

			if (changeImage) {
				changeImage = false;
				imgPath = "first.jpg";
				// Toast.makeText(MainActivity.this,
				// "first",Toast.LENGTH_SHORT).show();
				Log.i("namecheck1", "first");

			} else {
				changeImage = true;
				imgPath = "sec.JPG";
				// Toast.makeText(MainActivity.this, "sec",
				// Toast.LENGTH_SHORT).show();
				Log.i("namecheck2", "sec");

			}

			InputStream ims;
			try {
				ims = getAssets().open(imgPath);
				Drawable d = Drawable.createFromStream(ims, null);
				imageview.setImageDrawable(d);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
			
		}
		try {

			imageview.setBackgroundResource(212312);
		
		//Log.i("test",drawable.getColor());
		} catch(Exception e){
			Log.e("test","set error");
			e.printStackTrace();
		}
	}

}
