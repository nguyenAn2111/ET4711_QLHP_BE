package QLHP.app.domain.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Student.class)
public abstract class Student_ {

	public static volatile SingularAttribute<Student, String> unit;
	public static volatile SingularAttribute<Student, String> code;
	public static volatile SetAttribute<Student, RegItem> regItems;
	public static volatile SingularAttribute<Student, String> name;
	public static volatile SingularAttribute<Student, LocalDateTime> created_at;
	public static volatile SingularAttribute<Student, Integer> id;

	public static final String UNIT = "unit";
	public static final String CODE = "code";
	public static final String REG_ITEMS = "regItems";
	public static final String NAME = "name";
	public static final String CREATED_AT = "created_at";
	public static final String ID = "id";

}

