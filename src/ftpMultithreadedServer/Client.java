package ftpMultithreadedServer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable{

	private Socket client = null;
	private int serverPort ;
	private String serverName = null;
	private InputStream input = null;
	private OutputStream output = null;
	private FileInputStream fin = null;
	private FileOutputStream fout = null;
	private String clientDir = "C:\\Users\\Ankurp\\workspace\\Practice Programs\\src\\fileTransferProtocol\\ClientDirectory";
	private File file = null;
	BufferedReader br =null;
	
	Client(String name, int port){
		this.serverPort = port;
		this.serverName = name;
	}
	
	public void download() throws IOException{
		System.out.println("Enter Name of file");
		String filename = br.readLine().trim();
		if(!this.checkFile(filename)){
			input = client.getInputStream();
			fout = new FileOutputStream(clientDir+"\\"+filename);
			int data = input.read();
			while(data!=-1){
				fout.write(data);
				data = input.read();
			}
			fout.close();
			input.close();
		}
	}
	
	public void upload() throws IOException{
		System.out.println("Enter Name of file");
		String filename = br.readLine().trim();
		if(this.checkFile(filename)){
			output = client.getOutputStream();
			fin = new FileInputStream(clientDir+"\\"+filename);
			int data = fin.read();
			while(data!=-1){
				output.write(data);
				data = fin.read();
			}
			fin.close();
			output.close();
		}
	}
	
	public synchronized boolean checkFile(String fileName){
		fileName = clientDir + "\\" + fileName;
		file = new File(fileName);
		if(file.exists()){
			return true;
		}
		else return false;
	}
	
	public synchronized void listAllFiles(){
		file = new File(clientDir);
		String[] files = file.list();
		System.out.println("Listing all files in the diretory");
		int count=1;
		for(String str: files){
			System.out.println(count+". "+str);
			count++;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = new Client("localhost",80);
		new Thread(client).start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			client = new Socket(this.serverName,this.serverPort);
					
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
