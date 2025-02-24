package iuh.fit.se;

public class Course {
    private String id;
    private String title;
    private int credit;
    private String department;

    public Course(String id, String title, int credit, String department) {
        if (id.length() < 3 || !id.matches(".*[a-zA-Z].*")) {
            throw new IllegalArgumentException("ID must contain at least one letter and be at least 3 characters long.");
        }
        if (credit <= 0) {
            throw new IllegalArgumentException("Credit must be greater than 0.");
        }
        this.id = id;
        this.title = title;
        this.credit = credit;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCredit() {
        return credit;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
    	return String.format("%10s %10s %10s %10s ",id ,title,credit,department);
       // return "Course ID: " + id + ", Title: " + title + ", Credit: " + credit + ", Department: " + department;
    }
}

