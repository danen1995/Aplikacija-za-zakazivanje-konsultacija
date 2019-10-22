/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dane
 */
@Entity
@DiscriminatorValue("3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findByCourseFunction", query = "SELECT d FROM Course d WHERE d.courseFunction = :courseFunction")})
public class Course extends Event implements Serializable {

    @Column(name = "COURSE_FUNCTION")
    private String courseFunction;
    @JoinColumn(name = "SUBJECT_ID", referencedColumnName = "SUBJECT_ID")
    @ManyToOne
    private Subject subjectId;

    public String getCourseFunction() {
        return courseFunction;
    }

    public Subject getSubjectId() {
        return subjectId;
    }

    public void setCourseFunction(String courseFunction) {
        this.courseFunction = courseFunction;
    }

    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }

}
