import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {

        System.out.println("Enter username: ");
        String username = new Scanner(System.in).nextLine();

        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 2002);
            socket.getOutputStream().write(username.getBytes());

            new Reader(socket.getInputStream()).start();
            new Writer(socket.getOutputStream()).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
