package uchiwa.appli;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;

public class OekakiAndroidActivity extends Activity {
    /** Called when the activity is first created. */

	OekakiView view;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
        
        view = new OekakiView(this);
        setContentView(view);
    }
    
/*
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch(event.getAction()){
			case MotionEvent.ACTION_DOWN: //最初のポイント 
				// 押されたPointに移動
				view.moveTo(event.getX(), event.getY());
				break;
			case MotionEvent.ACTION_MOVE: //途中のポイント 
				view.lineTo(event.getX(), event.getY());
				view.invalidate();
				break;
			case MotionEvent.ACTION_UP: //最後のポイント 
				view.lineTo(event.getX(), event.getY());
				// キャッシュの中からキャプチャを作成するので、その一瞬の為にキャッシュをON 
//				setDrawingCacheEnabled(true);
//				bitmap = Bitmap.createBitmap(getDrawingCache());
//				setDrawingCacheEnabled(false);
				view.invalidate();
				break;
			default://その他
				break; 
		} 
		return true; 
	}*/
    
}