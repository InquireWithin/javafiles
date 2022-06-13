package misc_io; 

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {

    public void readFromFile(String filename) throws IOException{
        FileReader fr = new FileReader("data/alice.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        while((line = br.readLine())!=null){
            System.out.println(line);
        }

    }
    public static void main(String[] args) {
        
    }
}
