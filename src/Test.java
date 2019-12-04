import java.io.File;
import java.io.IOException;

public class Test {

	
public static void main(String args[])
{
	String fileSeparator = System.getProperty("file.separator");
    
    //absolute file name with path
    String absoluteFilePath = fileSeparator+"Bridgelabz"+fileSeparator+"src"+fileSeparator+"com"+fileSeparator+"bridgelabz"+fileSeparator+"oops"+fileSeparator+"addressbook"+fileSeparator+"file.txt";
  
    File file = new File(absoluteFilePath);
    try {
		if(file.createNewFile()){
		    System.out.println(absoluteFilePath+" File Created");
		}else System.out.println("File "+absoluteFilePath+" already exists");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    //file name only
    file = new File("file.txt");
    try {
		if(file.createNewFile()){
		    System.out.println("file.txt File Created in Project root directory");
		}else System.out.println("File file.txt already exists in the project root directory");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    //relative path
    String relativePath = "tmp"+fileSeparator+"file.txt";
    file = new File(relativePath);
    try {
		if(file.createNewFile()){
		    System.out.println(relativePath+" File Created in Project root directory");
		}else System.out.println("File "+relativePath+" already exists in the project root directory");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
