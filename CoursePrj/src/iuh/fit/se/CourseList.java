package iuh.fit.se;

import java.util.Arrays;

public class CourseList {
    private Course[] courses;
    private int count;

    public CourseList(int size) {
        courses = new Course[size];
        count = 0;
    }

    // Add a new course to the list
    public void addCourse(Course course) {
        if (findCourseById(course.getId()) != null) {
            System.out.println("Course ID already exists, cannot add.");
            return;
        }
        if (count < courses.length) {
            courses[count++] = course;
        } else {
            System.out.println("List is full, cannot add more courses.");
        }
    }

    // Get all courses
    public void getAllCourses() {
        for (int i = 0; i < count; i++) {
            System.out.println(courses[i]);
        }
    }

    // Remove a course by ID
    public void removeCourse(String id) {
        int index = findCourseIndexById(id);
        if (index == -1) {
            System.out.println("Course not found.");
            return;
        }
        for (int i = index; i < count - 1; i++) {
            courses[i] = courses[i + 1];
        }
        courses[--count] = null;
    }

    // Find a course by ID
    public Course findCourseById(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equals(id)) {
                return courses[i];
            }
        }
        return null;
    }

    // Find courses by title (partial match)
    public Course[] findCoursesByTitle(String title) {
        Course[] results = new Course[count];
        int resultCount = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().contains(title)) {
                results[resultCount++] = courses[i];
            }
        }
        return Arrays.copyOf(results, resultCount);
    }

    // Tìm theo Khoa
    public Course[] findCoursesByDepartment(String department) {
        Course[] results = new Course[count];
        int resultCount = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getDepartment().equals(department)) {
                results[resultCount++] = courses[i];
            }
        }
        return Arrays.copyOf(results, resultCount);
    }

    // Sort courses by title
    public void sortCoursesByTitle() {
        Arrays.sort(courses, 0, count, (c1, c2) -> c1.getTitle().compareTo(c2.getTitle()));
    }

    // tìm các khóa học có số tín chỉ lớn nhất.
    public Course[] findCoursesByCredit(int credit) {
        Course[] results = new Course[count];
        int resultCount = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() > credit) {
                results[resultCount++] = courses[i];
            }
        }
        return Arrays.copyOf(results, resultCount);
    }

    // tìm khoa phụ trách có nhiều khóa học nhất.
    public String departmentWithMostCourses() {
        String[] departments = new String[count];
        int[] counts = new int[count];
        int departmentCount = 0;

        for (int i = 0; i < count; i++) {
            String dept = courses[i].getDepartment();
            int index = findDepartmentIndex(departments, departmentCount, dept);
            if (index == -1) {
                departments[departmentCount] = dept;
                counts[departmentCount++] = 1;
            } else {
                counts[index]++;
            }
        }

        int maxIndex = 0;
        for (int i = 1; i < departmentCount; i++) {
            if (counts[i] > counts[maxIndex]) {
                maxIndex = i;
            }
        }

        return departments[maxIndex];
    }

    private int findCourseIndexById(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    private int findDepartmentIndex(String[] departments, int length, String department) {
        for (int i = 0; i < length; i++) {
            if (departments[i].equals(department)) {
                return i;
            }
        }
        return -1;
    }
}

