
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class File {
    String Sent;
    File(int data){
        Sent = Integer.toString(data);
    }
        
    
    public String FILENAME = "C:\\File.txt";

	public void write() {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String content = "0";

			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(content);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}
    
    
    
}
