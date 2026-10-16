class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n == 0){
            return new int[0][2];
        }
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        int[][] result = new int[n][2];
        int count = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < n; i++){
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];
            if(nextStart <= end){
            end = Math.max(end,nextEnd);
            }
            else {
                result[count][0] = start;
                result[count][1] = end;
                count++;
                start = nextStart;
                end = nextEnd;
            }
        }
        result[count][0] = start;
        result[count][1] = end;
        count++;
        return Arrays.copyOf(result,count);
    }
}