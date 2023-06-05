package org.example;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
public class Utility {
    public static boolean checkForResponse() {
        String ipAddress = getIPAddress();
        int timeout = 5000;
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            boolean isReachable = address.isReachable(timeout);
            return isReachable;
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + ipAddress);
        } catch (IOException e) {
            System.err.println("Error checking connection to: " + ipAddress);
            System.exit(1);
        }
        return false;
    }
    public static boolean checkWebsite(String website){
        String url="https://web.whatsapp.com/";
        return website.equals(url);
    }
    private static String getIPAddress(){
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            return localhost.getHostAddress();
        } catch (UnknownHostException e) {
            return null;
        }
    }

    public static boolean isInternetConnected() {
        String[] websites = {"https://www.google.com", "https://www.example.com"};
        for (String website : websites) {
            try {
                URL url = new URL(website);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int statusCode = connection.getResponseCode();
                if (statusCode != HttpURLConnection.HTTP_OK) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }



}
