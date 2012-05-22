package a;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;


/**
 * Servlet implementation class HelloWorld
 */
public class ContainerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContainerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// reading the user input 
		String code= request.getParameter("code"); 
		String r ;
		
		String[] cmd = {code};

		Context cx = Context.enter();

		try{
		Scriptable scope = cx.initStandardObjects();
		try {
			ScriptableObject.defineClass(scope, Container.class);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		String s= "";

		for(int i=0; i < cmd.length;i++){
			
			
			s += cmd[i];
			
		}


		//evaluating a script


		Object result = cx.evaluateString(scope, s, "<cmd>",1, null);

		r = result.toString();
		System.out.println(cx.toString(result));

		}finally{Context.exit();}
		
		PrintWriter out = response.getWriter(); 
		out.println ( "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" + 
				"<html> \n" + 
				"<head> \n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> \n" + 
				"<title> Container Details</title> \n" + 
				"</head> \n" + 
				"<body> \n" + 
				"<font size=\"6px\">" + 
				"Container" + 
				"<br />" + 
				"<p>" +
				"<font size=\"4px\" color=\"blue\">" +
				
				"Result="+r+
				"</p>"+
				"</font> \n" + 
				"</body> \n" + 
				"</html>" 
				); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
