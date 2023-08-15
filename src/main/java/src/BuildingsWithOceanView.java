class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int last = Integer.MIN_VALUE;
        for(int i = heights.length-1; i >= 0; i--) {
            if (heights[i] > last) {
                list.add(i);
                last = heights[i];
            }
        }
        int ind = 0;
        int[] result = new int[list.size()];
        for(int i = list.size()-1; i>= 0; i--) {
            result[ind++] = list.get(i);
        }

        return result;
    }
}
