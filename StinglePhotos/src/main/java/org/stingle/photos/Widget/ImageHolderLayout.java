package org.stingle.photos.Widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import org.stingle.photos.Crypto.Crypto;

public class ImageHolderLayout extends RelativeLayout {

	private boolean inteceptAllowed = true;
	private OnTouchListener listener = null;
	private int fileType = Crypto.FILE_TYPE_PHOTO;
	
	public ImageHolderLayout(Context context) {
		super(context);
	}

	public ImageHolderLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@SuppressLint("NewApi")
	public ImageHolderLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(listener != null){
			listener.onTouch(this, event);
		}
		return super.onTouchEvent(event);
	}
	
	@Override
	public void setOnTouchListener(OnTouchListener l) {
		listener = l;
		super.setOnTouchListener(l);
		
	}
	
	@Override
	public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
		inteceptAllowed = !disallowIntercept;
		super.requestDisallowInterceptTouchEvent(disallowIntercept);
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		if(inteceptAllowed){
			onTouchEvent(ev);
		}
		return super.onInterceptTouchEvent(ev);
	}


	public void setFileType(int type){
		fileType = type;
	}

	public int getFileType(){
		return fileType;
	}
}
