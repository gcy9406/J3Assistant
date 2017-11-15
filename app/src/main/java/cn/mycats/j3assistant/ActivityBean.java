package cn.mycats.j3assistant;

import java.util.List;

/**
 * Created by Xavier on 2017/11/10.
 */

public class ActivityBean {

    /**
     * daily_info : {"daily_update_time":"2017-11-10  五","daily_list":[{"id":"6","title":"美人图画画"},{"id":"15","title":"大战·英雄引仙水榭"},{"id":"60","title":"五毒·血蚊幼虫"},{"id":"36","title":"五台山·无遮大会"},{"id":"42","title":"世界首领（周五）"},{"id":"25","title":"战场-神农洇"}]}
     * info_content_list : [{"id":"2570","title":"双十一新实物周边上架 限量抢购不可错过","intro":"","icon_url":"http://jx3.xoyo.com/uploadfile/2017/1110/20171110111149790.jpg","browser":"833","comment_num":"5","type":"normal","display_style":"normal","url":"http://www.jx3tong.com/?m=page&c=info&a=detail&id=2570","is_video":0},{"id":"2569","title":"一波正太散件安利","intro":"","icon_url":"https://wx4.sinaimg.cn/mw690/006rR6fagy1flcsuz0v5lj30dr0apdmc.jpg","browser":"3701","comment_num":"17","type":"normal","display_style":"normal","url":"http://www.jx3tong.com/?m=page&c=info&a=detail&id=2569","is_video":0},{"id":"2568","title":"\u201c双11\u201d大惠战","intro":"太多了....看图吧！","icon_url":"https://wx3.sinaimg.cn/mw690/68ffaf79gy1flc6fah00ej20m80m87wh.jpg","browser":"6545","comment_num":"17","type":"normal","display_style":"normal","url":"http://www.jx3tong.com/?m=page&c=info&a=detail&id=2568","is_video":0},{"id":"2567","title":"【重制版】测试服积分获得新方法","intro":"试穿成衣就可以了。。现在还没有。。。","icon_url":"https://wx4.sinaimg.cn/mw690/68ffaf79gy1flbudc61gmj20j60j6n50.jpg","browser":"8151","comment_num":"26","type":"normal","display_style":"normal","url":"http://www.jx3tong.com/?m=page&c=info&a=detail&id=2567","is_video":0},{"id":"2566","title":"【COS】歪，你的海景房到了，请查收！","intro":"粉白菜！！！！","icon_url":"https://wx2.sinaimg.cn/mw690/006oifpBly1flbu5or3ukj30v90kt7aa.jpg","browser":"6690","comment_num":"27","type":"normal","display_style":"normal","url":"http://www.jx3tong.com/?m=page&c=info&a=detail&id=2566","is_video":0},{"id":"2565","title":"建模表演高还原 双十一新披风外观视频首曝","intro":"","icon_url":"http://jx3.xoyo.com/uploadfile/2017/1109/20171109103458686.jpg","browser":"14628","comment_num":"51","type":"normal","display_style":"normal","url":"http://www.jx3tong.com/?m=page&c=info&a=detail&id=2565","is_video":0},{"id":"2564","title":"双十一成女散件大集合","intro":"","icon_url":"https://tvax2.sinaimg.cn/crop.0.4.1242.1242.180/c508d463ly8fkzj0fbqhwj20yi0yqwh8.jpg","browser":"12780","comment_num":"37","type":"normal","display_style":"normal","url":"http://www.jx3tong.com/?m=page&c=info&a=detail&id=2564","is_video":0},{"id":"2562","title":"【头像】全门派午睡ing","intro":"傻萌傻萌的！！","icon_url":"https://wx2.sinaimg.cn/mw690/005HEdh8gy1flatmd6lmhj30t20qoacg.jpg","browser":"9470","comment_num":"31","type":"normal","display_style":"normal","url":"http://www.jx3tong.com/?m=page&c=info&a=detail&id=2562","is_video":0},{"id":"2561","title":"11月9日例行维护公告","intro":"\u201c双11\u201d大惠战","icon_url":"http://www.jx3tong.com/Public/images/news/wh.png","browser":"19084","comment_num":"36","type":"normal","display_style":"normal","url":"http://www.jx3tong.com/?m=page&c=info&a=detail&id=2561","is_video":0},{"id":"2560","title":"【PVX福音】长安声望日常任务攻略\u2014靖世军·忠/义","intro":"来自小伙伴ID君乾羽的投稿","icon_url":"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2009421448,1237059889&fm=27&gp=0.jpg","browser":"4666","comment_num":"20","type":"normal","display_style":"normal","url":"http://www.jx3tong.com/?m=page&c=info&a=detail&id=2560","is_video":0},{"id":"2559","title":"双11优惠有多少，gww给你算","intro":"优惠券+积分","icon_url":"https://wx2.sinaimg.cn/mw1024/006rR6fagy1flanf0kq8ej304p05i3zi.jpg","browser":"15295","comment_num":"33","type":"normal","display_style":"normal","url":"http://www.jx3tong.com/?m=page&c=info&a=detail&id=2559","is_video":0},{"id":"2558","title":"双十一散件搭配安利","intro":"萝莉同人图哦，敲可爱~","icon_url":"https://wx4.sinaimg.cn/mw690/005YufmRly1fl9rr0x30uj30ql0qd7g0.jpg","browser":"10891","comment_num":"20","type":"normal","display_style":"normal","url":"http://www.jx3tong.com/?m=page&c=info&a=detail&id=2558","is_video":0},{"id":"2557","title":"送给徒弟的萌新手册2.0","intro":"来自小伙伴ID清音羽商的投稿","icon_url":"http://wx4.sinaimg.cn/mw690/abbceb5agy1fh9bzv0c4jj213k0k0gu8.jpg","browser":"14236","comment_num":"68","type":"normal","display_style":"normal","url":"http://www.jx3tong.com/?m=page&c=info&a=detail&id=2557","is_video":0},{"id":"2556","title":"双十一冬季御寒披风来袭","intro":"就知道还有披风","icon_url":"https://wx3.sinaimg.cn/mw690/7a318daagy1fl9uo8zgdrj20rs0rsdlh.jpg","browser":"20198","comment_num":"81","type":"normal","display_style":"normal","url":"http://www.jx3tong.com/?m=page&c=info&a=detail&id=2556","is_video":0},{"id":"2555","title":"【外观安利】临别无需言，山水又相逢","intro":"双十一成男江湖套剁手手册","icon_url":"https://wx2.sinaimg.cn/mw690/73c4d331gy1fl9l77v1aej20tk16wk3a.jpg","browser":"12618","comment_num":"50","type":"normal","display_style":"normal","url":"http://www.jx3tong.com/?m=page&c=info&a=detail&id=2555","is_video":0},{"id":"2554","title":"重制版部分外观预览（11月7号更新）","intro":"正太、成男","icon_url":"http://wx1.sinaimg.cn/mw690/006nDtPEgy1fl9mugsv4ij30dm0eadou.jpg","browser":"12407","comment_num":"42","type":"normal","display_style":"normal","url":"http://www.jx3tong.com/?m=page&c=info&a=detail&id=2554","is_video":0},{"id":"2553","title":"重制版部分外观预览（11月7号更新）","intro":"萝莉、成女","icon_url":"http://wx4.sinaimg.cn/mw690/006nDtPEgy1fl9mmuwu5fj30do0ehk0g.jpg","browser":"12981","comment_num":"19","type":"normal","display_style":"normal","url":"http://www.jx3tong.com/?m=page&c=info&a=detail&id=2553","is_video":0},{"id":"2552","title":"【COS】雀仙！！","intro":"一个清廉雀仙琴爹于乱朝被奸臣所害的故事","icon_url":"https://wx2.sinaimg.cn/mw690/005EqK5Nly1fk0i219bbhj315o0rs4h5.jpg","browser":"4353","comment_num":"22","type":"normal","display_style":"normal","url":"http://www.jx3tong.com/?m=page&c=info&a=detail&id=2552","is_video":0},{"id":"2550","title":"双十一大惠战全面来袭 海量特惠活动即将开启","intro":"拓印5折、三倍积分......美滋滋","icon_url":"http://wx2.sinaimg.cn/mw690/68ffaf79gy1fl9dfhs6jaj20j60j67at.jpg","browser":"13616","comment_num":"28","type":"normal","display_style":"normal","url":"http://www.jx3tong.com/?m=page&c=info&a=detail&id=2550","is_video":0},{"id":"2549","title":"双十一特效外观首曝","intro":"没想到吧~我觉得还有披风哦","icon_url":"https://wx2.sinaimg.cn/mw690/7a318daagy1fl8oesnxvpj20rs0rsk78.jpg","browser":"29533","comment_num":"76","type":"normal","display_style":"normal","url":"http://www.jx3tong.com/?m=page&c=info&a=detail&id=2549","is_video":0}]
     */

