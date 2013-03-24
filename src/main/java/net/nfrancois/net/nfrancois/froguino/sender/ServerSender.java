package net.nfrancois.net.nfrancois.froguino.sender;

import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.*;

/**
 * Send data to GAE Server.
 */
public class ServerSender {

    private static final String TEMPERATURE_RESOURCE = "%s/temperature?t=%s";

    /** Froguino Server serverUrl */
    private String serverUrl;

    /**
     *
     * @param url   Froguino server serverUrl
     */
    public ServerSender(String url) {
        this.serverUrl = url;
    }

    /**
     * Send data to server
     * @param value value
     * @return
     */
    public boolean send(Double value) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(String.format(TEMPERATURE_RESOURCE, serverUrl, value.toString()));
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.close();
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK){
                return true;
            } else {
                System.out.println("status code = "+responseCode);
                return false;
            }
        } catch (Exception e) {
            // TODO Log
            System.out.println(e);
            return false;
        } finally {
            if(connection != null){
                connection.disconnect();
            }
        }
    }

}
