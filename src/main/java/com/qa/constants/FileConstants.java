package com.qa.constants;

public class FileConstants {

    public static String CONFIG_PROPERTIES = "masterConfig.properties";
    public static String AADHAAR_CONFIG_PROPERTIES = "aadhaar.properties";
    public static String EXTENT_CONFIG = "extent_config.xml";
    public static String EXTENT_REPORT = "extentReport.html";


    public static String getConfigFile(){
        return DirectoryConstants.getConfigDir() + CONFIG_PROPERTIES;
    }

    public static String getAadhaarConfigFile(){
        return DirectoryConstants.getConfigDir() + AADHAAR_CONFIG_PROPERTIES;
    }

    public static String getExtentConfig(){
        return DirectoryConstants.getConfigDir() + EXTENT_CONFIG;
    }
    public static String getExtentReport(){
        return DirectoryConstants.getExtentResultsDir() + EXTENT_REPORT;
    }

}
