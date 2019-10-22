/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dane
 */
@Entity
@Table(name = "ATTACHMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attachment.findAll", query = "SELECT p FROM Attachment p")
    ,
    @NamedQuery(name = "Attachment.findByAttachmentId", query = "SELECT p FROM Attachment p WHERE p.attachmentId = :attachmentId")
    ,
    @NamedQuery(name = "Attachment.findByName", query = "SELECT p FROM Attachment p WHERE p.name = :name")
    ,
    @NamedQuery(name = "Attachment.findByLocation", query = "SELECT p FROM Attachment p WHERE p.location = :location")})
public class Attachment implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ATTACHMENT_ID")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal attachmentId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LOCATION")
    private byte[] location;
    @JoinColumns({
        @JoinColumn(name = "CALENDAR_ID", referencedColumnName = "CALENDAR_ID")
        ,
        @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID")
        ,
        @JoinColumn(name = "INDEX_NUMBER", referencedColumnName = "INDEX_NUMBER")})
    @ManyToOne
    private ScheduledConsultation scheduledConsultation;

    public Attachment() {
    }

    public Attachment(BigDecimal attachmentId) {
        this.attachmentId = attachmentId;
    }

    public Attachment(String name, byte[] location, ScheduledConsultation scheduledConsultation) {
        this.name = name;
        this.location = location;
        this.scheduledConsultation = scheduledConsultation;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getAttachmentId() {
        return attachmentId;
    }

    public String getName() {
        return name;
    }

    public byte[] getLocation() {
        return location;
    }

    public ScheduledConsultation getScheduledConsultation() {
        return scheduledConsultation;
    }

    public void setAttachmentId(BigDecimal attachmentId) {
        this.attachmentId = attachmentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(byte[] location) {
        this.location = location;
    }

    public void setScheduledConsultation(ScheduledConsultation scheduledConsultation) {
        this.scheduledConsultation = scheduledConsultation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attachmentId != null ? attachmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attachment)) {
            return false;
        }
        Attachment other = (Attachment) object;
        if ((this.attachmentId == null && other.attachmentId != null) || (this.attachmentId != null && !this.attachmentId.equals(other.attachmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diplomski.classes.Prilog[ attachmentId=" + attachmentId + " ]";
    }

}
