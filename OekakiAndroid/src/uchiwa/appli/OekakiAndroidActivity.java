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
			case MotionEvent.ACTION_DOWN: //�ŏ��̃|�C���g 
				// �����ꂽPoint�Ɉړ�
				view.moveTo(event.getX(), event.getY());
				break;
			case MotionEvent.ACTION_MOVE: //�r���̃|�C���g 
				view.lineTo(event.getX(), event.getY());
				view.invalidate();
				break;
			case MotionEvent.ACTION_UP: //�Ō�̃|�C���g 
				view.lineTo(event.getX(), event.getY());
				// �L���b�V���̒�����L���v�`�����쐬����̂ŁA���̈�u�ׂ̈ɃL���b�V����ON 
//				setDrawingCacheEnabled(true);
//				bitmap = Bitmap.createBitmap(getDrawingCache());
//				setDrawingCacheEnabled(false);
				view.invalidate();
				break;
			default://���̑�
				break; 
		} 
		return true; 
	}*/
    
}