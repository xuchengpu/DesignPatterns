package com.xcp.designpatterns.prototypepartterns;

import java.util.ArrayList;

/**
 * Created by 许成谱 on 2019/6/25 18:56.
 * qq:1550540124
 * 热爱生活每一天！
 * <p>
 * 原型设计模式：用原型实例指定创建对象的种类，并通过复制这些原型创建新的对象
 * 具体的原型类
 * <p>
 * Client:客户端用户
 * Prototype:抽象类或者接口，声明具备clone能力
 * ConcretePrototype:具体的原型类
 */
public class WordDocument implements Cloneable {
    private String mText;
    private ArrayList<String> images = new ArrayList<>();

    public WordDocument() {
        System.out.println("WordDocument构造器");
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void addImage(String image) {
        this.images.add(image);
    }

    /**
     * 深度复制
     * @return
     */
    @Override
    protected WordDocument clone() {
        try {
            WordDocument document = (WordDocument) super.clone();
            document.mText = mText;
            document.images = (ArrayList<String>) images.clone();
            return document;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }
/*
    */
/**
     * 浅度复制
     * @return
     *//*

    @Override
    protected WordDocument clone() {
        try {
            WordDocument document = (WordDocument) super.clone();
            document.mText = mText;
            document.images = images;
            return document;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }
*/

    /**
     * 展示文件内容
     */
    public void show() {
        System.out.println("--------start---------");
        System.out.println("Text" + mText);
        System.out.println("ImageList:");
        for (String image : images) {
            System.out.println("image name:" + image);
        }

        System.out.println("--------end---------");
    }
}
