package com.homeserver.utils;

import org.apache.log4j.Logger;
import org.beanio.BeanReader;
import org.beanio.StreamFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by trung on 04/02/17.
 */
public class BeanioFileReader<T> implements FileReader<T> {
    private String schemaFilePath;
    private String schemaName;
    public final static Logger log = Logger.getLogger(BeanioFileReader.class);

    public String getSchemaFilePath() {
        return schemaFilePath;
    }

    public void setSchemaFilePath(String schemaFilePath) {
        this.schemaFilePath = schemaFilePath;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    @Override
    public List<T> readFromFile(File file) {
        List<T> res = new ArrayList<T>();
        try {
            StreamFactory factory = StreamFactory.newInstance();
            factory.loadResource(schemaFilePath);
            InputStream in = new FileInputStream(file);
            BeanReader reader = factory.createReader(schemaName, new InputStreamReader(in));
            Object record;
            while ((record = reader.read()) != null) {
                res.add((T) record);
            }
        } catch (FileNotFoundException ex) {
            log.error("Error while reading file: " + ex);
        } finally {
            return res;
        }
    }
}
