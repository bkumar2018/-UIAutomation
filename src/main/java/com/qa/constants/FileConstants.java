package com.qa.constants;

public class FileConstants {

    public static String CONFIG_PROPERTIES = "config.properties";


    public static String getConfigFile(){
        return DirectoryConstants.getConfigDir() + CONFIG_PROPERTIES;
    }

}
