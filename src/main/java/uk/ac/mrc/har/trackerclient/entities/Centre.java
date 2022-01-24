package uk.ac.mrc.har.trackerclient.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Centre implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer centreId;
    private String shortName;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private boolean isActive;
    private Date created;
    private Date lastUpdate;
    private String imitsName;
    private Collection<Integer> fileSourceCollection;
    private Collection<Integer> xmlFileCollection;
    private Collection<Integer> zipFileCollection;

    public Centre() {
    }

    public Centre(Integer id) {
        this.centreId = id;
    }

    public Centre(Integer id, String shortName, String fullName, String email, boolean isActive, Date created, Date lastUpdate) {
        this.centreId = id;
        this.shortName = shortName;
        this.fullName = fullName;
        this.email = email;
        this.isActive = isActive;
        this.created = created;
        this.lastUpdate = lastUpdate;
    }

    public Integer getCentreId() {
        return centreId;
    }

    public void setCentreId(Integer id) {
        this.centreId = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getImitsName() {
        return imitsName;
    }

    public void setImitsName(String imitsName) {
        this.imitsName = imitsName;
    }

//    @XmlTransient
//    public Collection<FileSource> getFileSourceCollection() {
//        return fileSourceCollection;
//    }
//
//    public void setFileSourceCollection(Collection<FileSource> fileSourceCollection) {
//        this.fileSourceCollection = fileSourceCollection;
//    }
//
//    @XmlTransient
//    public Collection<XmlFile> getXmlFileCollection() {
//        return xmlFileCollection;
//    }
//
//    public void setXmlFileCollection(Collection<XmlFile> xmlFileCollection) {
//        this.xmlFileCollection = xmlFileCollection;
//    }
//
//    @XmlTransient
//    public Collection<ZipFile> getZipFileCollection() {
//        return zipFileCollection;
//    }
//
//    public void setZipFileCollection(Collection<ZipFile> zipFileCollection) {
//        this.zipFileCollection = zipFileCollection;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (centreId != null ? centreId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Centre)) {
            return false;
        }
        Centre other = (Centre) object;
        if ((this.centreId == null && other.centreId != null) || (this.centreId != null && !this.centreId.equals(other.centreId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uk.ac.mrc.har.newtrackerapi.trackerentities.Centre[ centreId=" + centreId + " ]";
    }

}
