package com.qa.constants;

public class FileConstants {

    public static String CONFIG_PROPERTIES = "masterConfig.properties";
    public static String AADHAAR_CONFIG_PROPERTIES = "aadhaar.properties";


    public static String getConfigFile(){
        return DirectoryConstants.getConfigDir() + CONFIG_PROPERTIES;
    }

    public static String getAadhaarConfigFile(){
        return DirectoryConstants.getConfigDir() + AADHAAR_CONFIG_PROPERTIES;
    }
}
