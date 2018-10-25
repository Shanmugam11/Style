package TrainingPrograms;

import java.io.*;

public class FileHandling {

	public static void main(String[] args) {
		try {
			File obj = new File("E:\\Selenium Training\\Training\\data.properties.txt");
			FileReader objrd = new FileReader(obj);
			BufferedReader objbr = new BufferedReader(objrd);
			String line_data;
			//line_data=objbr.readLine();
			
			//while (line_data = )
			//System.out.println("The data in notepad is : " + line_data);
			// TODO Auto-generated method stub
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
