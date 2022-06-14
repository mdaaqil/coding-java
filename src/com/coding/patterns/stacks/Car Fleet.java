class Solution {
    public int carFleet(int target, int[] positions, int[] speeds) {
      
        int position = 0, speed = 1;
        int len = positions.length;
        int cars[][] = new int[len][2];
        
        for(int i = 0; i < len; i++)
        {
            cars[i][position] = positions[i];
            cars[i][speed] = speeds[i];
        }
        Arrays.sort(cars, (a,b) -> Integer.compare(b[position], a[position]));
        
        Stack<Double> stack = new Stack<>();
        
        for(int car[] : cars)
        {
            stack.push((double)(target - car[position]) / car[speed]);
            if(stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2))
                stack.pop();
        }
        return stack.size();
    }
}
