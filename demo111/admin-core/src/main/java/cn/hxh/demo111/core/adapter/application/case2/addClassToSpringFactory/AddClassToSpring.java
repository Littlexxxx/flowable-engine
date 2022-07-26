package cn.hxh.demo111.core.adapter.application.case2.addClassToSpringFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


/**
 * @author: xinhao.hu
 * @date: 2021/12/28 2:28 下午
 * @description:
 **/
@Component
public class AddClassToSpring implements /*BeanDefinitionRegistryPostProcessor,*/ ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext add(){
        try {
            Class<?> clazz = Class.forName("cn.hxh.demo111.core.adapter.application.case2.addClassToSpringFactory.ExtensionClass1");
            SpringBootBeanUtils.registerBean( (ConfigurableApplicationContext) applicationContext,"class1",clazz,"zhangsan");
        }catch(Exception e){
        }
        return applicationContext;
    }

    private Set<Class<?>> clazzSet = new HashSet<>();
    private ApplicationContext applicationContext;

    //@Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {

        try {
            Class<?> clazz1 = Class.forName("cn.hxh.demo111.core.adapter.application.case2.addClassToSpringFactory.ExtensionClass1");
            Class<?> clazz2 = Class.forName("cn.hxh.demo111.core.adapter.application.case2.addClassToSpringFactory.ExtensionClass2");
            clazzSet.add(clazz1);
            clazzSet.add(clazz2);
        }catch (Exception e){
        }
        clazzSet.forEach(clazz -> {
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
            AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
            beanDefinitionRegistry.registerBeanDefinition(clazz.getSimpleName(),beanDefinition);
        });

    }

    //@Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
