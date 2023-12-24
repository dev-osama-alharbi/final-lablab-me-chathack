import {Component, Input, OnInit} from '@angular/core';
import {MarkdownComponent} from "ngx-markdown";
import {MarkdownPipe} from "./markdown.pipe";

@Component({
  selector: 'app-result-code',
  standalone: true,
  imports: [
    MarkdownComponent,
    MarkdownPipe
  ],
  templateUrl: './result-code.component.html',
  styleUrl: './result-code.component.css'
})
export class ResultCodeComponent implements OnInit{
  // code = "ghhhhhhh";
  // content: string | null | undefined;
  // @Input() content!: string;
  @Input() content!: string;
  aaaaa: string = "\n" +
    "// Student Entity\n" +
    "\n" +
    "import javax.persistence.Entity;\n" +
    "\n" +
    "import javax.persistence.GeneratedValue;\n" +
    "\n" +
    "import javax.persistence.GenerationType;\n" +
    "\n" +
    "import javax.persistence.Id;\n" +
    "\n" +
    "\n" +
    "@Entity\n" +
    "\n" +
    "public class Student {\n" +
    "\n" +
    "    @Id\n" +
    "\n" +
    "    @GeneratedValue(strategy = GenerationType.IDENTITY)\n" +
    "\n" +
    "    private Long id;\n" +
    "\n" +
    "    private String name;\n" +
    "\n" +
    "    private String nationalId;\n" +
    "\n" +
    "    private String phoneNumber;\n" +
    "\n" +
    "    private String address;\n" +
    "\n" +
    "    // getters and setters\n" +
    "\n" +
    "}\n" +
    "\n" +
    "\n" +
    "// Student Repository\n" +
    "\n" +
    "import org.springframework.data.jpa.repository.JpaRepository;\n" +
    "\n" +
    "\n" +
    "public interface StudentRepository extends JpaRepository<Student, Long> {\n" +
    "\n" +
    "}\n" +
    "\n" +
    "\n" +
    "// Student Service\n" +
    "\n" +
    "import org.springframework.beans.factory.annotation.Autowired;\n" +
    "\n" +
    "import org.springframework.stereotype.Service;\n" +
    "\n" +
    "\n" +
    "@Service\n" +
    "\n" +
    "public class StudentService {\n" +
    "\n" +
    "    @Autowired\n" +
    "\n" +
    "    private StudentRepository studentRepository;\n" +
    "\n" +
    "    // service methods\n" +
    "\n" +
    "}\n" +
    "\n" +
    "\n" +
    "// Attendance Entity\n" +
    "\n" +
    "import javax.persistence.Entity;\n" +
    "\n" +
    "import javax.persistence.GeneratedValue;\n" +
    "\n" +
    "import javax.persistence.GenerationType;\n" +
    "\n" +
    "import javax.persistence.Id;\n" +
    "\n" +
    "import java.util.Date;\n" +
    "\n" +
    "\n" +
    "@Entity\n" +
    "\n" +
    "public class Attendance {\n" +
    "\n" +
    "    @Id\n" +
    "\n" +
    "    @GeneratedValue(strategy = GenerationType.IDENTITY)\n" +
    "\n" +
    "    private Long id;\n" +
    "\n" +
    "    private Long studentId;\n" +
    "\n" +
    "    private String status;\n" +
    "\n" +
    "    private Date dateTime;\n" +
    "\n" +
    "    private Long materialId;\n" +
    "\n" +
    "    // getters and setters\n" +
    "\n" +
    "}\n" +
    "\n" +
    "\n" +
    "// Attendance Repository\n" +
    "\n" +
    "import org.springframework.data.jpa.repository.JpaRepository;\n" +
    "\n" +
    "\n" +
    "public interface AttendanceRepository extends JpaRepository<Attendance, Long> {\n" +
    "\n" +
    "}\n" +
    "\n" +
    "\n" +
    "// Attendance Service\n" +
    "\n" +
    "import org.springframework.beans.factory.annotation.Autowired;\n" +
    "\n" +
    "import org.springframework.stereotype.Service;\n" +
    "\n" +
    "\n" +
    "@Service\n" +
    "\n" +
    "public class AttendanceService {\n" +
    "\n" +
    "    @Autowired\n" +
    "\n" +
    "    private AttendanceRepository attendanceRepository;\n" +
    "\n" +
    "    // service methods\n" +
    "\n" +
    "}\n" +
    "\n" +
    "\n" +
    "// Material Entity\n" +
    "\n" +
    "import javax.persistence.Entity;\n" +
    "\n" +
    "import javax.persistence.GeneratedValue;\n" +
    "\n" +
    "import javax.persistence.GenerationType;\n" +
    "\n" +
    "import javax.persistence.Id;\n" +
    "\n" +
    "\n" +
    "@Entity\n" +
    "\n" +
    "public class Material {\n" +
    "\n" +
    "    @Id\n" +
    "\n" +
    "    @GeneratedValue(strategy = GenerationType.IDENTITY)\n" +
    "\n" +
    "    private Long id;\n" +
    "\n" +
    "    private String name;\n" +
    "\n" +
    "    private String teacherName;\n" +
    "\n" +
    "    private int hours;\n" +
    "\n" +
    "    private String code;\n" +
    "\n" +
    "    // getters and setters\n" +
    "\n" +
    "}\n" +
    "\n" +
    "\n" +
    "// Material Repository\n" +
    "\n" +
    "import org.springframework.data.jpa.repository.JpaRepository;\n" +
    "\n" +
    "\n" +
    "public interface MaterialRepository extends JpaRepository<Material, Long> {\n" +
    "\n" +
    "}\n" +
    "\n" +
    "\n" +
    "// Material Service\n" +
    "\n" +
    "import org.springframework.beans.factory.annotation.Autowired;\n" +
    "\n" +
    "import org.springframework.stereotype.Service;\n" +
    "\n" +
    "\n" +
    "@Service\n" +
    "\n" +
    "public class MaterialService {\n" +
    "\n" +
    "    @Autowired\n" +
    "\n" +
    "    private MaterialRepository materialRepository;\n" +
    "\n" +
    "    // service methods\n" +
    "\n" +
    "}\n" +
    "\n";
    ngOnInit(): void {
      // this.content = "System.out.println(\"hi\");";
      // document.getElementById("content")!.innerHTML = Marked;
    }

}
