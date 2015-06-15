package me.chenfuduo.moonnewsclient.domain;

import java.util.List;

/**
 * Created by Administrator on 2015/6/15.
 * 封装的时候，需要一层一层的去封装
 */
public class CategoryInfo {

    public List<DataInfo> data;
    public List<String> extend;
    public int retcode;

    public class DataInfo {
        public List<ChildrenInfo> children;
        public String id;
        public String title;
        public String type;
        public String url;
        public String url1;

        @Override
        public String toString() {
            return "DataInfo{" +
                    "children=" + children +
                    ", id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", url1='" + url1 + '\'' +
                    '}';
        }
    }


    public class ChildrenInfo {
        public String id;
        public String title;
        public String type;
        public String url;

        @Override
        public String toString() {
            return "ChildrenInfo{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CategoryInfo{" +
                "data=" + data +
                ", extend=" + extend +
                ", retcode=" + retcode +
                '}';
    }
}
