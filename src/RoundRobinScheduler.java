import java.util.*;

class Process {
    int id, arrivalTime, burstTime, remainingTime, completionTime, waitingTime, turnaroundTime;

    Process(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}

public class RoundRobinScheduler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = scanner.nextInt();

        System.out.print("Enter time quantum: ");
        int quantum = scanner.nextInt();

        List<Process> processes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter arrival time for P" + (i + 1) + ": ");
            int arrival = scanner.nextInt();
            System.out.print("Enter burst time for P" + (i + 1) + ": ");
            int burst = scanner.nextInt();
            processes.add(new Process(i + 1, arrival, burst));
        }

        Queue<Process> queue = new LinkedList<>();
        int currentTime = 0, completed = 0;
        List<String> gantt = new ArrayList<>();

        while (completed < n) {
            for (Process p : processes) {
                if (p.arrivalTime <= currentTime && p.remainingTime > 0 && !queue.contains(p)) {
                    queue.add(p);
                }
            }

            if (queue.isEmpty()) {
                currentTime++;
                continue;
            }

            Process current = queue.poll();
            gantt.add("P" + current.id);

            int execTime = Math.min(current.remainingTime, quantum);
            currentTime += execTime;
            current.remainingTime -= execTime;

            for (Process p : processes) {
                if (p.arrivalTime <= currentTime && p.remainingTime > 0 && !queue.contains(p) && p != current) {
                    queue.add(p);
                }
            }

            if (current.remainingTime > 0) {
                queue.add(current);
            } else {
                current.completionTime = currentTime;
                current.turnaroundTime = current.completionTime - current.arrivalTime;
                current.waitingTime = current.turnaroundTime - current.burstTime;
                completed++;
            }
        }

        double totalTAT = 0, totalWT = 0;
        System.out.println("\nProcess\tArrival\tBurst\tCompletion\tTAT\tWT");
        for (Process p : processes) {
            totalTAT += p.turnaroundTime;
            totalWT += p.waitingTime;
            System.out.printf("P%d\t\t%d\t\t%d\t\t%d\t\t%d\t%d\n",
                    p.id, p.arrivalTime, p.burstTime, p.completionTime, p.turnaroundTime, p.waitingTime);
        }

        System.out.println("\nGantt Chart: " + String.join(" | ", gantt));
        System.out.printf("Average Turnaround Time: %.2f\n", totalTAT / n);
        System.out.printf("Average Waiting Time: %.2f\n", totalWT / n);
    }
}