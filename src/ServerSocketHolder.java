import java.net.Socket;
import java.util.HashMap;

public class ServerSocketHolder {
    private static HashMap<String, Socket> sockets;

    static  {
        sockets = new HashMap<String, Socket>();
    }

    public static void addSocket(String username, Socket socket) {
        sockets.put(username, socket);
    }

    public static Socket getSocket(String username) {
        return sockets.get(username);
    }
}
