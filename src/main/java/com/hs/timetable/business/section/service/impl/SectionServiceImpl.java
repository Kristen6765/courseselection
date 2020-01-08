package com.hs.timetable.business.section.service.impl;

import com.hs.timetable.business.section.dao.ISectionDao;
import com.hs.timetable.business.section.entity.Section;
import com.hs.timetable.business.section.service.ISectionService;
import com.hs.timetable.business.student.entity.Student;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: courseselection
 * @description: section service impl
 * @author: Savilio
 * @create: 2019-08-21 10:42
 **/

@Service(value = "SectionService")
public class SectionServiceImpl implements ISectionService {

    @Resource
    private ISectionDao sectionDao;



    /**
     * TODO service层获取section列表并排序
     * @param section
     * @return
     */
    @Override
    public String getSectionListOrderbyFollowCount(Section section) {
        List<Section> sectionList = sectionDao.getSectionListOrderbyFollowCount(section);
        String result = JSONArray.fromObject(sectionList).toString();
        return result;
    }

    /**
     * 获取section列表
     * @param section
     * @return
     */
    public String getSectionList(Section section){
        List<Section> sectionList = sectionDao.getSectionList(section);
        String result = JSONArray.fromObject(sectionList).toString();
        return result;
    }

    /**
     * 获取带有课程内容信息的section列表
     * @return
     */
    @Override
    public String getSectionListWithCourseContent() {
        List<Section> sectionList = sectionDao.getSectionListWithCourseContent();
        return JSONArray.fromObject(sectionList).toString();
    }

    /**
     *
     * @return
     */
    @Override
    public String inFollowNotInSelect (){
        List<Section> sectionList = sectionDao.inFollowNotInSelect();
        String result = JSONArray.fromObject(sectionList).toString();
        return result;
    }

    /**
     *
     * @param student
     * @return
     */
    @Override
    public String getCourseInfoUsingStudentId(Student student){
        List<Section> sectionList = sectionDao.getCourseInfoUsingStudentId(student);
        String result = JSONArray.fromObject(sectionList).toString();
        return result;
    }
}
