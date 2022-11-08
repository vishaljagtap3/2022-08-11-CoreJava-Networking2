import java.io.InputStream;

public class ServerReaderThread extends Thread{
    private InputStream in;

    public ServerReaderThread(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        byte [] data = new byte[1024];
        int count;
        try {
            while(true) {
                if(in.available() > 0) {
                    count = in.read(data);
                    String message = new String(data, 0, count);
                    String [] parts = message.split(":");
                    ServerSocketHolder.getSocket(parts[1])
                            .getOutputStream()
                            .write(message.getBytes());
                }
            }
        }
        catch (Exception e){}
    }
}
