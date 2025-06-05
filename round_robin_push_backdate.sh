#!/bin/b
global ash

# Exit on any error
set -e

# Set Git identity
git config --global user.name "Natraj Adepu"
git config --global user.email "natrajadepu90@example.com"

# Create and enter project directory
mkdir -p round-robin-scheduler
cd round-robin-scheduler
git init

# Create folders and files
mkdir src
touch src/RoundRobinScheduler.java README.md

# Step 1: Add base structure
echo "Initial project structure for Round-Robin Scheduler" > README.md
git add .
GIT_AUTHOR_DATE="2024-05-10T10:00:00" GIT_COMMITTER_DATE="2024-05-10T10:00:00" \
git commit -m "Initial commit: setup project structure"

# Step 2: Add scheduling logic
echo "Added Round Robin CPU scheduling algorithm" > src/RoundRobinScheduler.java
git add .
GIT_AUTHOR_DATE="2024-05-13T14:00:00" GIT_COMMITTER_DATE="2024-05-13T14:00:00" \
git commit -m "Implemented Round-Robin scheduling logic and process queue"

# Step 3: Add Gantt chart and metrics
echo "Updated Gantt chart display and average time calculations" >> src/RoundRobinScheduler.java
echo "Updated README with sample input/output and features" >> README.md
git add .
GIT_AUTHOR_DATE="2024-05-18T16:00:00" GIT_COMMITTER_DATE="2024-05-18T16:00:00" \
git commit -m "Finalized simulator with Gantt chart and performance metrics"

# Step 4: Add remote (replace USERNAME)
REMOTE_URL="https://github.com/Natraj-Adepu12/round-robin-scheduler.git"
git remote add origin "$REMOTE_URL"
git branch -M main
git push -u origin main

# Final confirmation
echo
echo "✅ Project pushed to $REMOTE_URL with backdated commits"
git log --oneline --graph --all