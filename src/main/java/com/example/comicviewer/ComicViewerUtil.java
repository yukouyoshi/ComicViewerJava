package com.example.comicviewer;

import java.io.*;
import java.util.Properties;

public class ComicViewerUtil {

    public static Properties getProperty(String propertiesFilename) {
        Properties prop = new Properties();

        try(InputStream in = new FileInputStream(propertiesFilename)) {
            prop.load(in);
        } catch (IOException ie) {
            ie.printStackTrace();
        }

        return prop;
    }
}
