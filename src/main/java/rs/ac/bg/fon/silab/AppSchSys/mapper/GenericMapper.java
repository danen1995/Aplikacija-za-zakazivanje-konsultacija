/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.mapper;

import java.util.Collection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.core.GrantedAuthority;
import rs.ac.bg.fon.silab.AppSchSys.dto.CommissionMembershipDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.EventDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.EventPKDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.CalendarDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.ConsultationDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.UserAccountDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.CourseDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.TeacherDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.CoverageDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.CoveragePKDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.SubjectDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.AttachmentDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.SchoolYearDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.StudentDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.ScheduledConsultationDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.ScheduledConsultationPKDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.EventTypeDTO;
import rs.ac.bg.fon.silab.AppSchSys.entities.CommissionMembership;
import rs.ac.bg.fon.silab.AppSchSys.entities.Event;
import rs.ac.bg.fon.silab.AppSchSys.entities.EventPK;
import rs.ac.bg.fon.silab.AppSchSys.entities.Calendar;
import rs.ac.bg.fon.silab.AppSchSys.entities.Consultation;
import rs.ac.bg.fon.silab.AppSchSys.entities.UserAccount;
import rs.ac.bg.fon.silab.AppSchSys.entities.Course;
import rs.ac.bg.fon.silab.AppSchSys.entities.Teacher;
import rs.ac.bg.fon.silab.AppSchSys.entities.Coverage;
import rs.ac.bg.fon.silab.AppSchSys.entities.CoveragePK;
import rs.ac.bg.fon.silab.AppSchSys.entities.Subject;
import rs.ac.bg.fon.silab.AppSchSys.entities.Attachment;
import rs.ac.bg.fon.silab.AppSchSys.entities.Role;
import rs.ac.bg.fon.silab.AppSchSys.entities.SchoolYear;
import rs.ac.bg.fon.silab.AppSchSys.entities.Student;
import rs.ac.bg.fon.silab.AppSchSys.entities.ScheduledConsultation;
import rs.ac.bg.fon.silab.AppSchSys.entities.ScheduledConsultationPK;
import rs.ac.bg.fon.silab.AppSchSys.entities.EventType;

@Mapper(componentModel = "spring")
public interface GenericMapper {

    Collection<Role> grantedAuthoritiesToROLEs(Collection<? extends GrantedAuthority> grantedAuthority);

    @Mapping(target = "roleName", source = "authority")
    Role grantedAuthorityToROLE(GrantedAuthority grantedAuthority);

    UserAccountDTO userAccountToUserAccountDTO(UserAccount UserAccount);

    UserAccount userAccountDTOToUserAccount(UserAccountDTO UserAccountDTO);

    Student studentDTOToStudent(StudentDTO studentDTO);

    StudentDTO studentToStudentDTO(Student student);

    Course courseDTOToCourse(CourseDTO courseDTO);

    CourseDTO courseToCourseDTO(Course course);

    Teacher teacherDTOToteacher(TeacherDTO teacherDTO);

    TeacherDTO teacherToteacherDTO(Teacher teacher);

    ConsultationDTO ConsultationToConsultationDTO(Consultation Consultation);

    Consultation ConsultationDTOToConsultation(ConsultationDTO ConsultationDTO);

    Event eventDTOToEvent(EventDTO eventDTO);

    EventDTO eventToEventDTO(Event event);

    EventPK eventPKDTOToeventPK(EventPKDTO eventPKDTO);

    EventPKDTO eventPKToeventPKDTO(EventPK eventPK);

    Subject subjectDTOToSubject(SubjectDTO subjectDTO);

    SubjectDTO subjectToSubjectDTO(Subject subject);

    Attachment attachmentDTOToAttachment(AttachmentDTO attachmentDTO);

    AttachmentDTO attachmentTOAttachmentDTO(Attachment attachment);

    Calendar calendarDTOToCalendar(CalendarDTO calendarDTO);

    CalendarDTO calendarToCalendarDTO(Calendar calendar);

    Coverage coverageDTOToCoverage(CoverageDTO coverageDTO);

    CoverageDTO coverageToCoverageDTO(Coverage coverage);

    CoveragePK coveragePKDToTocoveragePK(CoveragePKDTO coveragePKDTO);

    CoveragePKDTO coveragePKToCoveragePKDTO(CoveragePK coveragePK);

    SchoolYear schoolYearDTOToSchoolYear(SchoolYearDTO schoolYearDTO);

    SchoolYearDTO schoolYearToSchoolYearDTO(SchoolYear schoolYear);

    EventType eventTypeDTOToEventType(EventTypeDTO eventTypeDTO);

    EventTypeDTO eventTypeToEventTypeDTO(EventType eventType);

    ScheduledConsultationDTO scheduledConsultationToStudentConsultationDTO(ScheduledConsultation scheduledConsultation);

    ScheduledConsultation scheduledConsultationDTOToStudentConsultation(ScheduledConsultationDTO scheduledConsultationDTO);

    ScheduledConsultationPK scheduledConsultationPKDTOToStudentConsultationPK(ScheduledConsultationPKDTO scheduledConsultationPKDTO);

    ScheduledConsultationPKDTO scheduledConsultationPKToscheduledConsultationPKDTO(ScheduledConsultationPK scheduledConsultationPK);

}
