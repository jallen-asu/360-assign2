//       Name: Jack Allen
//         ID: 1212661409
//	 Class ID: 163
// Assignment: Assignment 1
//    Lecture: M 3:05 PM, Online

//Simple list class.  Build onto an integer array ("list") of size 10.  "count" is used to maintain the working size of the list, as to not print unused
//elements of the list.  Methods are used for adding, removing, printing, and sizing the list.  Only constructor is a default.
//
public class SimpleList
{
    private int[] list;
    private int count;

    //constructor initializes the variables
    public SimpleList()
    {
        count = 0;
        list = new int[10];
        //heap allocated
    }

    //adds an integer to the front (index 0) of the list.  moves all elements to the right, dropping the 10th element if present
    public void add(int input)
    {
        if(count < 10)
        {
            count++;
        }

        for(int i = count-1; i > 0; i--)
        {
            list[i] = list[i-1];
        }

        list[0] = input;
    }

    //removes all occurrences of an integer from the list.  decrements count each time
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

    //finds the first occurrence of an integer in the list and returns that index.  iterative search
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
}
