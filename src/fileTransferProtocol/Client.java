package fileTransferProtocol;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client implements Runnable {
	private Socket sock = null;
	private File file = null;
	private OutputStream output = null;
	private InputStream input = null;
	private String clientDir = "C:\\Users\\Ankurp\\workspace\\Practice Programs\\src\\fileTransferProtocol\\ClientDirectory";
	
	void downloadFile(String fileName) throws IOException{
		fileName = clientDir + "\\" +fileName;
		file = new File(fileName);
		if(!file.exists()){
			System.out.println("Downloading File"+fileName);
			output = new FileOutputStream(file);
			input = sock.getInputStream();
			int data = input.read();
			while(data!=-1){
				
				output.write(data);
				data = input.read();
			}
			input.close();
			output.close();
		}
		this.reviveConnection();
	}
	
	void uploadFile(String fileName) throws IOException{
		fileName = clientDir + "\\" +fileName;
		file = new File(fileName);
		if(file.exists()){
			System.out.println("Uploading File"+fileName);
			input = new FileInputStream(file);
			output = sock.getOutputStream();
			int data = input.read();
			while(data!=-1){
			
				output.write(data);
				data = input.read();
			}
			output.close();
			input.close();
		}
		this.reviveConnection();
	}
	
	void listClientDirectory(){
		file = new File(clientDir);
		String[] files = file.list();
		System.out.println("Listing Directory files");
		for(String str: files){
			System.out.println(str);
		}
	}
	
	void reviveConnection(){
		try{
			 sock = new Socket("localhost",80);
			 System.out.println("Client connnected to server at port 80..");
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	public static void main(String[] args) throws IOException{
		Client client = new Client();
		client.listClientDirectory();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.reviveConnection();
	}
}
