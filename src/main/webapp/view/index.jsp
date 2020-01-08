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
</head>
<body>
    <input type="text" name="id">
    HelloWorld1111!


    <script src="../js/jquery-2.1.0.js"></script>
    <script>
        $('input').val('')
        $('p').html('')
        $.ajax({
            type:'post',
            url:'../section/getCourseInfoUsingStudentId.do',
            data:{},
            success:function(data){
                console.log(data);
                // {name:'mike'}
                //var name= data.name;
            },
            error:function(err){

            }
        })
    </script>
</body>
</html>
