<%--
  Created by IntelliJ IDEA.
  User: savilio
  Date: 2019/8/19
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CourseSlection</title>
    <style>

    </style>
    <script src="../js/jquery-2.1.0.js"></script>
    <%--<script src="hplus/js/jquery.form.js"></script>
    <script src="hplus/js/bootstrap.min.js?v=3.3.5"></script>
    <!--     <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script> -->
    <script src="hplus/js/plugins/layer/layer.min.js"></script>
    <script src="js/ajax.js"></script>--%>
</head>
<body>

    <form action="http://localhost:8080/courseselection/section/getCourseInfoUsingStudentId.do" method="post">
        <!-- id唯一，用#引用；class可重复，用下述.应用 -->
        <input type="text" name="student_id" class="student_id"/>
        <input type="submit" value="提交">
        <%--<a href="javascript:void(0);" onclick="submit_studentid" target="_blank">获取选课列表</a><br/>--%>
        <button type="button" onclick="submit_studentid()">submit</button>
    </form>


    <script>
        function submit_studentid(){
            var student_id = $(".student_id").val();
            console.log(student_id);
            localStorage.setItem("student_id",student_id);
            window.open('http://localhost:8080/courseselection/view/sectionListInfo.html');
            // window.open('http://localhost:8080/courseselection/view/sectionListInfo.jsp');

        }
    </script>

</body>
</html>
