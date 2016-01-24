package tn.enis.fadwa.touristguide;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Details extends AppCompatActivity {
	TextView t1,t2;
	RatingBar r;
	ImageView im;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);

		t1=(TextView)findViewById(R.id.title);
		t2=(TextView)findViewById(R.id.description);
		im=(ImageView)findViewById(R.id.imageView);
		r=(RatingBar)findViewById(R.id.ratingBar);


		Boolean test = true;
		try {

			FileReader f;

			BufferedReader br = new BufferedReader(new
					InputStreamReader(getAssets().open("details.txt")));

			//BufferedReader br = new BufferedReader(f);
			String line;
			int i=0;
			while ((line = br.readLine()) != null) {
				i++;

				if(i==1){
					t1.setText(line);
				}
				else if(i==2){
					r.setRating(Float.parseFloat(line.substring(0, line.length())));

					// Toast.makeText(getApplicationContext(),line,Toast.LENGTH_LONG).show();
				}
				else if(i==3){

					t2.setText(line);
					// Toast.makeText(getApplicationContext(),line,Toast.LENGTH_LONG).show();

				}








			}
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(), "err2222", Toast.LENGTH_LONG).show();

		}
	}
}