package com.example.myshanbaynews;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

public class MyTextView extends TextView {

	private boolean isHighlight;
	
	public MyTextView(Context context) {
		super(context);
		isHighlight=false;
		// TODO Auto-generated constructor stub
	}
	public MyTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		isHighlight=false;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if(event.getAction()==MotionEvent.ACTION_DOWN)
		{
			if(isHighlight)
			{
				
				setBackgroundResource(0);
				
			}
			else {
				setBackgroundColor(Color.rgb(0x00, 0x99, 0xcc));
			}
			isHighlight=!isHighlight;
			
			
		}
		
		return true;
	}

}
