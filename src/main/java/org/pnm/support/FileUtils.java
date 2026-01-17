package org.pnm.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class FileUtils {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static FileUtils INSTANCE;

    private FileUtils() {
    }

    public static FileUtils getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FileUtils();
            return INSTANCE;
        } else {
            return INSTANCE;
        }
    }

    public String getFileName(Path path) {
        try {
            String fileName = path.getFileName().toString();
            this.logger.info("Working with file name: " + fileName);
            return fileName;
        } catch (Exception e) {
            throw new RuntimeException("Error while getting file name from path", e);
        }
    }

    public String getFileContent(Path path) {
        try {
            this.logger.info("Reading file content from path: {}", path);
            return this.readStringFromPath(path);
        } catch (Throwable $ex) {
            throw $ex;
        }
    }

    public String getFileContent(Path path, String fileName) {
        try {
            Path resourceDirectory = path.resolve(fileName);
            this.logger.info("Reading file content from path: {}", resourceDirectory);
            return this.readStringFromPath(resourceDirectory);
        } catch (Throwable $ex) {
            throw $ex;
        }
    }

    public String getFileContent(String path, String fileName) {
        try {
            return this.getFileContent(Paths.get(path), fileName);
        } catch (Throwable $ex) {
            throw $ex;
        }
    }

    public Properties loadProperties(String fileName, Path customPath) {
        Properties properties = new Properties();
        InputStream inputStream = null;

        try {
            if (customPath != null) {
                inputStream = Files.newInputStream(customPath);
                this.logger.info("Properties loaded successfully from custom path: {}", customPath);
            } else {
                inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
                if (inputStream == null) {
                    throw new FileNotFoundException("File not found in the classpath: " + fileName);
                }

                this.logger.info("Properties loaded successfully from classpath: {}", fileName);
            }

            properties.load(inputStream);
        } catch (IOException ex) {
            this.logger.error("Error loading properties file: {}", fileName, ex);
            throw new RuntimeException("Error loading properties file", ex);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    this.logger.warn("Error closing input stream", e);
                }
            }

        }

        return properties;
    }

    private String readStringFromPath(Path resourceDirectory) {
        try {
            try {
                return Files.readString(resourceDirectory);
            } catch (Exception e) {
                this.logger.error("Error reading file content from path: {}", resourceDirectory, e);
                throw new RuntimeException("Error reading file content from path: " + String.valueOf(resourceDirectory));
            }
        } catch (Throwable $ex) {
            throw $ex;
        }
    }

}
