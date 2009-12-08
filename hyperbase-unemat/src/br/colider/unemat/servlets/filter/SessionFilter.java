package br.colider.unemat.servlets.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter{
	
	private ArrayList<String> urlList;
	private int totalUrls;
	
	public void destroy() {
	
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		String url = request.getServletPath();
		
		boolean allowedRequest = false;
		
		for (int i = 0; i < totalUrls; i++) {
			
			if(url.contains(urlList.get(i))){
				allowedRequest = true;
				break;
			}
		}
		
		if(!allowedRequest){
			HttpSession session = request.getSession(false);

//			String username = (String) session.getAttribute("username");
//			if(request.getSession(false) == null)
				 // redirect to login page 
			
			if(session == null){
				//response.sendRedirect("/index.jsp");
			}
		}else{
			System.out.println("avoid url!");
		}
		
		chain.doFilter(req, res);
	}

	public void init(FilterConfig config) throws ServletException {
		
		String urls = config.getInitParameter("avoid-urls");
		
		System.out.println("Filter:" + urls.toString());
		
		StringTokenizer token = new StringTokenizer(urls, ",");
		
		urlList = new ArrayList<String>();
		
		while(token.hasMoreElements()){
			urlList.add(token.nextToken());
		}
		totalUrls = urlList.size();
	}
	
}
