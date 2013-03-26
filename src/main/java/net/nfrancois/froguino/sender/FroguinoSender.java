package net.nfrancois.froguino.sender;

import gnu.io.CommPortIdentifier;

import java.util.Enumeration;

/**
 * Main class of Froguino Server.
 */
public class FroguinoSender {

    public static void main(String[] args) throws Exception {
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
        System.out.println("**** Froguino Sender starting ... ***");
        System.out.println("Avaible port idenfiers :");
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            System.out.println(currPortId.getName());
        }
        System.out.println("Loading properties...");
        String server = PropertiesLoader.getValue(PropertiesLoader.FROGUINO_SERVER);
        String portIdentifier = PropertiesLoader.getValue(PropertiesLoader.PORT_IDENTIFIER);
        System.out.println("server=" + server);
        System.out.println("portIdentifier=" + portIdentifier);
        ServerSender serverSender = new ServerSender(portIdentifier);
        SerialReader serialReader = new SerialReader(server, serverSender);
    }


}
