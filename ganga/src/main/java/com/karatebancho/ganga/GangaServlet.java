/**
 * 
 */
package com.karatebancho.ganga;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.markdown4j.Markdown4jProcessor;

/**
 * @author ysobj
 */
public class GangaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Path test = Paths.get("test.txt");
		resp.setContentType("text/html; charset=utf-8");
		try (InputStream is = Files.newInputStream(test);
				OutputStreamWriter os = new OutputStreamWriter(
						resp.getOutputStream())) {
			os.write("<html><body>");
			String content = new Markdown4jProcessor().process(is);
			os.write(content);
			os.write("</body></html>");
		}
	}
}
