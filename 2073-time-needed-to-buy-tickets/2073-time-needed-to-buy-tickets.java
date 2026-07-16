class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue <Integer> queue =  new LinkedList<>();
        int n = tickets.length;
       
        for(int i = 0;i<n;i++){
            queue.offer(i);
        }
         int count = 0;
            while(!queue.isEmpty()){
                int person = queue.poll();
                tickets[person]--;
                count++;
            if(person == k && tickets[person] == 0){
                return count;
            }
        if(tickets[person] > 0){
            queue.offer(person);
        }
            }
        return count;
    }
}