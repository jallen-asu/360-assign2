//       Name: Jack Allen
//         ID: 1212661409
//	 Class ID: 163
// Assignment: Assignment 1
//    Lecture: M 3:05 PM, Online

import java.util.Arrays;

//Simple list class.  Build onto an integer array ("list") of size 10.  "count" is used to maintain the working size of the list, as to not print unused
//elements of the list.  Methods are used for adding, removing, printing, and sizing the list.  Only constructor is a default.
//
public class SimpleList
{
    private int[] list, tempList;
    private int count, currentSize;

    //constructor initializes the variables
    public SimpleList()
    {
        count = 0;
        currentSize = 10;
        list = new int[10];
    }

    //adds an integer to the front (index 0) of the list.  moves all elements to the right
    //if list is full, size of list is increased by 50%
    public void add(int input)
    {
        if(count == currentSize)                    //if list is full
        {
            currentSize = (int)(currentSize * 1.5);

            tempList = new int[count];
            tempList = Arrays.copyOf(list, count);

            list = new int[currentSize];

            for(int i = 0; i < count; i++)
            {
                list[i] = tempList[i];
            }
        }

        count++;

        for(int i = count-1; i > 0; i--)
        {
            list[i] = list[i-1];
        }

        list[0] = input;
    }
    
    //appends the input integer to the end of the list
    //if list is full, size of list is increased by 50%
    public void append(int input)
    {
    	if(count == currentSize)                    //if list is full
        {
            currentSize = (int)(currentSize * 1.5);

            tempList = new int[count];
            tempList = Arrays.copyOf(list, count);

            list = new int[currentSize];

            for(int i = 0; i < count; i++)
            {
                list[i] = tempList[i];
            }
        }
    	
    	list[count] = input;
    	
    	count++;
    }

    //removes all occurrences of an integer from the list.  decrements count each time.
    //if list gets more than 25% empty, size is decreased by 25%
    public void remove(int input)
    {
        int index = search(input);

        while(index != -1)
        {
            count--;

            for(int i = index; i < count; i++)
            {
                list[i] = list[i + 1];
            }

            index = search(input);
        }
        
        //more than 25% empty
        if( ((float)(currentSize - count) / (float)(currentSize)) > 0.25f && currentSize > 1)
        {
            currentSize = (int)(currentSize * .75);

            tempList = new int[count];
            tempList = Arrays.copyOf(list, count);
            
            list = new int[currentSize];

            for(int i = 0; i < count; i++)
            {
                list[i] = tempList[i];
            }
        }
    }

    //returns the number of elements stored in the list
    public int count()
    {
        return count;
    }

    //returns the list as a string.  each element is separated by a space.
    public String toString()
    {
        String returnString = "";

        for(int i = 0; i < count; i++)
        {
            returnString = returnString + list[i];
            if(i < count-1)
            {
                returnString = returnString + " ";
            }
        }

        return returnString;
    }

    //finds the first occurrence of an integer in the list and returns that index.  linear search
    public int search(int input)
    {
        for(int i = 0; i < count; i++)
        {
            if(list[i] == input)
            {
                return i;
            }
        }

        return -1;
    }
    
    //gets value of first entry in list.  returns -1 if list is empty
    public int first()
    {
    	int returnVal;
    	
    	if(count > 0)
    	{
    		returnVal = list[0];
    	}
    	else
    	{
    		returnVal = -1;
    	}
    	
    	return returnVal;
    }
    
    //gets value of last entry in list.  returns -1 if list is empty
    public int last()
    {
    	int returnVal;
    	
    	if(count > 0)
    	{
    		returnVal = list[count - 1];
    	}
    	else
    	{
    		returnVal = -1;
    	}
    	
    	return returnVal;
    }
    
    //returns current capacity of list
    public int size()
    {
    	return currentSize;
    }
}
