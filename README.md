# 🧠 Round-Robin CPU Scheduler Simulator

A simple console-based simulator to model a Round-Robin CPU scheduler. Built in Java to mimic operating system-level process scheduling logic.

## 💡 Features

- Accepts user input: process ID, arrival time, burst time
- Applies Round-Robin scheduling with configurable time quantum
- Outputs:
  - Gantt Chart simulation
  - Average waiting time
  - Average turnaround time
- Handles edge cases like:
  - Idle CPU time
  - Simultaneous arrivals

## 🛠️ Technologies Used

- Java 21
- Object-Oriented Design
- Console-based interaction

## 📦 How to Run

1. Clone the repository:
```bash
git clone https://github.com/yourusername/round-robin-scheduler.git
cd round-robin-scheduler
```

2. Compile the program:
```bash
javac src/RoundRobinScheduler.java
```

3. Run the program:
```bash
java src.RoundRobinScheduler
```

4. Example input:
```
Enter number of processes: 3
Enter time quantum: 2
Enter arrival time for P1: 0
Enter burst time for P1: 5
Enter arrival time for P2: 1
Enter burst time for P2: 3
Enter arrival time for P3: 2
Enter burst time for P3: 4
```

5. Output:
```
Gantt Chart: P1 | P2 | P3 | ...
Average Turnaround Time: XX
Average Waiting Time: YY
```

## 📄 License

This project is licensed under the MIT License.Numbers: [6, 9, 4]
Max: 9
Min: 4
Sum: 19
Average: 6.333333333333333
Ascending: [4, 6, 9]
Descending: [9, 6, 4]
Even numbers count: 2
Odd numbers count: 1
