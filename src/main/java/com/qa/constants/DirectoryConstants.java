package com.qa.constants;

import java.io.File;

public class DirectoryConstants {

    public static String SRC = "src";
    public static String MAIN = "main";
    public static String JAVA = "java";
    public static String COM = "com";
    public static String QA = "qa";
    public static String CONFIG = "config";
    public static final String RESULT = "result";
    public static final String EXTENT = "extent";

    public static String getUserDir(){
        return  System.getProperty("user.dir");
    }

    public static String getConfigDir(){
        return  getUserDir() + File.separator + SRC + File.separator + MAIN + File.separator + JAVA + File.separator
                + COM + File.separator + QA + File.separator + CONFIG + File.separator;
    }

    public static String getExtentResultsDir(){
        return getUserDir() + File.separator + RESULT + File.separator + EXTENT + File.separator;
    }

}
