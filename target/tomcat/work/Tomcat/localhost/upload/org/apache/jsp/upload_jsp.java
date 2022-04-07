/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-04-07 16:02:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class upload_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Ajax异步上传图片</title>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <script src=\"/upload/js/jquery-1.6.2.js\" type=\"application/javascript\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script src=\"/upload/js/jquery.form.js\" type=\"application/javascript\" charset=\"utf-8\"></script>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <!-- Ajax异步上传图片 -->\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        function uploadPic() {\r\n");
      out.write("            var options = {\r\n");
      out.write("                url: \"/upload/upload\",// 规定把请求发送到那个URL，会覆盖form表单中的action\r\n");
      out.write("                type: \"post\", // 请求方式\r\n");
      out.write("                dataType: \"json\",//服务器响应的数据类型\r\n");
      out.write("                // 请求成功时执行的回调函数\r\n");
      out.write("                success: function (data, status, xhr) {\r\n");
      out.write("                    $(\"#allUrl\").attr(\"src\", data.path);// 图片显示地址\r\n");
      out.write("                    $(\"#imgUrl\").empty();//清空内容\r\n");
      out.write("                    $(\"#imgUrl\").append(data.path);\r\n");
      out.write("                },\r\n");
      out.write("                error:function(data){\r\n");
      out.write("                    $(\".showImg\").append(\"<div  style='font-size:x-large;width: 320px;float: left;margin-left: 80px;'><b>很抱歉，图片上传失败了！</b></div >\");\r\n");
      out.write("                    $(\"#allUrl\").attr(\"src\", \"/upload/images/0922ee7977c451b31e85.png\");// 图片显示地址\r\n");
      out.write("                }\r\n");
      out.write("            };\r\n");
      out.write("\r\n");
      out.write("            var flag = check();\r\n");
      out.write("            if (flag) {\r\n");
      out.write("                $(\"#imgForm\").ajaxSubmit(options);\r\n");
      out.write("                // $('#imgForm').submit(function() { // 提交表单的id\r\n");
      out.write("                //     $(this).ajaxSubmit(options);\r\n");
      out.write("                //     return false; //防止表单自动提交\r\n");
      out.write("                // });\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function check() {\r\n");
      out.write("            var str = $(\"#imgForm\").get(0)[0].value;\r\n");
      out.write("            // console.log(str);\r\n");
      out.write("            if (str.length == \"\") {\r\n");
      out.write("                alert(\"你不选图片上传个鸡儿？？？\");\r\n");
      out.write("                return false;\r\n");
      out.write("            }\r\n");
      out.write("            return true;\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        .showImg {\r\n");
      out.write("            border: 1px solid #DDDDDD;\r\n");
      out.write("            width: 1110px;\r\n");
      out.write("            height: 339px;\r\n");
      out.write("            line-height: 339px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .showImg img {\r\n");
      out.write("            height: 339px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .upload{\r\n");
      out.write("            border: 1px solid #DDDDDD;\r\n");
      out.write("            height: 50px;\r\n");
      out.write("            line-height: 50px;\r\n");
      out.write("            padding-left: 10px;\r\n");
      out.write("            margin: 20px 0px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .urltext{\r\n");
      out.write("            border: 1px solid #DDDDDD;\r\n");
      out.write("            height: 50px;\r\n");
      out.write("            line-height: 50px;\r\n");
      out.write("            padding-left: 10px;\r\n");
      out.write("            background-color: #F5F5F5;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"title\">\r\n");
      out.write("    <h2>Image Upload</h2>\r\n");
      out.write("    <h4>5 MB max per file. 10 files max per request. </h4>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"content\">\r\n");
      out.write("    <div class=\"showImg\">\r\n");
      out.write("        <img src=\"/upload/images/6f406d4d_E792236_490b3400.jpg\" id=\"allUrl\"/>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"upload\">\r\n");
      out.write("        <form id=\"imgForm\" action=\"/upload/upload\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("            <input type=\"file\" name=\"file\">\r\n");
      out.write("            <input type=\"button\" value=\"提交\" onclick=\"uploadPic()\">\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"urltext\">\r\n");
      out.write("        <span>Image URL：</span>\r\n");
      out.write("        <span>\r\n");
      out.write("            <code id=\"imgUrl\"></code>\r\n");
      out.write("        </span>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}