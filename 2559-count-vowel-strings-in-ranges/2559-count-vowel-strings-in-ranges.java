class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        
        int[] ans=new int[queries.length];
        int[] str=new int[words.length];
        for(int i=0;i<words.length;i++){
            str[i]=check(words[i]);
        }

        for(int i=0;i < queries.length;i++){
            int sum=0;
            int x= queries[i][0];
            int y=queries[i][1];
            for(int j=x;j<=y;j++){
                sum += str[j];
            }
            ans[i]=sum;
        }
        return ans;
    }
    public int check(String word){
        char f=word.charAt(0);
        char l=word.charAt(word.length()-1);
        if((f == 'a' || f == 'e' || f == 'i' || f == 'o' || f == 'u') && (l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u')){
            return 1;
        }
        return 0;
    }
}