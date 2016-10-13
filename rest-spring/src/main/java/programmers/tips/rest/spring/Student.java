package programmers.tips.rest.spring;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author Adrian Rosello Rey
 *
 */
public class Student implements Serializable {
	
	private static final long serialVersionUID = 7517761047571228009L;

	// used to auto-generate the id of a Student. Id will be sequencial,
	// starting from 1000.
	private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);

	private long id;
	private String name;
	private Short age;

	public Student() {
		this.id = ID_GENERATOR.getAndIncrement();
	}

	public Student(String name, Short age) {
		this.id = ID_GENERATOR.getAndIncrement();
		this.name = name;
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getAge() {
		return age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
