package cn.tsou.hxgpopupwindow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import cn.tsou.hxgpopup.HxgPopupUtils;
import tsou.cn.lib_hxgioc.HxgBind;
import tsou.cn.lib_hxgioc.HxgContentView;
import tsou.cn.lib_hxgioc.HxgOnClick;
import tsou.cn.lib_hxgioc.HxgViewUtils;

@HxgContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    /**
     * HxgPopup
     **/
    @HxgBind(R.id.tv_address)
    private TextView mTvAddress;
    @HxgBind(R.id.space)
    private Space mSpace;
    private AnimationSet as;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HxgViewUtils.getView().inject(this);
        AlphaAnimation aa = new AlphaAnimation(0, 1); // 从完全透明，到完全不透明
        aa.setDuration(500);

        // 以(0,0.5f)为中心，从50% 放大至100%
        ScaleAnimation sa = new ScaleAnimation(1f, 1, 0.5f, 1,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0f);
        sa.setDuration(500);
        as = new AnimationSet(false);
        as.addAnimation(aa);
        as.addAnimation(sa);
    }

    @HxgOnClick(R.id.btn_address)
    private void btnAddressClick(Button view) {
        View popupView = HxgPopupUtils.getInstance()
                .setContentView(this, R.layout.popup_item)
                .setLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, -2)
                .setFocusable(true)
                .dismissPopWindow(R.id.view)
                .showAsDropDown(mSpace)
                .setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        Toast.makeText(MainActivity.this, "消失了", Toast.LENGTH_LONG).show();
                    }
                })
                .setBackgroundDrawable()
//                .showAtLocation(mTvAddress, Gravity.TOP, 100, 300)
                .setAnimation(as)
                .update(ViewGroup.LayoutParams.MATCH_PARENT, this.getResources().getDisplayMetrics().heightPixels - mSpace.getBottom())
                .getView();
//        HxgPopupUtils.getInstance().getPopWindow().update(ViewGroup.LayoutParams.MATCH_PARENT, this.getResources().getDisplayMetrics().heightPixels - mSpace.getBottom());
        ((TextView) popupView.findViewById(R.id.textview))
                .setText("我是更改的PopupWindow");
    }
}
