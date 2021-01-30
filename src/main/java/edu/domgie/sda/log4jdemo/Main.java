package edu.domgie.sda.log4jdemo;

import org.apache.log4j.Logger;

public class Main {

    /**
     * Pole finalne czyli jak stala wiec duze litery
     * dobra praktyka jest zakladanie osobnego logera w kazdej klasie
     * czyli np w Banku osobne instancje w Bank,Customer,Account
     */
    final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.error("This is error");
        LOGGER.warn("This is warning");
        LOGGER.fatal("fatal error mesage");
        LOGGER.debug("Debug");
        LOGGER.info("info message");

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Another info message");
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("And again debug");
        }
        Main main = new Main();
        try {
            main.divide(3, 4);
        } catch (ArithmeticException e) {
            LOGGER.error("ERROR: "+e.getMessage());
        }
    }

    private void divide(int a, int b) {
        LOGGER.info("Trying to divide " + a + " by " + b);
        int i = a / b;
    }

}
