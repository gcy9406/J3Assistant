package cn.mycats.j3assistant;

/**
 * Created by Xavier on 2017/11/5.
 */

public class PetResult {

    /**
     * time : 11-05 09:11
     * reporter : 912567760
     * diff : {"hour":3,"minutes":4}
     * status :  进CD 00:04
     * min_cd : 3.0
     * max_cd : 7.0
     * confirmed : true
     * pet : 绿龟
     * name : 清茗经
     */

    private String time;
    private long reporter;
    private DiffBean diff;
    private String status;
    private String min_cd;
    private String max_cd;
    private boolean confirmed;
    private String pet;
    private String name;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getReporter() {
        return reporter;
    }

    public void setReporter(long reporter) {
        this.reporter = reporter;
    }

    public DiffBean getDiff() {
        return diff;
    }

    public void setDiff(DiffBean diff) {
        this.diff = diff;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMin_cd() {
        return min_cd;
    }

    public void setMin_cd(String min_cd) {
        this.min_cd = min_cd;
    }

    public String getMax_cd() {
        return max_cd;
    }

    public void setMax_cd(String max_cd) {
        this.max_cd = max_cd;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class DiffBean {
        /**
         * hour : 3
         * minutes : 4
         */

        private int hour;
        private int minutes;

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }

        @Override
        public String toString() {
            return "DiffBean{" +
                    "hour=" + hour +
                    ", minutes=" + minutes +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PetResult{" +
                "time='" + time + '\'' +
                ", reporter=" + reporter +
                ", diff=" + diff +
                ", status='" + status + '\'' +
                ", min_cd='" + min_cd + '\'' +
                ", max_cd='" + max_cd + '\'' +
                ", confirmed=" + confirmed +
                ", pet='" + pet + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
