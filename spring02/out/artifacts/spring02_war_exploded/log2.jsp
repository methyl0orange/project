<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="jquery-3.0.0.js"></script>
    <script>
        function myAjax() {
            $.ajax({
                type:"post",
                url:"myjson",
                dataType:"json",
                success:function (data) {
                    console.log(data);

                }
            })

        }
    </script>
</head>
<body>

-------${name}-----
<p>
    <a onclick="myAjax()">${name}</a>
</p>
      <form action="upload" enctype="multipart/form-data" method="post">
          <input type="file" name="myfile">
          <input type="submit" value="上传">


      </form>
</body>
</html>
