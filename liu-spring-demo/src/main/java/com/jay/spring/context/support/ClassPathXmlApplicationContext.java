package com.jay.spring.context.support;

import com.jay.spring.bean.factory.DefaultBeanFactory;
import com.jay.spring.bean.factory.xml.XmlBeanDefinitionReader;
import com.jay.spring.context.ApplicationContext;
import com.jay.spring.core.io.ClassPathResource;
import com.jay.spring.core.io.Resource;

/**
 * Created by xiang.wei on 2018/6/18
 *
 * @author xiang.wei
 */
public class ClassPathXmlApplicationContext  implements ApplicationContext{
    private DefaultBeanFactory defaultBeanFactory = null;

    public ClassPathXmlApplicationContext(String configFile) {
        defaultBeanFactory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultBeanFactory);
        Resource resource = new ClassPathResource(configFile);
        reader.loadBeanDefinition(resource);
    }

    @Override
    public Object getBean(String beanId) {
        return defaultBeanFactory.getBean(beanId);
    }

}
