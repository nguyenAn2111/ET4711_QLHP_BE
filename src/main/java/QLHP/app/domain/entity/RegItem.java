package QLHP.app.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import QLHP.app.common.enums.RegisStatus;
import io.swagger.v3.core.util.Constants;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedAttributeNode;

import java.time.LocalDateTime;

@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "registration")
@NamedEntityGraph(
        name = "RegItem.student",
        attributeNodes = {
                @NamedAttributeNode("student"),
                @NamedAttributeNode("course")
        }
)
public class RegItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "code")
    public String code;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    public RegisStatus status;


//    @Column(name = "student_id")
//    private Integer studentId;
//
//    @Column(name = "course_id")
//    private Integer courseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="course_id", referencedColumnName = "id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName ="id")
    private Student student;


    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime created_at;
//    public LocalDateTime updated_at;

    @Column(name = "term")
    public String term;

}
