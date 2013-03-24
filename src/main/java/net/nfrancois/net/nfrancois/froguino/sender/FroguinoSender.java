package net.nfrancois.net.nfrancois.froguino.sender;

import gnu.io.NoSuchPortException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
