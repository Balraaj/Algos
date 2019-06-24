package com.example.practice.problems;

/**
 * Given a string of characters replace every space character with %20
 */
public class Urlify {
    public static String getEncoded(String str){
        return str.replace(" ", "%20");
    }


    private static void changeString(char[] arr,int length)
    {
        int spaceCount=0;
        for(int i=0;i<length;i++)
        {
            if(arr[i]==' ')
            {
                spaceCount++;
            }
        }

        int index=length+spaceCount*2;
        arr[index]='\0';

        for(int i=length-1;i>=0;i--)
        {
            if(arr[i]==' ')
            {
                arr[index-1]='0';
                arr[index-2]='2';
                arr[index-3]='%';
                index=index-3;
            }
            else
            {
                arr[index-1]=arr[i];
                index=index-1;
            }
        }
    }

    public static void main(String[] args)
    {
        char[] arr="hello he is we            ".toCharArray();
        System.out.println("Length of array before call : "+arr.length);
        changeString(arr,14);
        System.out.println("Length of array after call  : "+arr.length);

        for(char c:arr)
        {
            System.out.print(c);
        }
    }
}
