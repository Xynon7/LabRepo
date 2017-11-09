package lab11;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PlayWithFiles {

	public static void main(String[] args) throws IOException {
		Path p1 = Paths.get("C:\\Backup\\SPEED\\SPEED_20171102_1of10.txt");
		Path p2 = Paths.get("C:\\Backup");
		
		System.out.format("getFileName: %s%n", p1.getFileName());
		System.out.format("getRoot: %s%n", p2.getRoot());
		
		
		if(Files.isReadable(p1)&Files.isExecutable(p1)&Files.isRegularFile(p1))
			System.out.println("Good!");
		else
			System.out.println("Not a valid file path!");
		
	
		//Files.delete(p1);
		
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:s*.txt*");
		
		Path filename = p1.getFileName();
		if(matcher.matches(filename)) 
			System.out.println(filename);
		else
			System.out.println("no match");
			
		
	}

}