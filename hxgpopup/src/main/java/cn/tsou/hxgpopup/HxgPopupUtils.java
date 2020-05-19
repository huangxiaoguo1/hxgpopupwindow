package cn.tsou.hxgpopup;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.PopupWindow;

/**
 * Created by 黄家三少 on 2018/9/2.
 * PopupWindow
 */

public class HxgPopupUtils {

    private View view;
    private PopupWindow popWindow;
    private static HxgPopupUtils instance;

    static {
        instance = new HxgPopupUtils();
    }

    private HxgPopupUtils() {

    }

    public static HxgPopupUtils getInstance() {
        return instance;
    }

    //添加布局
    public HxgPopupUtils setContentView(Context context, int layoutId) {
        dismissPopWindow();
        view = LayoutInflater.from(context).inflate(layoutId, null);
        return this;
    }

    //设置宽高
    public HxgPopupUtils setLayoutParams(int width, int height) {
        popWindow = new PopupWindow(view, width, height);
        return this;
    }


    //  如果要执行动画，popWindow 必须得有背景
    public HxgPopupUtils setBackgroundDrawable() {
        // 添加一个完全透明的背景
        popWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return this;
    }

    //  如果点击空白处时，隐藏掉pop窗口
    public HxgPopupUtils setFocusable(boolean isFocusable) {
        // 添加一个完全透明的背景
        popWindow.setFocusable(isFocusable);
        return this;
    }

    //  设置显示位置
    public HxgPopupUtils showAsDropDown(View view) {
        if (view != null)
            popWindow.showAsDropDown(view);
        return this;
    }

    public HxgPopupUtils update(int width, int height) {
        popWindow.update(width, height);
        return this;
    }

    //  设置显示位置
    public HxgPopupUtils showAtLocation(View view, int gravity, int x, int y) {
        if (view != null)
            popWindow.showAtLocation(view, gravity, x, y);
        return this;
    }

    //  添加动画 效果
    public HxgPopupUtils setAnimation(Animation animation) {
        // 只有view 才有执行动画的功能,
        if (animation != null)
            view.startAnimation(animation);
        return this;
    }

    //  添加动画 效果
    public HxgPopupUtils setAnimation(AnimationSet animation) {
        // 只有view 才有执行动画的功能,
        if (animation != null)
            view.startAnimation(animation);
        return this;
    }

    //  监听popWindow消失
    public HxgPopupUtils setOnDismissListener(PopupWindow.OnDismissListener listener) {
        if (listener != null)
            popWindow.setOnDismissListener(listener);
        return this;
    }

    //获得布局view
    public View getView() {
        return view;
    }

    //根据view取消PopWindow
    public HxgPopupUtils dismissPopWindow(int viewId) {
        view.findViewById(viewId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissPopWindow();
            }
        });
        return this;
    }

    //取消PopWindow
    public void dismissPopWindow() {
        if (popWindow != null && popWindow.isShowing()) {
            popWindow.dismiss();
            popWindow = null;
        }
    }

    public PopupWindow getPopWindow() {
        return popWindow;
    }
}
