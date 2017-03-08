package gtintel.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOUtils {

	public static String toString(InputStream inputStream, String encoding) {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));      
        StringBuilder sb = new StringBuilder();      
    
        String line = null;      
       try {      
           while ((line = reader.readLine()) != null) {      
                sb.append(line + "\n");      
            }      
        } catch (IOException e) {      
            e.printStackTrace();      
        } finally {      
           try {      
        	   inputStream.close();      
            } catch (IOException e) {      
                e.printStackTrace();      
            }      
        }      
    
       return sb.toString();
	}

}
