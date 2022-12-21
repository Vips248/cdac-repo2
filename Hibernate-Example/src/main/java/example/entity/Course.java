package example.entity;

public class Course {
	private String courseId;
	private String name;
	private int duration;
	private int fees;

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String courseId, String name, int duration, int fees) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.duration = duration;
		this.fees = fees;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", duration=" + duration + ", fees=" + fees + "]";
	}

}
