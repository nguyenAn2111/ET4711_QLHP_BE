package QLHP.app.domain.entity;

import QLHP.app.common.enums.CourseStatus;
import QLHP.app.common.enums.CourseType;
import java.time.LocalDateTime;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Course.class)
public abstract class Course_ {

	public static volatile SingularAttribute<Course, Date> end_at;
	public static volatile SingularAttribute<Course, String> code;
	public static volatile SingularAttribute<Course, Integer> regis_num;
	public static volatile SetAttribute<Course, RegItem> regItems;
	public static volatile SingularAttribute<Course, String> name;
	public static volatile SingularAttribute<Course, LocalDateTime> created_at;
	public static volatile SingularAttribute<Course, String> term;
	public static volatile SingularAttribute<Course, Integer> id;
	public static volatile SingularAttribute<Course, Integer> credit;
	public static volatile SingularAttribute<Course, Date> start_at;
	public static volatile SingularAttribute<Course, CourseType> type;
	public static volatile SingularAttribute<Course, CourseStatus> status;

	public static final String END_AT = "end_at";
	public static final String CODE = "code";
	public static final String REGIS_NUM = "regis_num";
	public static final String REG_ITEMS = "regItems";
	public static final String NAME = "name";
	public static final String CREATED_AT = "created_at";
	public static final String TERM = "term";
	public static final String ID = "id";
	public static final String CREDIT = "credit";
	public static final String START_AT = "start_at";
	public static final String TYPE = "type";
	public static final String STATUS = "status";

}

