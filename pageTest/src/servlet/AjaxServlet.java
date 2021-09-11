package servlet;


import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AjaxServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*//接受数据
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        BufferedReader br=req.getReader();
        String str=br.readLine();
        str="******"+str+"****";
        //写数据
        PrintWriter pw=resp.getWriter();
        pw.write(str);
        pw.flush();
        pw.close();*/


        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        BufferedReader br=req.getReader();
        String str=br.readLine();
        System.out.println(str);
        List<String> slist=new ArrayList<>();
        if(str.equals("黑龙江")){
            slist.add("jjjj");
            slist.add("dfghj");
            slist.add("rtyui");
        }
        else if(str.equals("吉林")){
            slist.add("吉林");
            slist.add("长春");
            slist.add("延边");
        }
        else if(str.equals("辽宁")){
            slist.add("沈阳");
            slist.add("大连");
            slist.add("盘锦");
        }
        Gson gson=new Gson();
        String s=gson.toJson(slist);
        PrintWriter pw=resp.getWriter();
        pw.write(s);
        pw.flush();
        pw.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
