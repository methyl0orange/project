<%--
  Created by IntelliJ IDEA.
  User: 吴新成
  Date: 2021/6/2
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="jquery-1.11.3.js"></script>
    <script type="text/javascript">
        function change() {
            $.ajax({
                type:"post",
                url:"ajax",
                data:$('#sell').val(),
                dataType:"json",
                success:function (data) {
                    //console.log(data);
                    //$('p').html(data);
                    for(var i in data){
                        $('#sell2').append("<option>"+data[i]+"</option>");
                    }

                }

            });
            //$.get("ajax?kw=qwertyu");

        }
    </script>
</head>
<body>
  <!--<form action="ajax" id="jvFrom">

      <input type="text" id="keyword" onchange="change()">
      <input type="submit" value="百度一下">

  </form>
  <p></p>-->
  <select id="sell" onchange="change()">
      <option>请选择省份</option>
      <option>黑龙江</option>
      <option>吉林</option>
      <option>辽宁</option>
  </select>
  <select id="sell2">
      <option>请选择市</option>
  </select>
</body>
</html>
