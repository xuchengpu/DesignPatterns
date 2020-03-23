package com.xcp.designpatterns.mvp_proxy.model_proxy;

import com.xcp.designpatterns.mvp_proxy.Inject;
import com.xcp.designpatterns.mvp_proxy.base.BaseModel;
import com.xcp.designpatterns.mvp_proxy.base.BasePresenter;

import java.lang.reflect.Field;

/**
 * Created by 许成谱 on 2019/6/17 15:02.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class ModelProxy<P extends BasePresenter> {
    private  P mPresenter;

    public ModelProxy(P presenter) {
        this.mPresenter=presenter;
    }
    public void createModels(){
        Field[] fields = mPresenter.getClass().getDeclaredFields();
        for (Field field : fields) {
            Inject annotation = field.getAnnotation(Inject.class);
            if (annotation != null) {
                try {
                    BaseModel model = (BaseModel) (field.getType().newInstance());
                    field.setAccessible(true);
                    field.set(mPresenter, model);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
