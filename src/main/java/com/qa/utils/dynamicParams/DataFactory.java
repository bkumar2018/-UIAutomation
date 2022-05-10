package com.qa.utils.dynamicParams;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import javax.activation.DataHandler;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataFactory {

    private static Map<String, Object> sourceStorage;
    private static Pattern pattern = Pattern.compile("\\{{2}[^\\{\\}]+\\}{2}");
    private static Map<String, Object> getSourceStorage(){
        sourceStorage = Optional.ofNullable(sourceStorage).orElseGet(() -> new HashMap<>());
        return sourceStorage;
    }

    private static Object getDataFromSource(Object source){

        if(source instanceof String){
            Object sourceVal = null;
            String handlerType = source.toString().split(":")[0]+":";
            if(source != null && source.toString().split(":").length > 1 && handlerType.matches("^[\\w]+:$")){
                String tempValOfSource = source.toString().replaceFirst(handlerType, "");
                Object valOfSource = getSourceStorage().containsKey(tempValOfSource) ?
                        getSourceStorage().get(tempValOfSource) : tempValOfSource;
                String handlerKey = handlerType.toLowerCase().replace(":", "");

                if(DataHandlerService.INSTANCE.getStorage().containsKey(handlerKey)){
                    sourceVal = DataHandlerService.INSTANCE.getDataHandler(handlerKey).getData(valOfSource);
                }
            }

            if(source != null){
                if(handlerType.equals("file:")){
                    source = getDataFromSource(replaceStringInterpolations(sourceVal));
                }else{
                    source = getDataFromSource(sourceVal);
                }
            }
        }
        return source;
    }

    public static Object getData(String source){
        return DataHandlerService.INSTANCE.getDataHandler("constant").getData(replaceStringInterpolations(source));
    }

    private static Object replaceStringInterpolations(Object source){
        if(source instanceof String){
            String sourceStr = source.toString();
            Matcher matcher = pattern.matcher(sourceStr);

            if(matcher.find()){
                String strInterpolation = matcher.group();
                Object val = getDataFromSource(strInterpolation.replace("{{", "").replace("}}", ""));
                if( !(val instanceof Collection<?>)){
                    sourceStr = sourceStr.replace(strInterpolation, val.toString());
                }else{
                    String uuid = UUID.randomUUID().toString();
                    sourceStr = sourceStr.replace(strInterpolation, uuid).trim();
                    getSourceStorage().put(uuid, val);
                }
                source = replaceStringInterpolations(sourceStr);
            }else{
                source = getDataFromSource(source);
            }
        }
        if(getSourceStorage().containsKey(source)){
            source = getSourceStorage().get(source);
        }
        return source;
    }
}
