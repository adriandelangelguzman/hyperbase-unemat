package br.colider.unemat.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	
	private Properties props;
	
	public LoadProperties(){
		 File file = new File("src/br/colider/unemat/hyperbase.properties");      
		 props = new Properties();  
		 FileInputStream fis = null;  
		 try {  
		     fis = new FileInputStream(file);
		     props.load(fis);    
		     fis.close();  
		 }  
		 catch (IOException ex) {  
		     System.out.println(ex.getMessage());  
		     ex.printStackTrace();  
		 }  
	}
	
	public String getProjetoDir(){
		return props.getProperty("projeto.dir");
	}
	
	public String getMongrafiaDir(){
		return props.getProperty("monografia.dir");
	}
}
