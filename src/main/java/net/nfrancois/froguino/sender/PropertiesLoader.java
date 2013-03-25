package net.nfrancois.froguino.sender;

import java.util.ResourceBundle;

/**
 * Read properties.
 */
public class PropertiesLoader {

    private final static String BUNDLE_NAME = "froguino-sender";
    /**
     * Port identier where the arduino is connected.
     */
    public final static String PORT_IDENTIFIER = "froguino.sender.portIdentifier";
    /**
     * Server where data are sent/
     */
    public final static String FROGUINO_SERVER = "froguino.sender.froguinoServer";

    /**
     * Bundle of Froguino Sender properties.
     */
    private final static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private PropertiesLoader() {
        // Avoid init
    }

    /**
     * Get value from property.
     *
     * @param property The property
     * @return value of property
     */
    public static String getValue(String property) {
        return RESOURCE_BUNDLE.getString(property);
    }

}
