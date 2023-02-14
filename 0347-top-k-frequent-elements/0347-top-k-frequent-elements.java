class Solution {
    
     class pair{
        
        int key ; 
        int value ; 
        
        public pair(int key, int value) {
            this.key = key ; 
            this.value = value ; 
        }
    }
    
     class valueComparator implements Comparator<pair> {
        
        public int compare(pair pair1, pair pair2) {
            
            if(pair1.value > pair2.value) {
                return -1 ; 
            }
            else {
                return 1 ; 
            }
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>() ; 
        valueComparator c = new valueComparator() ;
        PriorityQueue<pair> pq = new PriorityQueue<>(c) ; 
        
        //frequency hashmap
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1) ; 
        }
        
      // System.out.println(map) ; 
        
        for(int key : map.keySet()) {
            pq.add( new pair(key, map.get(key))) ; 
             
        }
        
        ArrayList<Integer> ansList = new ArrayList<>() ; 
        
        while(k > 0) {
            ansList.add(pq.poll().key) ;
            k-- ;
        }
        
        int []ans = new int[ansList.size()];
        for(int i=0; i<ansList.size(); i++) {
            ans[i] = ansList.get(i) ; 
        }
        
        return ans;
    }
}