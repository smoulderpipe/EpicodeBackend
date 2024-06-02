package it.epicode.u5w7d1teoria.security;

import it.epicode.u5w7d1teoria.dto.StudentDto;
import it.epicode.u5w7d1teoria.entity.Student;
import it.epicode.u5w7d1teoria.exception.NotFoundException;
import it.epicode.u5w7d1teoria.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public String saveStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setBirthDate(studentDto.getBirthDate());

        studentRepository.save(student);

        return "Student with id " + student.getId() + " correctly saved!";
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(int id, StudentDto studentDto) {
        Optional<Student> studentOptional = getStudentById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setName(studentDto.getName());
            student.setSurname(studentDto.getSurname());
            student.setBirthDate(studentDto.getBirthDate());

            return studentRepository.save(student);
        } else {
            throw new NotFoundException("Student with id=" + id + " not found!");
        }
    }

    public String deleteStudent(int id) {
        Optional<Student> studentOptional = getStudentById(id);
        if (studentOptional.isPresent()) {
            studentRepository.deleteById(id);
            return "Student with id=" + id + " correctly deleted!";
        } else {
            throw new NotFoundException("Utente with id=" + id + " not found!");
        }
    }
}