    private DailyInfoBean daily_info;
    private List<InfoContentListBean> info_content_list;

    public DailyInfoBean getDaily_info() {
        return daily_info;
    }

    public void setDaily_info(DailyInfoBean daily_info) {
        this.daily_info = daily_info;
    }

    public List<InfoContentListBean> getInfo_content_list() {
        return info_content_list;
    }

    public void setInfo_content_list(List<InfoContentListBean> info_content_list) {
        this.info_content_list = info_content_list;
    }

    public static class DailyInfoBean {
        /**
         * daily_update_time : 2017-11-10  五
         * daily_list : [{"id":"6","title":"美人图画画"},{"id":"15","title":"大战·英雄引仙水榭"},{"id":"60","title":"五毒·血蚊幼虫"},{"id":"36","title":"五台山·无遮大会"},{"id":"42","title":"世界首领（周五）"},{"id":"25","title":"战场-神农洇"}]
         */

        private String daily_update_time;
        private List<DailyListBean> daily_list;

        public String getDaily_update_time() {
            return daily_update_time;
        }

        public void setDaily_update_time(String daily_update_time) {
            this.daily_update_time = daily_update_time;
        }

        public List<DailyListBean> getDaily_list() {
            return daily_list;
        }

        public void setDaily_list(List<DailyListBean> daily_list) {
            this.daily_list = daily_list;
        }

