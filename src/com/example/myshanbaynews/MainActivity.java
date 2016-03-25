package com.example.myshanbaynews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;

public class MainActivity extends Activity {

	private MyViewGroup myViewGroup1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myViewGroup1=(MyViewGroup) findViewById(R.id.MyViewGroup1);
        try {
			String myTxt=formatString("14.txt");
			String[] myWords=myTxt.split(" ");
			for(int i=0;i<myWords.length;i++)
			{
				MyTextView myTextView=new MyTextView(this);
	        	myTextView.setText(myWords[i]);
	        	myTextView.setTextSize(20);
	        	myViewGroup1.addView(myTextView);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    public String formatString(String fileName) throws IOException
	{
		String s1="";
		InputStreamReader reader;
		reader = new InputStreamReader(getResources().getAssets().open(fileName));
		BufferedReader bufReader=new BufferedReader(reader);
		String s2=bufReader.readLine();
		while((s2=bufReader.readLine())!= null)
		{
			if(s1.length()==0)
			{
				s1=s2;
			}
			else {
				s1=s1+s2;
			}
			
		}
		bufReader.close();
		return s1;
	}
}
