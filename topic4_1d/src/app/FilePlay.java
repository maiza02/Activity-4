package app;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * The FilePlay class provides methods for copying the content of one file to another
 * and handling file input/output operations using BufferedReader and BufferedWriter.
 */
public class FilePlay {
	
	
	  /**
     * The main method of the FilePlay class.
     *
     * @param args The command-line arguments passed to the program.
     * @throws FileNotFoundException If the specified file is not found.
     * @throws IOException           If an I/O error occurs while reading or writing the file.
     */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// Call method to copy files 
		copyFile("InFile.txt", "OutFile.txt");
		
		
	// Call method to read/write files 
	try {
		
		// Call method to read/write files and display any errors
		FilePlay.copyFile("InUsers.txt", "OutUsers.txt");
		System.out.println("File was copied successfully"); 
	}
	catch (FileNotFoundException e) {
		// Catch file not found error 
		e.printStackTrace(); 
		System.out.println("File could not be opened."); 
	}
	catch (IOException e) {
		// Catch I/O errors 
		e.printStackTrace(); 
		System.out.println("File I/O error."); 
	}
		
}
    
	 /**
     * Copies the content of one file to another, processing each line to extract information.
     *
     * @param inFile  The path of the input file.
     * @param outFile The path of the output file.
     * @throws FileNotFoundException If the specified file is not found.
     * @throws IOException           If an I/O error occurs while reading or writing the file.
     */
    private static void copyFile(String inFile, String outFile)throws FileNotFoundException, IOException {
        // Input and output File Read/Writer declarations
    	BufferedReader  in = null;
    	BufferedWriter  out = null;

        try {
            // Create Reader and Writer 
            in = new BufferedReader(new FileReader(inFile));
            out = new BufferedWriter(new FileWriter(outFile));

            // Loop to read all characters from FileReader and write to FileWriter 
            String line;
            while ((line = in.readLine()) != null) {
               
            	String[] tokens = line.split("\\|");
            	out.write(String.format("Name is %s %s of age %s\n", tokens[0], tokens[1], tokens[2]));
            }
      
        }finally {
            try {
                // Close FileReader and FileWriter in the finally block to ensure they are closed
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace(); // Handle closing error if necessary
            }
        }
    }
}