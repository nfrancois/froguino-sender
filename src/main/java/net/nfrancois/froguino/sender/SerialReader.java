package net.nfrancois.froguino.sender;

import gnu.io.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Read data from Serial Port
 */
public class SerialReader implements SerialPortEventListener {

    /**
     * Separator between sensor name and  sensor value
     */
    private final static String DATA_MESSAGE_SEPARATOR = ":";

    /**
     * Communication port
     */
    private final CommPortIdentifier portId;

    private SerialPort serialPort;

    private ServerSender serverSender;

    /**
     * Milliseconds to block while waiting for port open
     */
    private static final int TIME_OUT = 2000;
    /**
     * Default bits per second for COM port.
     */
    private static final int DATA_RATE = 9600;

    /**
     * A BufferedReader which will be fed by a InputStreamReader
     * converting the bytes into characters
     * making the displayed results codepage independent
     */
    private BufferedReader input;

    /**
     * Default constructor.
     *
     * @param portIdentifier Communication port identifier
     * @throws NoSuchPortException
     */
    public SerialReader(String portIdentifier, ServerSender serverSender) throws Exception {
        portId = CommPortIdentifier.getPortIdentifier(portIdentifier);
        this.serverSender = serverSender;
        // portId = CommPortIdentifier.getPortIdentifier("/dev/tty.usbmodemfd131");

        //
        // open serial port, and use class name for the appName.
        serialPort = (SerialPort) portId.open(this.getClass().getName(),
                TIME_OUT);

        // set port parameters
        serialPort.setSerialPortParams(DATA_RATE,
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);

        //serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);

        // open the streams
        input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
        //output = serialPort.getOutputStream();

        // add event listeners
        serialPort.addEventListener(this);
        serialPort.notifyOnDataAvailable(true);

    }


    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        if (serialPortEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String message = input.readLine();
                System.out.println(message);
                // TODO check value
                Double value = Double.parseDouble(message.split(DATA_MESSAGE_SEPARATOR)[1]);
                serverSender.send(value);
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
    }
}
