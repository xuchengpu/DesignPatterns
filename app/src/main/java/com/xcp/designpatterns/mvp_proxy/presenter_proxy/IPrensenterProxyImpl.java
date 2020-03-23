package com.xcp.designpatterns.mvp_proxy.presenter_proxy;

import com.xcp.designpatterns.mvp_proxy.Inject;
import com.xcp.designpatterns.mvp_proxy.base.BasePresenter;
import com.xcp.designpatterns.mvp_proxy.base.BaseView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 许成谱 on 2019/6/17 14:46.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class IPrensenterProxyImpl<V extends BaseView>  implements IPresenterProxy{
    private  V mView;
    private List<BasePresenter> presenters;
    public IPrensenterProxyImpl(V view) {
        this.mView=view;
        presenters = new ArrayList<>();
    }

    @Override
    public void attach() {
        Field[] fields = mView.getClass().getDeclaredFields();
        for (Field field : fields) {
            Inject annotation = field.getAnnotation(Inject.class);
            if (annotation != null) {
                try {
                    BasePresenter presenter = (BasePresenter) (field.getType().newInstance());
                    presenters.add(presenter);
                    presenter.attach(mView);
                    field.setAccessible(true);
                    field.set(mView, presenter);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void detach() {
        for (BasePresenter presenter : presenters) {
            presenter.Detach();
        }
    }
}
