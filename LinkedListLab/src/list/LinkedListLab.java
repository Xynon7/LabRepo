package list;

import java.util.LinkedList;

public class LinkedListLab
{
	public static void main(String[] args)
	{
		//Creating two linked lists
		LinkedList<String> firstList = new LinkedList<String>();
		LinkedList<String> secondList = new LinkedList<String>();

		//Adding beginning elements to list
		firstList.add("Tulsa");
		firstList.add("Ada");
		firstList.add("Broken Arrow");
		firstList.add("Owasso");
		
		//Adding OKC as second element in first LinkedList
		firstList.add(1, "OKC");
		
		//Adding beginning elements to second list
		secondList.add("74104");
		secondList.add("74135");
		secondList.add("foo");
		secondList.add("hello world");
		secondList.add("777");
		
		//Merging second list to first list
		firstList.add(5, "777");
		firstList.add(4, "hello world");
		firstList.add(3, "foo");
		firstList.add(2, "74135");
		firstList.add(1, "74104");
		
		//Removing every other element from second list
		for (int i = 1; i < firstList.size(); i++)
		{
			firstList.remove(i);
		}
		
		LinkedList<String> deepCopy = new LinkedList<String>();
		for (String item : secondList)
		{
			deepCopy.add(item);
		}
	}
}
