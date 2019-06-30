package fr.dauphine.sia.app;

import fr.dauphine.sia.display.WelcomePage;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class App {
    private static Logger LOGGER = Logger.getLogger(App.class);

    public static void main( String[] args ) {
        BasicConfigurator.configure();
        LOGGER.info("Application started...");
        new WelcomePage();
    }
}
