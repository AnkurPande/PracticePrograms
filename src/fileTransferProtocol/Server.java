package fileTransferProtocol;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
	private ServerSocket server = null;
	private Socket clientSocket = null;
	private InputStream input = null;
	private OutputStream output = null;
	private FileInputStream fin = null;
	private FileOutputStream fout = null;
	private File file = null;
	private String serverDir = "C:\\Users\\Ankurp\\workspace\\Practice Programs\\src\\fileTransferProtocol\\ServerDirectory";
	
	void saveFile(String fileName) throws IOException{
		fileName = serverDir + "\\" +fileName;
		file = new File(fileName);
		if(!file.exists()){
			System.out.println("Saving File"+fileName);
			fout = new FileOutputStream(file);
			input = clientSocket.getInputStream();
			int data = input.read();
			while(data!=-1){
			
				fout.write(data);
				data = input.read();
			}
			input.close();
			fout.close();
		}
		
	}
	
	void sendFile(String fileName) throws IOException{
		fileName = serverDir + "\\" +fileName;
		file = new File(fileName);
		if(file.exists()){
			System.out.println("Sending File"+fileName);
			fin  = new FileInputStream(file);
			output = clientSocket.getOutputStream();
			int data = fin.read();
			while(data!=-1){
	
				output.write(data);
				data = fin.read();
			}
			output.close();
			fin.close();
		}
	}
	
	void listServerDirectory(){
		file = new File(serverDir);
		String[] files = file.list();
		System.out.println("Listing Directory files");
		for(String str: files){
			System.out.println(str);
		}
	}
	
	public static void main(String[] args){
		Server server = new Server();
		server.listServerDirectory();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			server = new ServerSocket(80);
			System.out.println("Server started at port 80..");
			while(true){
				clientSocket = server.accept();
				System.out.println("Server waiting...");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
