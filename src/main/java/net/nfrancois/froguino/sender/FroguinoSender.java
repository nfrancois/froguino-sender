package net.nfrancois.froguino.sender;

/**
 * Main class of Froguino Server.
 */
public class FroguinoSender {

    public static void main(String[] args) throws Exception {
        System.out.println("**** Froguino Sender starting ... ***");
        System.out.println("Loading properties...");
        String server = PropertiesLoader.getValue(PropertiesLoader.FROGUINO_SERVER);
        String portIdentifier = PropertiesLoader.getValue(PropertiesLoader.PORT_IDENTIFIER);
        System.out.println("Avaible port idenfiers :");
        SerialReader.listAvaiblePorts();

        System.out.println("server=" + server);
        System.out.println("portIdentifier=" + portIdentifier);
        ServerSender serverSender = new ServerSender(server);
        SerialReader serialReader = new SerialReader(portIdentifier, serverSender);
    }


}
