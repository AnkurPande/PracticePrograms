import java.util.Scanner;


public class CaesarCipher {

	protected char[] encoder = new char[26];
	protected char[] decoder = new char[26];
	
	public CaesarCipher(int rotation){
		for(int j =0;j<26; j++){
			encoder[j] = (char)('A'+(j+rotation)%26);
			decoder[j] = (char)('A'+(j-rotation+26)%26);
		}
	}
	
	public String transform(String message, char[] code){
		char[] orig = message.toCharArray();
		for(int k=0;k<orig.length;k++){
			if(Character.isUpperCase(orig[k]))
			{
				int j = orig[k] - 'A';
				orig[k] = code[j];
			}
		}
		return new String(orig);
	}
	
	public String encrypt(String message){
		return transform(message, encoder);
	}
	
	public String decrypt(String message){
		return transform(message, decoder);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CaesarCipher encryption = new CaesarCipher(10);
		System.out.println("ENTER THE MESSAGE TO ENCRYPT: ");
		String msg;
		Scanner sc = new Scanner(System.in);
		msg = sc.nextLine();
		msg = encryption.encrypt(msg);
		System.out.println("Encryted Message: "+ msg);
		msg = encryption.decrypt(msg);
		System.out.println("Original Message: "+ msg);
		sc.close();
	}

}
