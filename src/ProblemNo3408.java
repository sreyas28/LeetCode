import java.util.*;

public class ProblemNo3408 {
    public static void main(String[] args) {

    }

    class TaskManager {
        static class USER{
            int userID;
            int taskID;
            int priority;

            USER(int userID, int taskID, int priority){
                this.userID = userID;
                this.taskID = taskID;
                this.priority = priority;
            }

        }

        private Map<Integer, USER> userMap;
        private PriorityQueue<USER> priorityQueue;

        public TaskManager(List<List<Integer>> tasks) {
            userMap = new HashMap<>();
            priorityQueue = new PriorityQueue<>((a,b) -> {
                if(a.priority != b.priority) return b.priority - a.priority;
                return b.taskID - a.taskID;
            });

            for(List<Integer> task: tasks){
                USER user = new USER(task.get(0), task.get(1), task.get(2));

                userMap.put(task.get(1), user);
                priorityQueue.add(user);
            }
        }

        public void add(int userId, int taskId, int priority) {
            USER user = new USER(userId, taskId, priority);

            userMap.put(taskId, user);
            priorityQueue.add(user);
        }

        public void edit(int taskId, int newPriority) {
            USER oldUser = userMap.get(taskId);
            USER newUser = new USER(oldUser.userID, taskId, newPriority);
            userMap.put(taskId, newUser);

            priorityQueue.add(newUser);
        }

        public void rmv(int taskId) {
            userMap.remove(taskId);
        }

        public int execTop() {
            while (!priorityQueue.isEmpty()) {
                USER top = priorityQueue.poll();
                USER latest = userMap.get(top.taskID);
                if (latest != null && latest.priority == top.priority && latest.userID == top.userID) {
                    userMap.remove(top.taskID);
                    return top.userID;
                }
                // stale entry: continue loop
            }
            return -1;

        }
    }

    class TaskManager_ {
        static class USER{
            int userID;
            int taskID;
            int priority;

            USER(int userID, int taskID, int priority){
                this.userID = userID;
                this.taskID = taskID;
                this.priority = priority;
            }

        }

        private Map<Integer, USER> userMap;
        private PriorityQueue<USER> priorityQueue;

        public TaskManager_(List<List<Integer>> tasks) {
            userMap = new HashMap<>();
            priorityQueue = new PriorityQueue<>((a,b) -> {
                if(a.priority != b.priority) return b.priority - a.priority;
                return b.taskID - a.taskID;
            });

            for(List<Integer> task: tasks){
                USER user = new USER(task.get(0), task.get(1), task.get(2));

                userMap.put(task.get(1), user);
                priorityQueue.add(user);
            }
        }

        public void add(int userId, int taskId, int priority) {
            USER user = new USER(userId, taskId, priority);

            userMap.put(taskId, user);
            priorityQueue.add(user);
        }

        public void edit(int taskId, int newPriority) {
            USER user = userMap.get(taskId);
            priorityQueue.remove(user); // Remove old entry
            user.priority = newPriority;
            priorityQueue.add(user);    // Re-add updated entry

        }

        public void rmv(int taskId) {
            priorityQueue.remove(userMap.get(taskId));
            userMap.remove(taskId);
        }

        public int execTop() {
            if(priorityQueue.isEmpty()) return -1;

            USER top = priorityQueue.poll();
            userMap.remove(top.taskID);

            return top.userID;
        }
    }

}
