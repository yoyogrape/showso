package com.changgou.canal.listener;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xpand.starter.canal.annotation.CanalEventListener;
import com.xpand.starter.canal.annotation.ListenPoint;
import org.springframework.beans.factory.annotation.Autowired;

@CanalEventListener
public class BusinessListener {
    @ListenPoint(schema = "changgou_business", table = {"tb_ad"})
    public void adUpdate(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        System.err.println("广告数据发生变化");

        //修改前数据
        for (CanalEntry.Column column : rowData.getBeforeColumnsList()) {
            if (column.getName().equals("position")) {
                //column.getValue() = web_index_lb
                System.out.println("发送消息到mq  ad_update_queue:" + column.getValue());
            }
        }
    }
}
