package cn.mycats.j3assistant;

import java.util.List;

/**
 * Created by Xavier on 2017/11/10.
 */

public class ServersBeans {


    /**
     * region : 双线一区
     * servers : [{"name":"雪絮金屏双线","id":1,"open":true,"openTime":"11-01 10:25","allowReport":true},{"name":"飞鸢泛月","id":219,"open":true,"openTime":"11-01 10:25","allowReport":true},{"name":"破阵子","id":221,"open":true,"openTime":"11-01 10:25","allowReport":true},{"name":"天鹅坪","id":222,"open":true,"openTime":"11-01 10:25","allowReport":true},{"name":"双剑合璧","id":236,"open":true,"openTime":"11-01 10:25","allowReport":true},{"name":"天下归一","id":237,"open":true,"openTime":"11-01 10:25","allowReport":false},{"name":"鹏程万里","id":245,"open":true,"openTime":"11-01 10:25","allowReport":true}]
     */

    private String region;
    private List<ServersBean> servers;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<ServersBean> getServers() {
        return servers;
    }

    public void setServers(List<ServersBean> servers) {
        this.servers = servers;
    }

    public static class ServersBean {
        /**
         * name : 雪絮金屏双线
         * id : 1
         * open : true
         * openTime : 11-01 10:25
         * allowReport : true
         */

        private String name;
        private int id;
        private boolean open;
        private String openTime;
        private boolean allowReport;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isOpen() {
            return open;
        }

        public void setOpen(boolean open) {
            this.open = open;
        }

        public String getOpenTime() {
            return openTime;
        }

        public void setOpenTime(String openTime) {
            this.openTime = openTime;
        }

        public boolean isAllowReport() {
            return allowReport;
        }

        public void setAllowReport(boolean allowReport) {
            this.allowReport = allowReport;
        }
    }
}
