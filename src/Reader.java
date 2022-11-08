import java.io.InputStream;

public class Reader extends Thread {

    private InputStream in;
    private boolean flag = true;

    public Reader(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {

        byte [] data = new byte [1024];
        int count;
        try {
            while (flag) {
                if (in.available() > 0) {
                    count = in.read(data);
                    String message = new String(data, 0, count);
                    String [] parts = message.split(":");
                    System.out.println(parts[0] + ": " + parts[2]);
                }
            }
            in.close();
        }
        catch (Exception e) {

        }

    }

    public void terminate() {
        flag = false;
    }
}
