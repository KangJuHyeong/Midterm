package openmidtest;

import java.io.IOException;

import javax.xml.transform.TransformerException;

public class Main {

	public static void main(String[] args) throws TransformerException, IOException {
		// TODO Auto-generated method stub
		String command = args[0];   
		String path = args[1];
		String command2 =args[2];
		String query=args[3];
		if(command.equals("-m")) {
			MidTerm md=new MidTerm(path,query);
			md.showSnippet();

		}
	}

}
