package bd;

import listener.ListenerConnexion;

public class Service {

private static String service= ListenerConnexion.getBDHService();

    public static String getService(){ return service;}
}
