package uchiwa.appli;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class OekakiView extends View {

    private float pos_x = 0f; //イベントが起きたX座標 
    private float pos_y = 0f; //イベントが起きたY座標 
     
    private Path path = null; //パス新規作成 
	private Bitmap bitmap = null; //Viewの状態を保存するためのBitmap

    public OekakiView(Context context) {
		super(context);
	}
    
    public void moveTo(float fX, float fY) {
		path = new Path();//pathを新規作成
		pos_x = fX;//x座標取得
		pos_y = fY;//y座標取得
		// 押されたPointに移動
		path.moveTo(fX, fY);
    }
    
    public void lineTo(float fX, float fY) {
		pos_x = fX;//x座標取得
		pos_y = fY;//y座標取得
		// 押されたPointに移動
		path.lineTo(fX, fY);
    }

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch(event.getAction()){
			case MotionEvent.ACTION_DOWN: //最初のポイント 
				path = new Path();//pathを新規作成
				pos_x = event.getX();//x座標取得
				pos_y = event.getY();//y座標取得
				// 押されたPointに移動
				path.moveTo(event.getX(), event.getY());
				break;
			case MotionEvent.ACTION_MOVE: //途中のポイント 
				pos_x = event.getX();
				pos_y = event.getY();
				path.lineTo(pos_x, pos_y);
				invalidate();
				break;
			case MotionEvent.ACTION_UP: //最後のポイント 
				path.lineTo(event.getX(), event.getY());
				// キャッシュの中からキャプチャを作成するので、その一瞬の為にキャッシュをON 
				setDrawingCacheEnabled(true);
				bitmap = Bitmap.createBitmap(getDrawingCache());
				setDrawingCacheEnabled(false);
				invalidate();
				break;
			default://その他
				break; 
		} 
		return true; 
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// 背景色設定
		canvas.drawColor(Color.WHITE);
		
		if(bitmap != null){
			canvas.drawBitmap(bitmap, 0, 0, null);
		}

		Paint paint = new Paint();
		// 線の色を設定
		paint.setColor(Color.BLACK);
		// 線で描く
		paint.setStyle(Paint.Style.STROKE);		//pathを描写
		if(path != null){
			canvas.drawPath(path, paint);
		}
	}

	
	
}
