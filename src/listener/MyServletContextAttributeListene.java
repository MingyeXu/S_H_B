package listener;
import java.text.MessageFormat;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
* @ClassName: MyServletContextAttributeListener
* @Description: ServletContext域对象中属性的变更的事件监听器
* @author: 孤傲苍狼
* @date: 2014-9-11 下午10:53:04
*
*/ 
public class MyServletContextAttributeListene implements
        ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent scab) {
        String str =MessageFormat.format(
                "ServletContext域对象中添加了属性:{0}，属性值是:{1}"
                ,scab.getName()
                ,scab.getValue());
        System.out.println(str);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scab) {
        String str =MessageFormat.format(
                "ServletContext域对象中删除属性:{0}，属性值是:{1}"
                ,scab.getName()
                ,scab.getValue());
        System.out.println(str);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scab) {
        String str =MessageFormat.format(
                "ServletContext域对象中替换了属性:{0}的值"
                ,scab.getName());
        System.out.println(str);
    }
}
