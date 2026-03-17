package Entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "document")
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d"),
    @NamedQuery(name = "Document.findById", query = "SELECT d FROM Document d WHERE d.id = :id"),
    @NamedQuery(name = "Document.findByFilepath", query = "SELECT d FROM Document d WHERE d.filepath = :filepath"),
    @NamedQuery(name = "Document.findByFilename", query = "SELECT d FROM Document d WHERE d.filename = :filename"),
    @NamedQuery(name = "Document.findByFiletype", query = "SELECT d FROM Document d WHERE d.filetype = :filetype")
})
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "document_id_seq", sequenceName = "document_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_id_seq")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "filepath")
    private String filepath;

    @Basic(optional = false)
    @NotNull
    @Column(name = "filename")
    private String filename;

    @Basic(optional = false)
    @NotNull
    @Column(name = "filetype")
    private String filetype;

    public Document() {
    }

    public Document(Integer id) {
        this.id = id;
    }

    public Document(Integer id, String filepath, String filename, String filetype) {
        this.id = id;
        this.filepath = filepath;
        this.filename = filename;
        this.filetype = filetype;
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    // hashCode, equals, and toString methods

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Document[ id=" + id + " ]";
    }
}
