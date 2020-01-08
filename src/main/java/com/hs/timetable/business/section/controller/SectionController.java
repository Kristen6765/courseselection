package com.hs.timetable.business.section.controller;

import com.hs.timetable.business.section.entity.Section;
import com.hs.timetable.business.section.service.ISectionService;
import com.hs.timetable.business.student.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: section_system
 * @description: section controller
 * @author: Kristen
 * http://localhost:8080/view/sectionList.jsp
 * 、http://localhost:8080/courseselection/view/sectionList.jsp
 * @create: 2019-08-19 14:45
 **/

@Controller
@RequestMapping("/section")
public class SectionController {

    @Resource(name = "SectionService")
    private ISectionService sectionService;


    /**
     * 获取带有course content的section列表
     * @param request
     * @param section
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/getSectionListWithCourseContent.do", produces = "application/json; charset=utf-8")
    public String getSectionListWithCourseContent(HttpServletRequest request, Section section){
//        String key = request.getParameter("key");       //123
//        String Course_name = section.getCourse_name();        //input
        return sectionService.getSectionListWithCourseContent();
    }

    /**
     * 获取section列表，按照关注人数排序，人数多的排在前面
     * @param request
     * @param section
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/getSectionListOrderbyFollowCount.do", produces = "application/json; charset=utf-8")
    public String getSectionListOrderbyFollowCount(HttpServletRequest request, Section section){
        return sectionService.getSectionListOrderbyFollowCount(section);
    }

    /**
     * 获取section列表
     * @param request
     * @param section
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/getSectionList.do", produces = "application/json; charset=utf-8")
    public String getSectionList(HttpServletRequest request, Section section){
        return sectionService.getSectionList(section);
    }

    /**
     * 获取所有学生关注但为选择的课程信息
     * @param request
     * @param section
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/inFollowNotInSelect.do", produces = "application/json; charset=utf-8")
    public String inFollowNotInSelect(HttpServletRequest request, Section section){
        return sectionService.inFollowNotInSelect();
    }

    /**
     * controller test
     */
    @ResponseBody
    @RequestMapping(value="/test.do", produces = "application/json; charset=utf-8")
    public String controllerTest(Model model){
        System.out.println("================");
        model.addAttribute("result","hahaha 第一个参数");
        return "nice";
    }

    /**
     * 返回指定学生的选课列表
     * controller test
     */
    @ResponseBody
    @RequestMapping(value="/getCourseInfoUsingStudentId.do", produces = "application/json; charset=utf-8")
    public String controllerTest(HttpServletRequest request, Model model, Student student){

        String student_id = request.getParameter("student_id");
        System.out.println("student id :"+student_id);

        student.setId(Integer.valueOf(student_id));
        String result = sectionService.getCourseInfoUsingStudentId(student);

        model.addAttribute("result",result);
        return result;
    }

//    public String controllerTest(HttpServletRequest request, Model model, Student student){
//
//        String student_id = request.getParameter("student_id");
//        System.out.println("student id :"+student_id);
//
//        student.setId(Integer.valueOf(student_id));
//
//
//        return sectionService.getCourseInfoUsingStudentId(student);
//    }

}
