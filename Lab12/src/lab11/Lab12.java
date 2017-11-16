package lab11;

import java.io.File;
import java.util.Scanner;

public class Lab12
{
	File studentInputFile = new File("students.in");
	
	public static void main(String[] args)
	{
		Lab12 lab = new Lab12();
		BinarySearchTree<StudentGPA> GPABST = lab.createGPABinaryST();
		TreeIterator<StudentGPA> treeIterator = new TreeIterator<StudentGPA>(GPABST, 0);
		while(treeIterator.hasNext())
		{
			StudentGPA nextStudent = treeIterator.next();
			if (nextStudent instanceof GraduateStudentGPA)
			{
				GraduateStudentGPA nextGradStudent =  (GraduateStudentGPA) nextStudent;
				System.out.print(nextGradStudent.id + " ");
				System.out.print(nextGradStudent.name + " ");
				System.out.print(nextGradStudent.GPA + " ");
				System.out.print(nextGradStudent.advisor);
			}
			else
			{
				System.out.print(nextStudent.id + " ");
				System.out.print(nextStudent.name + " ");
				System.out.print(nextStudent.GPA + " ");
			}
			System.out.println();
		}
	}
	
	BinarySearchTree<StudentGPA> createGPABinaryST()
	{
		BinarySearchTree<StudentGPA> GPABST = new BinarySearchTree<StudentGPA>();
		Scanner scanner = null;
		
		try
		{
			scanner = new Scanner(studentInputFile);
			while (scanner.hasNextLine())
			{
				String nextStudentData = scanner.nextLine();
				String[] splitData = nextStudentData.split(" ");
				StudentGPA nextStudent = null;
				if (splitData.length == 3)
				{
					nextStudent = new StudentGPA(Integer.parseInt(splitData[0]), splitData[1], Double.parseDouble(splitData[2]));
				}
				else if (splitData.length == 4)
				{
					nextStudent = new GraduateStudentGPA(Integer.parseInt(splitData[0]), splitData[1], Double.parseDouble(splitData[2]), splitData[3]);
				}
				
				if (nextStudent != null)
				{
					GPABST.insert(nextStudent);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			scanner.close();
		}
		
		return GPABST;
	}
	
}
