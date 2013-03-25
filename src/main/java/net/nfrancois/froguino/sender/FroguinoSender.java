package net.nfrancois.froguino.sender;

/**
 * Main class of Froguino Server.
 */
public class FroguinoSender {

    public static void main(String[] args) throws Exception {
        String server = PropertiesLoader.getValue(PropertiesLoader.FROGUINO_SERVER);
        String portIdentifier = PropertiesLoader.getValue(PropertiesLoader.PORT_IDENTIFIER);
        System.out.println("server=" + server);
        ServerSender serverSender = new ServerSender(portIdentifier);
        SerialReader serialReader = new SerialReader(server, serverSender);
    }


}
