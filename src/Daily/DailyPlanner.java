package Daily;

import Setting.Periodicity;
import Setting.ValidateSetting;

import java.time.LocalDateTime;
import java.util.Objects;

public class DailyPlanner implements Comparable<DailyPlanner> {
        private final int iD;
        private boolean isWorkTask;
        private String title;
        private String description;
        private LocalDateTime createdTime;
        private LocalDateTime nextDateTask;
        static int counter;
        private Periodicity periodicity;
        private boolean deleted;

    public DailyPlanner(String title, String description, Periodicity periodicity, boolean isWorkTask) {
            setTitle(title);
            setDescription(description);
            this.createdTime = LocalDateTime.now();
            this.isWorkTask = isWorkTask;
            DailyPlanner.counter++;
            this.iD = counter;
            this.periodicity = periodicity;
        }

        public void setTitle(String title) {
            this.title = ValidateSetting.validateString(title);
        }


        public void setDescription(String description) {
            this.description = ValidateSetting.validateString(description);
        }

        public LocalDateTime getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(LocalDateTime createdTime) {
            this.createdTime = createdTime;
        }

        public int getiD() {
            return iD;
        }

        public Periodicity getPeriodicity() {
            return periodicity;
        }

        public void setPeriodicity(Periodicity periodicity) {
            this.periodicity = periodicity;
        }

        public void setDeleted(boolean deleted) {
            this.deleted = deleted;
        }

        public LocalDateTime getNextDateTask() {
            return nextDateTask;
        }

        public void setNextDateTask(LocalDateTime nextDateTask) {
            this.nextDateTask = nextDateTask;
        }

        public void setWorkTask(boolean workTask) {
            this.isWorkTask = workTask;
        }

        @Override
        public String toString() {
            String isWork = isWorkTask ? "Рабочая задача" : "Личная задача";
            return "Task.Task{" +
                    "name='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", Type=" + isWork + '\'' +
                    ", Created Date=" + createdTime.format(DailyTack.FORMAT_DATE) +
                    ", id=" + iD +
                    '}' + "\n";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DailyPlanner task = (DailyPlanner) o;
            return iD == task.iD && isWorkTask == task.isWorkTask && deleted == task.deleted && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(createdTime, task.createdTime) && Objects.equals(nextDateTask, task.nextDateTask) && periodicity == task.periodicity;
        }

        @Override
        public int hashCode() {
            return Objects.hash(iD, isWorkTask, title, description, createdTime, nextDateTask, periodicity, deleted);
        }

        @Override
        public int compareTo(DailyPlanner o) {
            if (this.getCreatedTime().isAfter(o.getCreatedTime())) {
                return 1;
            } else if (this.getCreatedTime().isBefore(o.getCreatedTime())) {
                return -1;
            } else {
                return 0;
            }
        }
    }

