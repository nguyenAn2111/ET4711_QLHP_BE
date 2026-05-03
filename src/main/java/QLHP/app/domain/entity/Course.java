package QLHP.app.domain.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import QLHP.app.common.enums.CourseStatus;
import QLHP.app.common.enums.CourseType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @NotNull
    @Column(name = "credit")
    private Integer credit;

    @Column(name = "start_at")
    private Date start_at;

    @Column(name = "end_at")
    private Date end_at;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private CourseType type;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CourseStatus status;

    @Column(name = "regis_num")
    private Integer regis_num;

    @Column(name = "term")
    private String term;

    @CreationTimestamp
    @Column(name ="created_at")
    private LocalDateTime created_at;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RegItem> regItems =  new HashSet<>();
}
