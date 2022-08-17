import java.util.List;
import java.util.Stack;

public class Leet0636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        //["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]

        Stack<Integer> idStack = new Stack<>();
        int[] result = new int[n];
        int lastTime = 0;

        for (String s: logs){
            Message m = new Message(s);

            if(m.isStart()){
                if(!idStack.isEmpty()){
                    result[idStack.peek()] += m.time - lastTime;
                }

                idStack.push(m.index);
                lastTime = m.time;
            }else {
                result[idStack.peek()] += m.time - lastTime + 1;
                idStack.pop();
                lastTime = m.time + 1;
            }
        }

        return result;
    }
    private static class Message{
        int index;
        boolean isStart;
        int time;

        public Message(String info){
            String[] split = info.split(":");
            index = Integer.parseInt(split[0]);
            isStart = split[1].equals("start");
            time = Integer.parseInt(split[2]);
        }

        public boolean isStart() {
            return isStart;
        }
    }

}
