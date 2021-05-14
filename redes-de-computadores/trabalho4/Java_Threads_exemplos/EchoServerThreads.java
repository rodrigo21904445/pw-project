import java.io.*;
import java.net.*;

public class EchoServerThreads{
	public static void  main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(6500);
		System.out.println("Servidor iniciado no port 6500");
		Socket socket = null;
		while(true){
			socket = server.accept();
			Thread t = new Thread(new ClientThread(socket));
			t.start();
		}
	}


	public static class ClientThread implements Runnable{
		private Socket s;
		
		public ClientThread(Socket socket){
			this.s = socket;
		}

		public void run() {
			String threadName = Thread.currentThread().getName();
			try {
				BufferedReader input;
				input = new BufferedReader(new InputStreamReader(s.getInputStream()));
				PrintStream output = new PrintStream(s.getOutputStream());
				String linha = input.readLine();
				System.out.println(threadName + " " + linha);
				output.println(linha);
				s.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
}