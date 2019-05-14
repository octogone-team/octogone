package fr.dauphine.sia.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import static fr.dauphine.sia.constants.LoggerConstants.*;

import org.apache.log4j.Logger;

public class PropertiesLoader {
    private static Logger LOGGER = Logger.getLogger(PropertiesLoader.class);

    public static Properties get(String propertiesFilename) {
    	Properties properties = new Properties();
        try (InputStream input = PropertiesLoader.class.getClassLoader().getResourceAsStream(propertiesFilename)) {

            if (input == null) {
            	LOGGER.error(LOADING_PROPERTIES_FAIL + propertiesFilename);
            	return properties;
            }

            properties.load(input);
            LOGGER.info(LOADING_PROPERTIES_SUCCESS + propertiesFilename);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
}
}
