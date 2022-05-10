package com.qa.utils.dynamicParams;


import javax.xml.crypto.Data;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import freemarker.template.utility.ClassUtil;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;


public enum DataHandlerService {

    INSTANCE;

    private Map<String, DataHandler> dataHandlerStorage;

    public Map<String, DataHandler> getStorage(){
        dataHandlerStorage = Optional.ofNullable(dataHandlerStorage).orElseGet(() -> new ConcurrentHashMap<String, DataHandler>());
        return dataHandlerStorage;
    }

    public DataHandler getDataHandler(String key){
        return Optional.ofNullable(getStorage().get(key)).orElseGet(() -> {
            registerDataHandlers();
            return getStorage().get(key);
        });
    }

    public void setDataHandler(String key, DataHandler dataHandler){
        getStorage().put(key, dataHandler);
    }

    private void registerDataHandlers(){

        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(DataHandlerRegistry.class));

        for(BeanDefinition bd: scanner.findCandidateComponents("com.qa.utils.dynamicParams.impl")){
            @SuppressWarnings("unchecked")
            Class <? extends DataHandler> handlerType = (Class <? extends DataHandler> ) ClassUtils.resolveClassName(bd.getBeanClassName(), null);

            DataHandlerRegistry registryAnnotation = handlerType.getAnnotation(DataHandlerRegistry.class);
            try{
                setDataHandler(registryAnnotation.value(), handlerType.newInstance());
            }catch (InstantiationException | IllegalAccessException e){
                throw new RuntimeException("Instance of handler class "+ handlerType  + " wasn't generated", e);
            }
        }
    }

}
