package QLHP.app.domain.entity;

import QLHP.app.common.enums.RegisStatus;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RegItem.class)
public abstract class RegItem_ {

	public static volatile SingularAttribute<RegItem, Integer> studentId;
	public static volatile SingularAttribute<RegItem, String> code;
	public static volatile SingularAttribute<RegItem, Student> student;
	public static volatile SingularAttribute<RegItem, Course> course;
	public static volatile SingularAttribute<RegItem, LocalDateTime> created_at;
	public static volatile SingularAttribute<RegItem, String> term;
	public static volatile SingularAttribute<RegItem, Integer> id;
	public static volatile SingularAttribute<RegItem, Integer> courseId;
	public static volatile SingularAttribute<RegItem, RegisStatus> status;

	public static final String STUDENT_ID = "studentId";
	public static final String CODE = "code";
	public static final String STUDENT = "student";
	public static final String COURSE = "course";
	public static final String CREATED_AT = "created_at";
	public static final String TERM = "term";
	public static final String ID = "id";
	public static final String COURSE_ID = "courseId";
	public static final String STATUS = "status";

}

