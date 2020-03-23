package com.xcp.designpatterns.prototypepartterns;

/**
 * Created by 许成谱 on 2019/6/25 19:10.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class Client {
    public static void main(String[] args) {
        WordDocument originDoc = new WordDocument();
        originDoc.setmText("文档一");
        originDoc.addImage("image1");
        originDoc.addImage("image2");
        originDoc.addImage("image3");
        originDoc.show();

        WordDocument clone = originDoc.clone();
        clone.show();
        clone.setmText("文档二");
        clone.addImage("新添加的");
        clone.show();

        originDoc.show();
    }
}
