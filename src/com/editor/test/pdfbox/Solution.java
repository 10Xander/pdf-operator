package com.editor.test.pdfbox;

public class Solution {

	public static void main(String[] args) {
		String[] words = {"aba","bcb","ece","aa","e"};
		int[][] queries = {{0,2},{1,4},{1,1}};
		vowelStrings(words,queries);
//		System.out.println(123);
	}
	
    public static int[] vowelStrings(String[] words, int[][] queries) {
    	int wordsLength =  words.length;
    	int[] wordstrans =  new int[words.length+1];
    	for(int i=0;i<wordsLength;i++) {
    		String iStr = words[i];
    		char ifirst = iStr.charAt(0);
    		char ilast = iStr.charAt(iStr.length()-1);
    		if (isVoweCahr(ifirst) && isVoweCahr(ilast)) {
    			wordstrans[i+1]= wordstrans[i]+1;
    		}else {
    			wordstrans[i+1]= wordstrans[i];
			}
    	}
        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int start = queries[i][0], end = queries[i][1];
            ans[i] = wordstrans[end + 1] - wordstrans[start];
        }
        return ans;
    }
    
    public static boolean isVoweCahr(char c) {
    	return c=='a' || c=='e' ||c=='i' || c=='o' ||c=='u';
	}
	
}
