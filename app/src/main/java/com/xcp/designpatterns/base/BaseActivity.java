package com.xcp.designpatterns.base;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.xcp.designpatterns.mvp.BasePresenter;
import com.xcp.designpatterns.utils.UIUtils;

import butterknife.ButterKnife;

/**
 * Created by 许成谱 on 2018/5/29 10:08.
 * qq:1550540124
 * 热爱生活每一天！
 * 公共基类，把公共的代码都提取到这里。模板设计模式。
 */

public abstract class BaseActivity<K,T extends BasePresenter<K>> extends AppCompatActivity {
    private InputMethodManager imm;
    protected T basePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //屏幕适配工具
        UIUtils.setCustomDensity(this,getApplication(),375);
        setContentView( getLayoutId());
        ButterKnife.bind(this);
        basePresenter=getPresenter();//在这里相当于初始化了presenter
        if(basePresenter!=null) {
            basePresenter.attach((K)this);//绑定，与presenter建立关联,使基类中的view获得了实例
        }

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        initView(savedInstanceState);

        initData();

        initListener();
    }

    protected abstract T getPresenter();

    /**
     * @return 布局layout文件
     */
    public abstract int getLayoutId() ;
    /**
     * 初始化视图
     * @param savedInstanceState
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化监听
     */
    protected abstract void initListener();

    /**
     * 隐藏软键盘
     */
    public boolean onTouchEvent(MotionEvent event) {
        if (null != this.getCurrentFocus()) {
            /**
             * 点击空白位置 隐藏软键盘
             */
            InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            return mInputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }
        return super.onTouchEvent(event);
    }

    /*
     * 打开软键盘
     * */

    public void showSoftKeyBoard(EditText editText) {

        imm.showSoftInput(editText, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    /*隐藏软键盘
     * */
    public void hideSoftKeyBoard() {
        imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0); //强制隐藏键盘

    }

    /**
     * 判断软键盘是否弹出
     */
    public boolean isSoftShowing() {
        //获取当前屏幕内容的高度
        int screenHeight = getWindow().getDecorView().getHeight();
        //获取View可见区域的bottom
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);

        return screenHeight - rect.bottom != 0;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(basePresenter!=null) {
            basePresenter.detach();//由于presenter可能会执行耗时操作，任务没执行完时就Activity就销毁了，这样就会导致内存泄露，在此与presenter解除关联，防止内存泄露
        }
    }
}
