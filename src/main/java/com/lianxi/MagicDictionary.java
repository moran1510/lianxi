package com.lianxi;

class MagicDictionary {
    private String[] word;
    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        this.word=dictionary;
    }

    public boolean search(String searchWord) {
        for (String a: word) {
            int b=0;
            if (searchWord.length()!=a.length()){
                continue;
            }else{
                for (int i = 0;i<a.length();i++){
                    if (a.charAt(i)!=searchWord.charAt(i)){
                        b++;
                    }
                }
            }
            if (b==1){
                return true;
            }

        }
        return false;
    }

    public int oddCells(int m, int n, int[][] indices) {
        int[][] a = new int[m][n];
        for (int i = 0; i < indices.length; i++) {
            for (int j = 0; j < n; j++) {
                a[indices[i][0]][j]++;
            }
            for (int j = 0; j < n; j++) {
                a[j][indices[i][1]]++;
            }
        }
        int b=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j]%2==1){
                    b++;
                }
            }
        }
        return b;
    }
}