package com.bawei.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Zhang on 2017/9/3.
 */

public class TopBar extends LinearLayout{

    public TopBar(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Topbar);

        String middle_text = typedArray.getString(R.styleable.Topbar_middle_text);
        float middle_size = typedArray.getDimension(R.styleable.Topbar_middle_size,20);
        int middle_color = typedArray.getColor(R.styleable.Topbar_middle_color, Color.BLACK);
        int middle_bg = typedArray.getColor(R.styleable.Topbar_middle_bg,Color.GREEN);

        String left_text = typedArray.getString(R.styleable.Topbar_left_text);
        float left_size = typedArray.getDimension(R.styleable.Topbar_left_size,20);
        int left_color = typedArray.getColor(R.styleable.Topbar_left_color,Color.BLACK);
        int left_bg = typedArray.getColor(R.styleable.Topbar_left_bg,Color.BLUE);

        String right_text = typedArray.getString(R.styleable.Topbar_right_text);
        float right_size = typedArray.getDimension(R.styleable.Topbar_right_size,20);
        int right_color = typedArray.getColor(R.styleable.Topbar_right_color,Color.BLACK);
        int right_bg = typedArray.getColor(R.styleable.Topbar_right_bg,Color.BLUE);

        typedArray.recycle();

        View topbarview = View.inflate(context, R.layout.topbar, this);
        final Button btn_left = (Button) topbarview.findViewById(R.id.btn_left);
        Button btn_right = (Button) topbarview.findViewById(R.id.btn_right);
        TextView tv_middle = (TextView) topbarview.findViewById(R.id.tv_middle);

        btn_left.setText(left_text);
        btn_left.setTextSize(left_size);
        btn_left.setTextColor(left_color);
        btn_left.setBackgroundColor(left_bg);

        btn_right.setText(right_text);
        btn_right.setTextSize(right_size);
        btn_right.setTextColor(right_color);
        btn_right.setBackgroundColor(right_bg);

        tv_middle.setText(middle_text);
        tv_middle.setTextSize(middle_size);
        tv_middle.setTextColor(middle_color);
        tv_middle.setBackgroundColor(middle_bg);

        btn_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "返回", Toast.LENGTH_SHORT).show();
            }
        });
        btn_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "更多", Toast.LENGTH_SHORT).show();
            }
        });

        btn_left.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int action = event.getAction();
                switch (action){
                    case MotionEvent.ACTION_UP:
                        btn_left.setBackgroundColor(Color.BLUE);
                        break;
                    case MotionEvent.ACTION_DOWN:
                        btn_left.setBackgroundColor(Color.RED);
                        break;
                }
                return false;
            }
        });


    }

}
