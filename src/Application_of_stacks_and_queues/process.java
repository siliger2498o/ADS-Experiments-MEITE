package Application_of_stacks_and_queues;
/**
 *
 * @author sushma r iliger
 */
   public class process{
        private int processId,arrivalTime,burstTime,completionTime,turnaroundTime,waitingTime;
        public process(int pId,int at,int bt){
             processId=pId;
             arrivalTime=at;
             burstTime=bt;
             completionTime=0;
             turnaroundTime=0;
             waitingTime=0;
        }      
        public int getArrivalTime(){return this.arrivalTime;}
        public int getBurstTime(){return this.burstTime;}
        public int getCompletionTime(){return this.completionTime;}
        public int getTurnaroundTime(){return this.turnaroundTime;}
        public int getWaitingTime(){return this.waitingTime;}
        public int getProcessId(){return processId;}
        public void setCompletionTime(int c){this.completionTime=c;}
        public void setTurnaroundTime(int c){this.turnaroundTime=c;}
        public void setWaitingTime(int c){this.waitingTime=c;}
    }

