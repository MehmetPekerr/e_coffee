package controller;

import dao.DocumentDao;
import entity.Document;
import jakarta.enterprise.context.SessionScoped;
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
    private List<Document> documentList;
    private DocumentDao documentDao;
    private Part doc;
    private final String uploadTo = "C:\\Users\\MP\\Desktop";

    public DocumentBean() {
        document = new Document();
        documentDao = new DocumentDao();
    }

    public void upload() {
        try {
            InputStream input = doc.getInputStream();
            File f = new File(uploadTo + File.separator + doc.getSubmittedFileName());
            Files.copy(input, f.toPath(), StandardCopyOption.REPLACE_EXISTING);

            document.setFilePath(f.getParent());
            document.setFileName(f.getName());
            document.setFileType(doc.getContentType());

            documentDao.insert(document);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Document> getDocumentList() {
        documentList = documentDao.findAll();
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

    public String getUploadTo() {
        return uploadTo;
    }

}
