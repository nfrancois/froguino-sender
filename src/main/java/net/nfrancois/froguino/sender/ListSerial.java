package net.nfrancois.froguino.sender;

import gnu.io.CommPortIdentifier;

import java.util.Enumeration;

/**
 * List all avaible serial to help finding port identifier.
 */
public class ListSerial {

    public static void main(String[] args) throws Exception {
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            System.out.println(currPortId.getName());
        }
    }

}
