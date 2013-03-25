package net.nfrancois.froguino.sender;

/**
 * Main class of Froguino Server.
 */
public class FroguinoSender {

    public static void main(String[] args) throws Exception {
        // TODO read properties
        ServerSender serverSender = new ServerSender("http://froguino.appspot.com");
        SerialReader serialReader = new SerialReader("/dev/tty.usbmodemfd131", serverSender);
    }


}
