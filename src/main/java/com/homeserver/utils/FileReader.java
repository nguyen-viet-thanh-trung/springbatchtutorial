package com.homeserver.utils;

import java.io.File;
import java.util.List;

/**
 * Created by trung on 04/02/17.
 */
public interface FileReader<T> {
    List<T> readFromFile(File file);
}
