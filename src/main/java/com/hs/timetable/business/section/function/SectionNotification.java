package com.hs.timetable.business.section.function;

/**
 * @program: courseselection
 * @description: notice student
 * @author: Savilio
 * @create: 2019-08-22 15:23
 **/

public class SectionNotification {

    //TODO 出现seats空余时，通知关注但未选课的学生
    public void noticeSeats(){
        System.out.println("seats");
    }

    //TODO 存在且出现waittingList空余时，通知关注但未选课的学生
    public void noticeWaittingList(){
        System.out.println("waittingList");
    }
}
