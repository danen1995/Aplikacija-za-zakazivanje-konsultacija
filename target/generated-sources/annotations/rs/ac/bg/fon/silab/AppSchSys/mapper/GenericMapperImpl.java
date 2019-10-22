package rs.ac.bg.fon.silab.AppSchSys.mapper;

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Generated;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.silab.AppSchSys.dto.AttachmentDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.CalendarDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.ConsultationDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.CourseDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.CoverageDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.CoveragePKDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.EventDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.EventPKDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.EventTypeDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.ScheduledConsultationDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.ScheduledConsultationPKDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.SchoolYearDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.StudentDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.SubjectDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.TeacherDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.UserAccountDTO;
import rs.ac.bg.fon.silab.AppSchSys.entities.Attachment;
import rs.ac.bg.fon.silab.AppSchSys.entities.Calendar;
import rs.ac.bg.fon.silab.AppSchSys.entities.Consultation;
import rs.ac.bg.fon.silab.AppSchSys.entities.Course;
import rs.ac.bg.fon.silab.AppSchSys.entities.Coverage;
import rs.ac.bg.fon.silab.AppSchSys.entities.CoveragePK;
import rs.ac.bg.fon.silab.AppSchSys.entities.Event;
import rs.ac.bg.fon.silab.AppSchSys.entities.EventPK;
import rs.ac.bg.fon.silab.AppSchSys.entities.EventType;
import rs.ac.bg.fon.silab.AppSchSys.entities.Role;
import rs.ac.bg.fon.silab.AppSchSys.entities.ScheduledConsultation;
import rs.ac.bg.fon.silab.AppSchSys.entities.ScheduledConsultationPK;
import rs.ac.bg.fon.silab.AppSchSys.entities.SchoolYear;
import rs.ac.bg.fon.silab.AppSchSys.entities.Student;
import rs.ac.bg.fon.silab.AppSchSys.entities.Subject;
import rs.ac.bg.fon.silab.AppSchSys.entities.Teacher;
import rs.ac.bg.fon.silab.AppSchSys.entities.UserAccount;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-19T12:43:08+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class GenericMapperImpl implements GenericMapper {

    @Override
    public Collection<Role> grantedAuthoritiesToROLEs(Collection<? extends GrantedAuthority> grantedAuthority) {
        if ( grantedAuthority == null ) {
            return null;
        }

        Collection<Role> collection = new ArrayList<Role>( grantedAuthority.size() );
        for ( GrantedAuthority grantedAuthority1 : grantedAuthority ) {
            collection.add( grantedAuthorityToROLE( grantedAuthority1 ) );
        }

        return collection;
    }

    @Override
    public Role grantedAuthorityToROLE(GrantedAuthority grantedAuthority) {
        if ( grantedAuthority == null ) {
            return null;
        }

        Role role = new Role();

        role.setRoleName( grantedAuthority.getAuthority() );

        return role;
    }

    @Override
    public UserAccountDTO userAccountToUserAccountDTO(UserAccount UserAccount) {
        if ( UserAccount == null ) {
            return null;
        }

        UserAccountDTO userAccountDTO = new UserAccountDTO();

        userAccountDTO.setUserAccountId( UserAccount.getUserAccountId() );
        userAccountDTO.setUserName( UserAccount.getUserName() );
        userAccountDTO.setPassword( UserAccount.getPassword() );
        userAccountDTO.setTeacher( teacherToteacherDTO( UserAccount.getTeacher() ) );
        userAccountDTO.setStudent( studentToStudentDTO( UserAccount.getStudent() ) );
        Collection<Role> collection = UserAccount.getRolеCollection();
        if ( collection != null ) {
            userAccountDTO.setRolеCollection( new ArrayList<Role>( collection ) );
        }
        else {
            userAccountDTO.setRolеCollection( null );
        }

        return userAccountDTO;
    }

    @Override
    public UserAccount userAccountDTOToUserAccount(UserAccountDTO UserAccountDTO) {
        if ( UserAccountDTO == null ) {
            return null;
        }

        UserAccount userAccount = new UserAccount();

        Collection<Role> collection = UserAccountDTO.getRolеCollection();
        if ( collection != null ) {
            userAccount.setRolеCollection( new ArrayList<Role>( collection ) );
        }
        else {
            userAccount.setRolеCollection( null );
        }
        userAccount.setUserAccountId( UserAccountDTO.getUserAccountId() );
        userAccount.setUserName( UserAccountDTO.getUserName() );
        userAccount.setPassword( UserAccountDTO.getPassword() );
        userAccount.setTeacher( teacherDTOToteacher( UserAccountDTO.getTeacher() ) );
        userAccount.setStudent( studentDTOToStudent( UserAccountDTO.getStudent() ) );

        return userAccount;
    }

    @Override
    public Student studentDTOToStudent(StudentDTO studentDTO) {
        if ( studentDTO == null ) {
            return null;
        }

        Student student = new Student();

        student.setIndexNumber( studentDTO.getIndexNumber() );
        student.setFirstName( studentDTO.getFirstName() );
        student.setLastName( studentDTO.getLastName() );
        student.setYearOfEntry( studentDTO.getYearOfEntry() );
        student.setDepartment( studentDTO.getDepartment() );
        student.setTelephone( studentDTO.getTelephone() );
        student.setEmail( studentDTO.getEmail() );

        return student;
    }

    @Override
    public StudentDTO studentToStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setIndexNumber( student.getIndexNumber() );
        studentDTO.setFirstName( student.getFirstName() );
        studentDTO.setLastName( student.getLastName() );
        studentDTO.setYearOfEntry( student.getYearOfEntry() );
        studentDTO.setDepartment( student.getDepartment() );
        studentDTO.setTelephone( student.getTelephone() );
        studentDTO.setEmail( student.getEmail() );

        return studentDTO;
    }

    @Override
    public Course courseDTOToCourse(CourseDTO courseDTO) {
        if ( courseDTO == null ) {
            return null;
        }

        Course course = new Course();

        course.setEventPK( eventPKDTOToeventPK( courseDTO.getEventPK() ) );
        course.setStartDateTime( courseDTO.getStartDateTime() );
        course.setEndDateTime( courseDTO.getEndDateTime() );
        course.setPlace( courseDTO.getPlace() );
        course.setCalendar( calendarDTOToCalendar( courseDTO.getCalendar() ) );
        course.setEventTypeId( eventTypeDTOToEventType( courseDTO.getEventTypeId() ) );
        course.setSubjectId( subjectDTOToSubject( courseDTO.getsubjectId() ) );

        return course;
    }

    @Override
    public CourseDTO courseToCourseDTO(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setEventPK( eventPKToeventPKDTO( course.getEventPK() ) );
        courseDTO.setStartDateTime( course.getStartDateTime() );
        courseDTO.setEndDateTime( course.getEndDateTime() );
        courseDTO.setPlace( course.getPlace() );
        courseDTO.setCalendar( calendarToCalendarDTO( course.getCalendar() ) );
        courseDTO.setEventTypeId( eventTypeToEventTypeDTO( course.getEventTypeId() ) );
        courseDTO.setsubjectId( subjectToSubjectDTO( course.getSubjectId() ) );

        return courseDTO;
    }

    @Override
    public Teacher teacherDTOToteacher(TeacherDTO teacherDTO) {
        if ( teacherDTO == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setTeacherId( teacherDTO.getTeacherId() );
        teacher.setFirstName( teacherDTO.getFirstName() );
        teacher.setLastName( teacherDTO.getLastName() );
        teacher.setEmail( teacherDTO.getEmail() );
        teacher.setTelephone( teacherDTO.getTelephone() );
        teacher.setCabinet( teacherDTO.getCabinet() );
        teacher.setImage( teacherDTO.getImage() );

        return teacher;
    }

    @Override
    public TeacherDTO teacherToteacherDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherDTO teacherDTO = new TeacherDTO();

        teacherDTO.setTeacherId( teacher.getTeacherId() );
        teacherDTO.setFirstName( teacher.getFirstName() );
        teacherDTO.setLastName( teacher.getLastName() );
        teacherDTO.setEmail( teacher.getEmail() );
        teacherDTO.setTelephone( teacher.getTelephone() );
        teacherDTO.setCabinet( teacher.getCabinet() );
        teacherDTO.setImage( teacher.getImage() );

        return teacherDTO;
    }

    @Override
    public ConsultationDTO ConsultationToConsultationDTO(Consultation Consultation) {
        if ( Consultation == null ) {
            return null;
        }

        ConsultationDTO consultationDTO = new ConsultationDTO();

        consultationDTO.setEventPK( eventPKToeventPKDTO( Consultation.getEventPK() ) );
        consultationDTO.setStartDateTime( Consultation.getStartDateTime() );
        consultationDTO.setEndDateTime( Consultation.getEndDateTime() );
        consultationDTO.setPlace( Consultation.getPlace() );
        consultationDTO.setCalendar( calendarToCalendarDTO( Consultation.getCalendar() ) );
        consultationDTO.setEventTypeId( eventTypeToEventTypeDTO( Consultation.getEventTypeId() ) );
        consultationDTO.setCapacity( Consultation.getCapacity() );
        consultationDTO.setNumberOfScheduledCons( Consultation.getNumberOfScheduledCons() );

        return consultationDTO;
    }

    @Override
    public Consultation ConsultationDTOToConsultation(ConsultationDTO ConsultationDTO) {
        if ( ConsultationDTO == null ) {
            return null;
        }

        Consultation consultation = new Consultation();

        consultation.setEventPK( eventPKDTOToeventPK( ConsultationDTO.getEventPK() ) );
        consultation.setStartDateTime( ConsultationDTO.getStartDateTime() );
        consultation.setEndDateTime( ConsultationDTO.getEndDateTime() );
        consultation.setPlace( ConsultationDTO.getPlace() );
        consultation.setCalendar( calendarDTOToCalendar( ConsultationDTO.getCalendar() ) );
        consultation.setEventTypeId( eventTypeDTOToEventType( ConsultationDTO.getEventTypeId() ) );
        consultation.setCapacity( ConsultationDTO.getCapacity() );
        consultation.setNumberOfScheduledCons( ConsultationDTO.getNumberOfScheduledCons() );

        return consultation;
    }

    @Override
    public Event eventDTOToEvent(EventDTO eventDTO) {
        if ( eventDTO == null ) {
            return null;
        }

        Event event = new Event();

        event.setEventPK( eventPKDTOToeventPK( eventDTO.getEventPK() ) );
        event.setStartDateTime( eventDTO.getStartDateTime() );
        event.setEndDateTime( eventDTO.getEndDateTime() );
        event.setPlace( eventDTO.getPlace() );
        event.setCalendar( calendarDTOToCalendar( eventDTO.getCalendar() ) );
        event.setEventTypeId( eventTypeDTOToEventType( eventDTO.getEventTypeId() ) );

        return event;
    }

    @Override
    public EventDTO eventToEventDTO(Event event) {
        if ( event == null ) {
            return null;
        }

        EventDTO eventDTO = new EventDTO();

        eventDTO.setEventPK( eventPKToeventPKDTO( event.getEventPK() ) );
        eventDTO.setStartDateTime( event.getStartDateTime() );
        eventDTO.setEndDateTime( event.getEndDateTime() );
        eventDTO.setPlace( event.getPlace() );
        eventDTO.setCalendar( calendarToCalendarDTO( event.getCalendar() ) );
        eventDTO.setEventTypeId( eventTypeToEventTypeDTO( event.getEventTypeId() ) );

        return eventDTO;
    }

    @Override
    public EventPK eventPKDTOToeventPK(EventPKDTO eventPKDTO) {
        if ( eventPKDTO == null ) {
            return null;
        }

        EventPK eventPK = new EventPK();

        eventPK.setCalendarId( eventPKDTO.getcalendarId() );
        eventPK.setEventId( eventPKDTO.geteventId() );

        return eventPK;
    }

    @Override
    public EventPKDTO eventPKToeventPKDTO(EventPK eventPK) {
        if ( eventPK == null ) {
            return null;
        }

        EventPKDTO eventPKDTO = new EventPKDTO();

        eventPKDTO.seteventId( eventPK.getEventId() );
        eventPKDTO.setcalendarId( eventPK.getCalendarId() );

        return eventPKDTO;
    }

    @Override
    public Subject subjectDTOToSubject(SubjectDTO subjectDTO) {
        if ( subjectDTO == null ) {
            return null;
        }

        Subject subject = new Subject();

        return subject;
    }

    @Override
    public SubjectDTO subjectToSubjectDTO(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectDTO subjectDTO = new SubjectDTO();

        return subjectDTO;
    }

    @Override
    public Attachment attachmentDTOToAttachment(AttachmentDTO attachmentDTO) {
        if ( attachmentDTO == null ) {
            return null;
        }

        Attachment attachment = new Attachment();

        return attachment;
    }

    @Override
    public AttachmentDTO attachmentTOAttachmentDTO(Attachment attachment) {
        if ( attachment == null ) {
            return null;
        }

        AttachmentDTO attachmentDTO = new AttachmentDTO();

        return attachmentDTO;
    }

    @Override
    public Calendar calendarDTOToCalendar(CalendarDTO calendarDTO) {
        if ( calendarDTO == null ) {
            return null;
        }

        Calendar calendar = new Calendar();

        calendar.setCalendarId( calendarDTO.getCalendarId() );
        calendar.setSchoolYearId( schoolYearDTOToSchoolYear( calendarDTO.getSchoolYearId() ) );

        return calendar;
    }

    @Override
    public CalendarDTO calendarToCalendarDTO(Calendar calendar) {
        if ( calendar == null ) {
            return null;
        }

        CalendarDTO calendarDTO = new CalendarDTO();

        calendarDTO.setCalendarId( calendar.getCalendarId() );
        calendarDTO.setSchoolYearId( schoolYearToSchoolYearDTO( calendar.getSchoolYearId() ) );

        return calendarDTO;
    }

    @Override
    public Coverage coverageDTOToCoverage(CoverageDTO coverageDTO) {
        if ( coverageDTO == null ) {
            return null;
        }

        Coverage coverage = new Coverage();

        coverage.setCoveragePK( coveragePKDToTocoveragePK( coverageDTO.getCoveragePK() ) );
        coverage.setFunction( coverageDTO.getFunction() );
        coverage.setTeacher( teacherDTOToteacher( coverageDTO.getTeacher() ) );
        coverage.setSubject( subjectDTOToSubject( coverageDTO.getSubject() ) );
        coverage.setSchoolYearId( schoolYearDTOToSchoolYear( coverageDTO.getSchoolYearId() ) );

        return coverage;
    }

    @Override
    public CoverageDTO coverageToCoverageDTO(Coverage coverage) {
        if ( coverage == null ) {
            return null;
        }

        CoverageDTO coverageDTO = new CoverageDTO();

        coverageDTO.setCoveragePK( coveragePKToCoveragePKDTO( coverage.getCoveragePK() ) );
        coverageDTO.setFunction( coverage.getFunction() );
        coverageDTO.setTeacher( teacherToteacherDTO( coverage.getTeacher() ) );
        coverageDTO.setSubject( subjectToSubjectDTO( coverage.getSubject() ) );
        coverageDTO.setSchoolYearId( schoolYearToSchoolYearDTO( coverage.getSchoolYearId() ) );

        return coverageDTO;
    }

    @Override
    public CoveragePK coveragePKDToTocoveragePK(CoveragePKDTO coveragePKDTO) {
        if ( coveragePKDTO == null ) {
            return null;
        }

        CoveragePK coveragePK = new CoveragePK();

        return coveragePK;
    }

    @Override
    public CoveragePKDTO coveragePKToCoveragePKDTO(CoveragePK coveragePK) {
        if ( coveragePK == null ) {
            return null;
        }

        CoveragePKDTO coveragePKDTO = new CoveragePKDTO();

        return coveragePKDTO;
    }

    @Override
    public SchoolYear schoolYearDTOToSchoolYear(SchoolYearDTO schoolYearDTO) {
        if ( schoolYearDTO == null ) {
            return null;
        }

        SchoolYear schoolYear = new SchoolYear();

        schoolYear.setSchoolYearId( schoolYearDTO.getSchoolYearId() );
        schoolYear.setSchoolYear( schoolYearDTO.getSchoolYear() );
        schoolYear.setSemester( schoolYearDTO.getSemester() );

        return schoolYear;
    }

    @Override
    public SchoolYearDTO schoolYearToSchoolYearDTO(SchoolYear schoolYear) {
        if ( schoolYear == null ) {
            return null;
        }

        SchoolYearDTO schoolYearDTO = new SchoolYearDTO();

        schoolYearDTO.setSchoolYearId( schoolYear.getSchoolYearId() );
        schoolYearDTO.setSchoolYear( schoolYear.getSchoolYear() );
        schoolYearDTO.setSemester( schoolYear.getSemester() );

        return schoolYearDTO;
    }

    @Override
    public EventType eventTypeDTOToEventType(EventTypeDTO eventTypeDTO) {
        if ( eventTypeDTO == null ) {
            return null;
        }

        EventType eventType = new EventType();

        eventType.setEventTypeId( eventTypeDTO.getEventTypeId() );

        return eventType;
    }

    @Override
    public EventTypeDTO eventTypeToEventTypeDTO(EventType eventType) {
        if ( eventType == null ) {
            return null;
        }

        EventTypeDTO eventTypeDTO = new EventTypeDTO();

        eventTypeDTO.setEventTypeId( eventType.getEventTypeId() );

        return eventTypeDTO;
    }

    @Override
    public ScheduledConsultationDTO scheduledConsultationToStudentConsultationDTO(ScheduledConsultation scheduledConsultation) {
        if ( scheduledConsultation == null ) {
            return null;
        }

        ScheduledConsultationDTO scheduledConsultationDTO = new ScheduledConsultationDTO();

        scheduledConsultationDTO.setStudentConsultationPK( scheduledConsultationPKToscheduledConsultationPKDTO( scheduledConsultation.getStudentConsultationPK() ) );
        scheduledConsultationDTO.setStatus( scheduledConsultation.getStatus() );
        scheduledConsultationDTO.setTitle( scheduledConsultation.getTitle() );
        scheduledConsultationDTO.setDescription( scheduledConsultation.getDescription() );
        scheduledConsultationDTO.setConsultation( ConsultationToConsultationDTO( scheduledConsultation.getConsultation() ) );
        scheduledConsultationDTO.setStudent( studentToStudentDTO( scheduledConsultation.getStudent() ) );

        return scheduledConsultationDTO;
    }

    @Override
    public ScheduledConsultation scheduledConsultationDTOToStudentConsultation(ScheduledConsultationDTO scheduledConsultationDTO) {
        if ( scheduledConsultationDTO == null ) {
            return null;
        }

        ScheduledConsultation scheduledConsultation = new ScheduledConsultation();

        scheduledConsultation.setStudentConsultationPK( scheduledConsultationPKDTOToStudentConsultationPK( scheduledConsultationDTO.getStudentConsultationPK() ) );
        scheduledConsultation.setStatus( scheduledConsultationDTO.getStatus() );
        scheduledConsultation.setTitle( scheduledConsultationDTO.getTitle() );
        scheduledConsultation.setDescription( scheduledConsultationDTO.getDescription() );
        scheduledConsultation.setConsultation( ConsultationDTOToConsultation( scheduledConsultationDTO.getConsultation() ) );
        scheduledConsultation.setStudent( studentDTOToStudent( scheduledConsultationDTO.getStudent() ) );

        return scheduledConsultation;
    }

    @Override
    public ScheduledConsultationPK scheduledConsultationPKDTOToStudentConsultationPK(ScheduledConsultationPKDTO scheduledConsultationPKDTO) {
        if ( scheduledConsultationPKDTO == null ) {
            return null;
        }

        ScheduledConsultationPK scheduledConsultationPK = new ScheduledConsultationPK();

        scheduledConsultationPK.setCalendarId( scheduledConsultationPKDTO.getcalendarId() );
        scheduledConsultationPK.setEventId( scheduledConsultationPKDTO.geteventId() );

        return scheduledConsultationPK;
    }

    @Override
    public ScheduledConsultationPKDTO scheduledConsultationPKToscheduledConsultationPKDTO(ScheduledConsultationPK scheduledConsultationPK) {
        if ( scheduledConsultationPK == null ) {
            return null;
        }

        ScheduledConsultationPKDTO scheduledConsultationPKDTO = new ScheduledConsultationPKDTO();

        scheduledConsultationPKDTO.setcalendarId( scheduledConsultationPK.getCalendarId() );
        scheduledConsultationPKDTO.seteventId( scheduledConsultationPK.getEventId() );

        return scheduledConsultationPKDTO;
    }
}
