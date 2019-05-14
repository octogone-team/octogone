package fr.dauphine.sia.app;

import fr.dauphine.sia.display.WelcomePage;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import static fr.dauphine.sia.constants.LoggerConstants.*;

public class App {
    private static Logger LOGGER = Logger.getLogger(App.class);

    public static void main( String[] args ) {
        BasicConfigurator.configure();
        LOGGER.info(APPLICATION_START);
        new WelcomePage();
    }
}
