import java.io.OutputStream;
import java.util.Scanner;

public class Writer extends Thread {

    private OutputStream out;
    private boolean flag = true;

    public Writer(OutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            while(flag) {
                out.write(
                        scanner.nextLine().getBytes()
                );
            }
            out.close();
        }
        catch (Exception e) {

        }
    }

    public void terminate() {
        flag = false;
    }
}