        public static class DailyListBean {
            /**
             * id : 6
             * title : 美人图画画
             */

            private String id;
            private String title;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            @Override
            public String toString() {
                return "DailyListBean{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DailyInfoBean{" +
                    "daily_update_time='" + daily_update_time + '\'' +
                    ", daily_list=" + daily_list +
                    '}';
        }
    }

    public static class InfoContentListBean {
        /**
         * id : 2570
         * title : 双十一新实物周边上架 限量抢购不可错过
         * intro :
         * icon_url : http://jx3.xoyo.com/uploadfile/2017/1110/20171110111149790.jpg
         * browser : 833
         * comment_num : 5
         * type : normal
         * display_style : normal
         * url : http://www.jx3tong.com/?m=page&c=info&a=detail&id=2570
         * is_video : 0
         */

        private String id;
        private String title;
        private String intro;
        private String icon_url;
        private String browser;
        private String comment_num;
        private String type;
        private String display_style;
        private String url;
        private int is_video;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getIcon_url() {
            return icon_url;
        }

        public void setIcon_url(String icon_url) {
            this.icon_url = icon_url;
        }

        public String getBrowser() {
            return browser;
        }

        public void setBrowser(String browser) {
            this.browser = browser;
        }

        public String getComment_num() {
            return comment_num;
        }

        public void setComment_num(String comment_num) {
            this.comment_num = comment_num;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDisplay_style() {
            return display_style;
        }

        public void setDisplay_style(String display_style) {
            this.display_style = display_style;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getIs_video() {
            return is_video;
        }

        public void setIs_video(int is_video) {
            this.is_video = is_video;
        }
    }
}
