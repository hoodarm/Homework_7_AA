package com.company;

import ibcsutils.ReadViaURL;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        long time1 = System.nanoTime();
        String address = "https://www-personal.umich.edu/~jlawler/wordlist";
        String[] words = ReadViaURL.readWords(address, true, true, true);

        List<String> EnglishWords = Arrays.asList(words);
        Collections.shuffle(EnglishWords);
        EnglishWords.toArray(words);

        for (int i = 0; i<69903; i++)
        {
            int indSmallest = i;
            //find index of smallest
            for (int j = i+1; j<69903;j++)
            {
                if (words[j].compareTo(words[indSmallest]) < 0)
                    indSmallest=j;
            }
            //swap smallest to position i
            if (i!=indSmallest)
                swap(words,i,indSmallest);
        }

        for (int i =0; i<69902;i++)
            System.out.print(words[i] + ", ");
        System.out.print(words[69902]);
        System.out.println();
        long time2 = System.nanoTime();
        double time = (double)(time2-time1)/(1000000000);
        System.out.println("Time taken to execute the program: " + time);
    }

    static void swap(String[] arr, int i, int j)
    {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
