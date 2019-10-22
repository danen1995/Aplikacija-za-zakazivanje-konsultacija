package rs.ac.bg.fon.silab.AppSchSys.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.silab.AppSchSys.entities.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, String> {

    @Query("SELECT s FROM Student s WHERE s.indexNumber = ?1")
    public Student findByIndexNumber(String indexNumber);

}
