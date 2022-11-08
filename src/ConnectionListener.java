import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionListener extends Thread {
    private ServerSocket serverSocket;

    public ConnectionListener() {
        try {
            serverSocket = new ServerSocket(2002, 1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        byte [] data = new byte[1024];
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                int count = socket.getInputStream().read(data);
                String username = new String(data, 0, count);
                System.out.println(username + " has joined...");
                ServerSocketHolder.addSocket(
                        username,
                        socket
                );

                new ServerReaderThread(socket.getInputStream()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
