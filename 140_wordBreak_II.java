public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> res = new ArrayList<String>();
        if (s==null || s.length()==0) {
            return res;
        }
        helper(s, dict, 0, "", res);
        return res;
    }
    private void helper(String s, Set<String> dict, int start, String item, List<String> res) {
        if (start>=s.length()) {
            res.add(item);
            return;
        }
        StringBuilder str = new StringBuilder();
        for (int i=start; i<s.length(); i++) {
            str.append(s.charAt(i));
            if (dict.contains(str.toString())) {
                String newItem = item.length()>0? (item+" "+str.toString()):str.toString();
                helper(s, dict, i+1, newItem, res);
            }
        }
    }
}

public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        if (s==null || s.length()==0) {
            return new ArrayList<String>();
        }
        int n = s.length();
        boolean[] wb = new boolean[n+1];
        wb[0] = true;
        List<List<String>> words = new ArrayList<List<String>>();
        for (int i=0; i<=n; i++) {
            words.add(new ArrayList<String>());
        }
        words.get(0).add("");
        for (int i=1; i<=n; i++) {
            for (int j=0; j<i; j++) {
                String temp = s.substring(j, i);
                if (wb[j] && dict.contains(temp)) {
                    wb[i] = true;
                    for (String str : words.get(j)) {
                        if (str.equals("")) {
                            words.get(i).add(String.format("%s", temp));
                        } else {
                            words.get(i).add(String.format("%s, %s", str, temp));
                        }
                    }
                }
            }
        }
        return words.get(n);
    }
}