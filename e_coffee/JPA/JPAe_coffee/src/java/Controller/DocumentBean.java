package Controller;

import DAO.DocumentDAO;
import Entity.Document;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Named(value = "documentBean")
@SessionScoped
public class DocumentBean implements Serializable {

    private Document document;

    @Inject
    private DocumentDAO documentDao;

    private Part doc;
    private final String uploadTo = "C:\\Users\\MP\\Desktop"; // Your upload directory path

    public DocumentBean() {
        document = new Document();
    }

    public void upload() {
        try {
            if (doc != null) {
                InputStream input = doc.getInputStream();
                String fileName = doc.getSubmittedFileName();
                if (fileName != null && !fileName.isEmpty()) {
                    File f = new File(uploadTo + File.separator + fileName);
                    Files.copy(input, f.toPath(), StandardCopyOption.REPLACE_EXISTING);

                    document.setFilepath(f.getParent());
                    document.setFilename(f.getName());
                    document.setFiletype(doc.getContentType());

                    documentDao.insert(document);

                    // Reset document object for next upload
                    document = new Document();
                } else {
                    System.out.println("Invalid file name.");
                }
            } else {
                System.out.println("Uploaded file not found.");
            }
        } catch (IOException e) {
            System.out.println("File upload error: " + e.getMessage());
        }
    }

    public List<Document> getDocumentList() {
        return documentDao.findAll();
    }

    // Getters and setters

    public Document getDocument() {
        if (this.document == null) {
            this.document = new Document();
        }
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

    public DocumentDAO getDocumentDao() {
        return documentDao;
    }

    public void setDocumentDao(DocumentDAO documentDao) {
        this.documentDao = documentDao;
    }

    public String getUploadTo() {
        return uploadTo;
    }
}
