package lab11;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.Scanner;

public class BackupFileValidator {

	public static void main(String[] args)
	{
		BackupFileValidator bfv = new BackupFileValidator();
		Path rootBackupFolder = bfv.retrieveBackupPath();
		if (bfv.checkApolloSet(rootBackupFolder))
		{
			System.out.println("Apollo is complete.");
		}
		else
		{
			System.out.println("Apollo is incomplete.");
		}
	}
	
	public Path retrieveBackupPath()
	{
		boolean gettingInput = true;
		Path root = null;
		Scanner scan = new Scanner(new BufferedInputStream(System.in));
		
		System.out.println("Please enter the path of the Backup folder (eg. C:\\Backup)");
		while (gettingInput)
		{
			try
			{
				String input = scan.nextLine();
				root = Paths.get(input);
				System.out.println("That path is valid. Continuing...");
				gettingInput =  false;
			}
			catch (Exception e)
			{
				System.out.println("Enter a valid path.");
			}
		}
		scan.close();
		return root;
	}
	
	public void cleanSpeed(Path rootPath)
	{
		
	}
	
	public boolean checkApolloSet(Path rootPath)
	{
		File apolloFolder = new File(rootPath + "\\APOLLO");
		int numOfBackupFilesNeeded = 4;
		int numOfBackupFilesFound = 0;
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher(String.format("glob:APOLLO_*_%dof%d.txt.txt", numOfBackupFilesFound+1, numOfBackupFilesNeeded));
		
		for (File posBackupFile : apolloFolder.listFiles())
		{
			if (matcher.matches(posBackupFile.toPath()))
			{
				numOfBackupFilesFound++;
				System.out.printf("Found Apollo backup %d \n", numOfBackupFilesFound);
				matcher = FileSystems.getDefault().getPathMatcher(String.format("glob:*APOLLO_*_%dof%d.txt", numOfBackupFilesFound+1, numOfBackupFilesNeeded));
			}
		}
		
		if (numOfBackupFilesFound == numOfBackupFilesNeeded)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
