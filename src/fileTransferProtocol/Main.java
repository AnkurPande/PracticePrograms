package fileTransferProtocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		Client client = new Client();
		Thread serverStarter =  new Thread(server);
		serverStarter.start();
		Thread clientStarter = new Thread(client);
		clientStarter.start();
		
		/*Console Query Interface*/
		/////////////////////////////
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		String fileName = null;
		System.out.println("Enter Options-> D - Download, U-Upload, LC- List client Directory, LS-List Server Directory,E-Exit");
		try {
			String input = br.readLine().trim();
			while(input!="E"){
				switch(input){
				  	case "D": server.listServerDirectory();
				  			  System.out.println("Enter the name of file to download.");
							  fileName = br.readLine().trim();
							  server.sendFile(fileName);
							  client.downloadFile(fileName); 
							  break;
					case "U": client.listClientDirectory();
		  			  		  System.out.println("Enter the name of file to Upload.");
		  			  		  fileName = br.readLine().trim();
		  			  		  client.uploadFile(fileName); 
		  			  		  server.saveFile(fileName);
					          break;
					case "LC": client.listClientDirectory();
					          break;
					case "LS": server.listServerDirectory();
					          break;
					default:
						break;
				}
				System.out.println("Enter Options-> D - Download, U-Upload, LC- List client Directory, LS-List Server Directory,E-Exit");
				input = br.readLine().trim();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException encountered"+e.getMessage());
		}
	}

}
