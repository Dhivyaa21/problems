import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("127.0.0.1", 5000)) {
            System.out.println("Connection established to port " + socket.getPort());

            Scanner scanner = new Scanner(System.in);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner in = new Scanner(socket.getInputStream());

            while(scanner.hasNextLine()) {
                out.println(scanner.nextLine());
                System.out.println("server response - " + in.nextLine());
            }
        }
    }
}
