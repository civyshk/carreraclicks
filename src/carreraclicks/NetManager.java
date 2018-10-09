package carreraclicks;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

public class NetManager {

    public static final int DEFAULT_PORT = 41315;

    private Game game;

    /** Representa al jugador local */
    private Player selfPlayer;

    /** Esta clase interna hace de servidor */
    private Server server;

    /* Por este socket se reciben y envían mensajes */
    private DatagramSocket socket;

    public NetManager(Game game){
        this.game = game;
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            System.err.println("No se puede crear el socket");
        }
    }

    public void startServer() {
        stopServer();
        try {
            server = new Server(DEFAULT_PORT);
            server.start();
        }catch(SocketException e) {
            //TODO let caller know this failed start
            e.printStackTrace();
        }
    }

    public void stopServer() {
        if(server != null) {
            server.stopServer();
            server = null;
        }
    }

    private void received(String command, InetAddress from) {

        String[] tokens = command.split(" ", 3);
        if(tokens.length != 2) {
            System.err.println("Received command with erroneous length: " + tokens.length);
            return;
        }

//        switch(tokens[0]) {
//            case "MSG":   receivedMsg  (tokens[1], from); break;
//            case "JOIN":  receivedJoin (tokens[1], from); break;
//            case "LEAVE": receivedLeave(tokens[1], from); break;
//            case "HELLO": receivedHello(tokens[1], from); break;
//            default: System.err.println("Received bad command: " + tokens[0]);; break;
//        }
    }


    protected InetAddress getLocalIP(){
        return null;
    }

    private InetAddress getBroadcastIP(){
        return null;
    }

    /**
     * Launches a thread which accepts incoming messages and redirects
     * them to father NetManager class
     * @author civyshk
     * @version 20180320
     */
    private class Server extends Thread{
        private DatagramSocket serverSocket;
        private boolean running;
        private byte[] buffer;

        public Server(int port) throws SocketException {
            try {
                serverSocket = new DatagramSocket(port);
                serverSocket.setSoTimeout(10000);
                buffer = new byte[2000];
            } catch (SocketException e) {
                throw e;
            }
        }

        public void stopServer() {
            // Pon esta bandera a false para que el bucle infinito de run() acabe
            running = false;

            // Además, manda un mensje STOP a serverSocket para desbloquearlo más rápido
            try {
                InetAddress address = InetAddress.getLocalHost();
                byte[] stop = "STOP".getBytes();
                DatagramPacket packet = new DatagramPacket(stop, stop.length, address, serverSocket.getLocalPort());
                serverSocket.send(packet);
            } catch (IOException e) {
                System.err.println("No se puede enviar STOP al socket local");
            }
        }

        @Override
        public void run() {
            running = true;

            while(running) {
                // Crea un paquete donde se almacenarán los bytes recibidos
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // Recibe bytes desde la red
                try {
                    serverSocket.receive(packet);
                } catch(SocketTimeoutException e) {
                    continue;
                } catch (IOException e) {
                    //TODO avisar a alguien de que el servidor se ha parado
                    e.printStackTrace();
                    running = false;
                }

                // Obtiene la dirección de origen
                InetAddress address = packet.getAddress();

                // Convierte los bytes a un String
                String received;
                try {
                    received = new String(packet.getData(), 0, packet.getLength(), "UTF-8");
                }catch(UnsupportedEncodingException e) {
                    received = new String(packet.getData(), 0, packet.getLength());
                }

                // Delega la interpretación de este mensaje a NetManager
                NetManager.this.received(received, address);

                // El mensaje recibido podría ser un intento local de cerrar el servidor
                if (address.isLoopbackAddress() && received.equals("STOP")) {
                    running = false;
                    continue;
                }
            }
            serverSocket.close();
        }
    }

    public Player getSelfPlayer() {
        return selfPlayer;
    }

}
