package com.example.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class JettRelativeLayout extends RelativeLayout {
    public JettRelativeLayout(Context context) {
        super(context);
    }

    public JettRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public JettRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        float scaleX = UIUtils.getInstance(getContext()).getHorAValue();
        float scaleY = UIUtils.getInstance(getContext()).getVarValue();
        //获取所有的子View
        int count = this.getChildCount();
        for (int i = 0; i < count; i++){
            //拿到所有子控件的View
            View child = this.getChildAt(i);
            //对它的布局参数进行修改
           LayoutParams layoutParams =  (LayoutParams)child.getLayoutParams();
           layoutParams.width = (int) (layoutParams.width * scaleX);
           layoutParams.height = (int) (layoutParams.height * scaleY);
           layoutParams.leftMargin = (int) (layoutParams.leftMargin * scaleX);
           layoutParams.rightMargin = (int) (layoutParams.rightMargin * scaleX);
           layoutParams.topMargin = (int) (layoutParams.topMargin * scaleY);
           layoutParams.bottomMargin = (int) (layoutParams.bottomMargin * scaleY);
        }
    }
}
