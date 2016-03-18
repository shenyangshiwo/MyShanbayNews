package com.example.myshanbaynews;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

public class MyTextView extends TextView {


	
	public MyTextView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public MyTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if(event.getAction()==MotionEvent.ACTION_DOWN)
		{
			setBackgroundColor(Color.rgb(0x00, 0x99, 0xcc));
		}
		
		return true;
	}

}
