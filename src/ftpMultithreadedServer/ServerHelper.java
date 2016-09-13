package ftpMultithreadedServer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerHelper implements Runnable {
	private Socket clientSocket = null;
	private InputStream input = null;
	private OutputStream output = null;
	private FileInputStream fin = null;
	private FileOutputStream fout = null;
	private File file = null;
	private int helperInstanceNum ;
	private String serverDir = "C:\\Users\\Ankurp\\workspace\\Practice Programs\\src\\fileTransferProtocol\\ServerDirectory";
	
	ServerHelper(Socket sock, int num){
		this.clientSocket = sock;
		this.helperInstanceNum = num;
	}
	
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
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
	}
}
