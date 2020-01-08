package com.hs.timetable.business.section.dao;

import com.hs.timetable.business.section.entity.Section;
import com.hs.timetable.business.student.entity.Student;

import java.util.List;

/**
 *
 */
public interface ISectionDao {

    List<Section> getSectionListOrderbyFollowCount(Section section);
    List<Section> getSectionList(Section section);
    List<Section> getSectionListWithCourseContent();

    List<Section> inFollowNotInSelect();

    List<Section> getCourseInfoUsingStudentId(Student student);
}
