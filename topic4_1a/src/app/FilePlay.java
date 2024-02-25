package app;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The FilePlay class provides methods for copying the content of one file to another
 * and handling file input/output operations.
 */
public class FilePlay {
	
	/**
     * The main method of the FilePlay class.
     *
     * @param args The command-line arguments passed to the program.
     */
	public static void main(String[] args) {
		// Call method to copy files 
		copyFile("InFile.txt", "OutFile.txt");
		
		// Call method to read/write files
		int err = FilePlay.copyFile("InUsers.txt", "OutUsers.txt");
		
		// Display copy file results
		switch(err) {
		 
		case 0: 
			System.out.println("File was copied successfully."); 
			break;
		case -1:
			System.out.println("File could not be opened.");
			break;
		case -2:
			System.out.println("File I/O error."); 
			break; 
		}
    }
	
	
	 /**
     * Copies the content of one file to another.
     *
     * @param inFile  The path of the input file.
     * @param outFile The path of the output file.
     * @return 0 if the file was copied successfully, -1 if the file could not be opened, -2 if there was a file I/O error.
     */
    private static int copyFile(String inFile, String outFile) {
        // Input and output File Read/Writer declarations
        FileReader  in = null;
        FileWriter  out = null;

        try {
            // Create Reader and Writer 
            in = new FileReader(inFile);
            out = new FileWriter(outFile);

            // Loop to read all characters from FileReader and write to FileWriter 
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            return 0; // Success
        } catch (IOException e) {
            // Handle IOException (File I/O error)
            return -2;
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