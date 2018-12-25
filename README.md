# hxgpopupwindow

### 引用方式

```
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }

    dependencies {
        implementation 'com.github.huangxiaoguo1:hxgpopupwindow:1.0.2'
    }
```

#### 简单实例

```
HxgPopupUtils.getInstance()
                .setContentView(this, R.layout.popup_item)
                .setLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, -2)
                .setFocusable(true)
                .dismissPopWindow(R.id.view)
                .showAsDropDown(mTvAddress)

```
```
        View popupView = HxgPopupUtils.getInstance()
                .setContentView(this, R.layout.popup_item)
                .setLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, -2)
                .setFocusable(true)
                .dismissPopWindow(R.id.view)
//                .showAsDropDown(mTvAddress)
                .setBackgroundDrawable()
                .showAtLocation(mTvAddress, Gravity.TOP, 100, 300)
                .setAnimation(as)
                .getView();
        ((TextView) popupView.findViewById(R.id.textview))
                .setText("我是更改的PopupWindow");
```

### 添加布局

```
setContentView(Context context, int layoutId)
```

### 设置宽高

```
setLayoutParams(int width, int height)

```

### 如果要执行动画，popWindow 必须得有背景

```
setBackgroundDrawable()
```

### 如果点击空白处时，隐藏掉pop窗口

```
setFocusable(boolean isFocusable)
```
### 设置显示位置

```
showAsDropDown(View view)

showAtLocation(View view, int gravity, int x, int y)
```

### 添加动画 效果
```
setAnimation(Animation animation)

setAnimation(AnimationSet animation)
```
### 获得布局view

```
getView()
```

### 取消PopWindow

```
dismissPopWindow(int viewId)

dismissPopWindow()

```
### 消失监听

```
 setOnDismissListener(OnDismissListener listener) 

```




###