package QLHP.app.domain.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name ="name")
    public String name;

    @NotNull
    @Column(name ="code")
    public String code;

    @NotNull
    @Column(name="unit")
    public String unit;

    @Column(name = "created_at")
    @CreationTimestamp
    public LocalDateTime created_at;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RegItem> regItems =  new HashSet<>();

}
