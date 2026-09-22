package com.itheima.dayStatic1.leetcode100;

import java.util.*;

//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表
//--------------------------------------------------------------------------------------------
public class Solution2 {
//    public List<List<String>> groupAnagrams(String[] strs){
//        Map<String, List<String>> map =new HashMap<>();
//        for(String str:strs){
//           int [] counts = new int[26];
//           int length = str.length();
//           for(char c:str.toCharArray()){
//               counts[c-'a']++;
//           }
//           StringBuffer sb = new StringBuffer();
//           for(int i=0; i<26; i++){
//               if(counts[i]!=0){
//                   sb.append((char)i+'a');
//                   sb.append(counts[i]);
//               }
//           }
//           String key = sb.toString();
//          List<String> list = map.getOrDefault(key,new ArrayList<String>());
//          list.add(str);
//          map.put(key,list);
//
//        }
//    return new ArrayList<List<String>>(map.values());
//    }
//------------------------------------------------------------------------------------
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap =  new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String str_s = String.valueOf(chars);
            if (hashMap.containsKey(str_s)){
                hashMap.get(str_s).add(str);
            } else {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(str);
                hashMap.put(str_s, strings);
            }
        }
        List<List<String>> resultList = new ArrayList<>(hashMap.values());
        return resultList;
    }
}









}
