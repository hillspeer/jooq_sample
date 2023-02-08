package com.jooq.demo;

class Solution {

    public static void main(String[] args) {
        char[] c = {'L','E','E','T','C','O','D','E'};
        reverseString(c);
        for(int i=0;i<c.length;i++){
            System.out.println(c[i]);
        }
    }

    static void reverseString(char[] s) {

        int left=0; int right=s.length-1;

        while(left<right){
            if(isVowel(s[left]) && isVowel(s[right]))
            {
                char t = s[left];
                s[left] = s[right];
                s[right]=t;


                left++;
                right--;}
            else if(isVowel(s[left]) && !isVowel(s[right])){
                right--;
            }else if(!isVowel(s[left])
                    && isVowel(s[right])){
                left--;
            }
        }
    }
    static boolean isVowel(char c){
        int v = c;
        if(c==97 || c=='O' || c=='I' || c=='A' || c=='U'){
            return true;
        }else{ return false;}
    }
}

