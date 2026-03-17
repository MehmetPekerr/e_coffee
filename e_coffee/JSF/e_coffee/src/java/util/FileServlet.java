/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package util;

import controller.DocumentBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

/**
 *
 * @author MP
 */
@WebServlet(name = "FileServlet", urlPatterns = {"/file/*"})
public class FileServlet extends HttpServlet {

    @Inject
    private DocumentBean dc;

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        String file = request.getPathInfo();
        File f = new File(dc.getUploadTo()+file);
        
        Files.copy(f.toPath(), response.getOutputStream());
    }

    
}
