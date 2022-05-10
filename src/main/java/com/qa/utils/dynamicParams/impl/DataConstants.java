package com.qa.utils.dynamicParams.impl;

import com.qa.utils.dynamicParams.DataHandlerRegistry;

@DataHandlerRegistry("constant")
public class DataConstants {
    public Object getData(Object source){
        if(source instanceof String){
            switch (source.toString()){
                case "EMPTY":
                    source = "";
                    break;
                case "NULL":
                    source = null;
                    break;
            }
        }
        return source;
    }
}
