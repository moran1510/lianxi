package com.lianxi;

import java.util.HashMap;

class WordFilter {
    HashMap<String,Integer> map;
    public WordFilter(String[] words) {
        map = new HashMap<>();
        int n=words.length;
        for (int i = 0; i < words.length; i++) {
            int m = words[i].length();
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= m; k++) {
                    map.put(words[i].substring(0,j)+"#"+words[i].substring(m-k),i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return map.getOrDefault(pref+"#"+suff,-1);
    }
}
