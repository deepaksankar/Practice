class Solution {
    public String minRemoveToMakeValid(String s) {
        // char[] sArr = s.toCharArray();
        // char[] result = new char[s.length()];
        // int start = 0, end = s.length()-1;
        // while(start <= end) {
        //     while(sArr[start] != '(' && sArr[end] != ')') {
        //         result[start] = sArr[start];
        //         result[end] = sArr[end];
        //         start++;
        //         end--;
        //     }
        //     if(sArr[start] == '(') {
        //         stack.push()
        //     }
        // }
        // return String(result);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isAlphabetic(ch))
                continue;
            if(ch == '(') {
                stack.push(i);
            } else {
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        Set<Integer> set = new HashSet<>(stack);

        for (int i = 0; i < s.length(); i++) {
            if(!set.contains(i))
                result.append(s.charAt(i));
        }

        return result.toString();

    }
}
