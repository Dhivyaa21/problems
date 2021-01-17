import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("chat server is running");
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Client accepted");
                    Scanner in = new Scanner(socket.getInputStream());
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                    while (in.hasNextLine()) {
                        String line = in.nextLine();
                        System.out.println("client request - " + line);
                        if (line.contains("how are you")) {
                            out.println("I am fine. Thanks!");
                        }
                        else {
                            out.println(line);
                        }
                    }
                }
            }
        }

    }
}
