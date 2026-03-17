package Util;

import Controller.DocumentBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "FileServlet", urlPatterns = {"/file/*"})
public class FileServlet extends HttpServlet {

    @Inject
    private DocumentBean documentBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String file = request.getPathInfo();
        if (file == null || file.isEmpty() || file.equals("/")) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // Remove leading slash
        file = file.substring(1);

        // Get the file from the upload directory
        File requestedFile = new File(documentBean.getUploadTo() + File.separator + file);

        if (!requestedFile.exists() || requestedFile.isDirectory()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // Set the content type based on the file extension
        String mimeType = getServletContext().getMimeType(requestedFile.getAbsolutePath());
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);
        response.setContentLength((int) requestedFile.length());

        // Set headers for the response
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", requestedFile.getName());
        response.setHeader(headerKey, headerValue);

        // Copy file content to response output stream
        try (FileInputStream fis = new FileInputStream(requestedFile);
             OutputStream os = response.getOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new ServletException("Failed to download file.", e);
        }
    }
}
