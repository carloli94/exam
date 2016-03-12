package Servlet;

import Bean.AlchemyConnector;
import Bean.RedisConnector;
import Bean.SetOperations;
import java.io.*;
import java.net.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@WebServlet(name = "IServlet", urlPatterns = {"/IServlet"})
public class IServlet extends HttpServlet {

	private String FACE_ENDPOINT_URL = "http://gateway-a.watsonplatform.net/calls/url/URLGetRankedImageFaceTags";

 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	
		AlchemyConnector connector = new AlchemyConnector();
		//AlchemyVision service = new AlchemyVision();
		//service.setApiKey(connector.getAPIKey());

		String input_url = (String) request.getParameter("gurl");
		StringBuilder sb = new StringBuilder();
		String line;
		String taxonomy = request.getParameter("taxonomy");
		String language = request.getParameter("language");
		String author = request.getParameter("author");
		String sentiment = request.getParameter("sentiment");
		String title = request.getParameter("title");
		HttpSession s = request.getSession();

		SetOperations so = (SetOperations)s.getAttribute("setoper");
		so.add(0, taxonomy);
		so.add(1, language);
		so.add(2, author);
		so.add(3, sentiment);
		so.add(4, title);
		
		request.setAttribute("taxonomy",sb.toString());
		request.setAttribute("language",sb.toString());
		request.setAttribute("author",sb.toString());
		request.setAttribute("sentiment",sb.toString());
		request.setAttribute("title",sb.toString());

		//ImageFaces image_faces = service.recognizeFaces(input_url,false);
		//request.setAttribute("image_faces",image_faces);
	
		response.setContentType("text/html");
        response.setStatus(200);
        request.getRequestDispatcher("Success.jsp").forward(request, response);

	}

}

