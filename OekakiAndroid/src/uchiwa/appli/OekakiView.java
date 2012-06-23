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

    private float pos_x = 0f; //�C�x���g���N����X���W 
    private float pos_y = 0f; //�C�x���g���N����Y���W 
     
    private Path path = null; //�p�X�V�K�쐬 
	private Bitmap bitmap = null; //View�̏�Ԃ�ۑ����邽�߂�Bitmap

    public OekakiView(Context context) {
		super(context);
	}
    
    public void moveTo(float fX, float fY) {
		path = new Path();//path��V�K�쐬
		pos_x = fX;//x���W�擾
		pos_y = fY;//y���W�擾
		// �����ꂽPoint�Ɉړ�
		path.moveTo(fX, fY);
    }
    
    public void lineTo(float fX, float fY) {
		pos_x = fX;//x���W�擾
		pos_y = fY;//y���W�擾
		// �����ꂽPoint�Ɉړ�
		path.lineTo(fX, fY);
    }

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch(event.getAction()){
			case MotionEvent.ACTION_DOWN: //�ŏ��̃|�C���g 
				path = new Path();//path��V�K�쐬
				pos_x = event.getX();//x���W�擾
				pos_y = event.getY();//y���W�擾
				// �����ꂽPoint�Ɉړ�
				path.moveTo(event.getX(), event.getY());
				break;
			case MotionEvent.ACTION_MOVE: //�r���̃|�C���g 
				pos_x = event.getX();
				pos_y = event.getY();
				path.lineTo(pos_x, pos_y);
				invalidate();
				break;
			case MotionEvent.ACTION_UP: //�Ō�̃|�C���g 
				path.lineTo(event.getX(), event.getY());
				// �L���b�V���̒�����L���v�`�����쐬����̂ŁA���̈�u�ׂ̈ɃL���b�V����ON 
				setDrawingCacheEnabled(true);
				bitmap = Bitmap.createBitmap(getDrawingCache());
				setDrawingCacheEnabled(false);
				invalidate();
				break;
			default://���̑�
				break; 
		} 
		return true; 
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// �w�i�F�ݒ�
		canvas.drawColor(Color.WHITE);
		
		if(bitmap != null){
			canvas.drawBitmap(bitmap, 0, 0, null);
		}

		Paint paint = new Paint();
		// ���̐F��ݒ�
		paint.setColor(Color.BLACK);
		// ���ŕ`��
		paint.setStyle(Paint.Style.STROKE);		//path��`��
		if(path != null){
			canvas.drawPath(path, paint);
		}
	}

	
	
}
