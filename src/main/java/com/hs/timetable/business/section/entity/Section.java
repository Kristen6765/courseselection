package com.hs.timetable.business.section.entity;

/**
 *
 */

import org.springframework.stereotype.Component;

/**
 * sql:
 * DROP TABLE IF EXISTS `section`;
 * CREATE TABLE `section`  (
 *   `CRN` int(11) NOT NULL,
 *   `Section_number` int(5) NULL DEFAULT NULL,
 *   `Course_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 *   `Prof` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 *   `Seats` int(64) NULL DEFAULT NULL,
 *   `Waitinglist` int(64) NULL DEFAULT NULL,
 *   `wl_status` tinyint(1) NULL DEFAULT NULL,
 *   `course_id` int(10) NULL DEFAULT NULL,
 *   PRIMARY KEY (`CRN`) USING BTREE
 * ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
 *
 * SET FOREIGN_KEY_CHECKS = 1;
 */

//@Component
public class Section {
    private int CRN;                //CRN
    private int Section_number;     //section system_id
    private String Course_name;     //课程名称，与课程表冗余
    private String Prof;            //教授名，后期改为多对多
    private int Seats;              //剩余可选人数
    private int Waitinglist;       //排队可选人数
    private boolean wl_status;       //是否可排队，true为是，false为否
    private int course_id;

    private int follow_count;       //关注人数
    private int select_count;       //选课人数

    private String Course_content;  //课程内容

    public String getCourse_content() {
        return Course_content;
    }

    public void setCourse_content(String course_content) {
        Course_content = course_content;
    }

    public int getFollow_count() {
        return follow_count;
    }

    public void setFollow_count(int follow_count) {
        this.follow_count = follow_count;
    }

    public int getSelect_count() {
        return select_count;
    }

    public void setSelect_count(int select_count) {
        this.select_count = select_count;
    }

    public int getCRN() {
        return CRN;
    }

    public void setCRN(int CRN) {
        this.CRN = CRN;
    }

    public int getSection_number() {
        return Section_number;
    }

    public void setSection_number(int section_number) {
        Section_number = section_number;
    }

    public String getCourse_name() {
        return Course_name;
    }

    public void setCourse_name(String course_name) {
        Course_name = course_name;
    }

    public String getProf() {
        return Prof;
    }

    public void setProf(String prof) {
        Prof = prof;
    }

    public int getSeats() {
        return Seats;
    }

    public void setSeats(int seats) {
        Seats = seats;
    }

    public int getWaitinglist() {
        return Waitinglist;
    }

    public void setWaitinglist(int waitinglist) {
        Waitinglist = waitinglist;
    }

    public boolean isWl_status() {
        return wl_status;
    }

    public void setWl_status(boolean wl_status) {
        this.wl_status = wl_status;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
}
