package fr.dauphine.sia.app;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import fr.dauphine.sia.display.WelcomePage;

public class App {
    private static Logger LOGGER = Logger.getLogger(App.class);

    public static void main( String[] args ) {
        BasicConfigurator.configure();
        LOGGER.info("Application started...");
        new WelcomePage();
    }
}
