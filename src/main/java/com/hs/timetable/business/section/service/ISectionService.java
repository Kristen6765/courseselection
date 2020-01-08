package com.hs.timetable.business.section.service;

import com.hs.timetable.business.section.entity.Section;
import com.hs.timetable.business.student.entity.Student;

public interface ISectionService {

    String getSectionListOrderbyFollowCount(Section section);

    String getSectionList(Section section);

    String getSectionListWithCourseContent();

    String inFollowNotInSelect ();

    String getCourseInfoUsingStudentId(Student student);

}
