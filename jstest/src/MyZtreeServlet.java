import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyZtreeServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //模拟数据
        List<SonNode> sns1=new ArrayList<>();
        sns1.add(new SonNode("a1"));
        sns1.add(new SonNode("a2"));
        sns1.add(new SonNode("a3"));
        ParentNode pn1=new ParentNode("a",true,sns1);
        List<SonNode> sns2=new ArrayList<>();
        sns1.add(new SonNode("b1"));
        sns1.add(new SonNode("b2"));
        sns1.add(new SonNode("b3"));
        ParentNode pn2=new ParentNode("b",true,sns2);
        List<ParentNode> pns=new ArrayList<>();
        pns.add(pn1);
        pns.add(pn2);
        //转json格式
        Gson gson=new Gson();
        String str=gson.toJson(pns);
        //传到前端显示
        //req.setAttribute("str",str);
        HttpSession session=req.getSession();
        session.setAttribute("str",str);
        req.getRequestDispatcher("myztree.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
