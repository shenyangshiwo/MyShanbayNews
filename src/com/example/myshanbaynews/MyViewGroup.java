package com.example.myshanbaynews;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class MyViewGroup extends ViewGroup{

	private int minInterval;
	private int mBetween;
	public MyViewGroup(Context context, AttributeSet attrs) {
		super(context, attrs);
		minInterval=20;
		mBetween=20;
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		//super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int widthMode=MeasureSpec.getMode(widthMeasureSpec);
		int heightMode=MeasureSpec.getMode(heightMeasureSpec);
		int sizeWidth=MeasureSpec.getSize(widthMeasureSpec);
		int sizeHeight=MeasureSpec.getSize(heightMeasureSpec);
		//计算所有的childView宽和高
		measureChildren(widthMeasureSpec, heightMeasureSpec);

		int height=0;
		int lineWidth=0;

		
		for(int i=0;i<getChildCount();i++)
		{
			View chilView=getChildAt(i);
			int childWidth=minInterval+chilView.getMeasuredWidth();
			int childHeight=chilView.getMeasuredHeight();
			if(lineWidth+childWidth-minInterval<=sizeWidth)
			{
				lineWidth=lineWidth+childWidth;
			}
			else
			{
				height=height+childHeight+mBetween;
				lineWidth=childWidth;
			}
			if(i==getChildCount()-1)
			{
				height=height+childHeight;
			}
		}
		if(heightMode==MeasureSpec.EXACTLY)
		{
			setMeasuredDimension(sizeWidth, sizeHeight);
			
		}
		else
		{
			setMeasuredDimension(sizeWidth, height); 
		}
		
		
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		int height=b-t;
		int width=r-l;
		int nowHeight=0;
        
		for(int i=0;i<getChildCount();)
		{
			
			List<View> childrenList=getChildrenList(i, width);
			
			int interval=minInterval;
			if(childrenList.size()>1)
			{
				interval=interval+(width-getChldrenWidth(childrenList))/(childrenList.size()-1);
			}
			int nowWidth=0;
			for(int j=0;j<childrenList.size();j++)
			{
				childrenList.get(j).layout(nowWidth, nowHeight, 
						nowWidth+childrenList.get(j).getMeasuredWidth(),
						nowHeight+childrenList.get(j).getMeasuredHeight());
				nowWidth=nowWidth+interval+childrenList.get(j).getMeasuredWidth();
			}
			nowHeight=nowHeight+childrenList.get(0).getMeasuredHeight()+mBetween;
			i=i+childrenList.size();
			
			

		}
		
		
		
		
	}
	public List<View> getChildrenList(int i,int width)
	{
		List<View> list=new ArrayList<View>();
		int nowWidth=0;
		for(;i<getChildCount();i++)
		{
			View chilView=getChildAt(i);
			int childWidth=minInterval+chilView.getMeasuredWidth();
			if(nowWidth+childWidth-minInterval<=width)
			{
				nowWidth=nowWidth+childWidth;
				list.add(chilView);
			}
			else
			{
				break;
			}
		}
		
		return list;
	}
	public int getChldrenWidth(List<View> list)
	{
		int width=0;
		for(int i=0;i<list.size();i++)
		{
			View chilView=list.get(i);
			width=width+chilView.getMeasuredWidth()+minInterval;
		}
		if(width==0)
		{
			return width;
		}
		else
		{
			return width-minInterval;
		}
	
	}
	

}
