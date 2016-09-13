package ftpMultithreadedServer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
	private ServerSocket server = null;
	private Socket clientSocket = null;
	private InputStream input = null;
	private OutputStream output = null;
	private FileInputStream fin = null;
	private FileOutputStream fout = null;
	private File file = null;
	private String serverDir = "C:\\Users\\Ankurp\\workspace\\Practice Programs\\src\\fileTransferProtocol\\ServerDirectory";
	
	void listServerDirectory(){
		file = new File(serverDir);
		String[] files = file.list();
		System.out.println("Listing Directory files");
		for(String str: files){
			System.out.println(str);
		}
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			server = new ServerSocket(80);
			System.out.println("Server started at port 80..");
			int counter =0;
			while(true){
				clientSocket = server.accept();
				System.out.println("Server waiting..."+counter);
				new Thread(new ServerHelper(clientSocket,counter)).start();
				counter++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Thread(new Server()).start();
	}

}
