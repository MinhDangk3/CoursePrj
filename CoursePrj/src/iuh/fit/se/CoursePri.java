package iuh.fit.se;

import java.util.Scanner;

//public class CoursePri {
	import java.util.Scanner;

	public class CoursePri {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        CourseList courseList = new CourseList(100);
	        
	        boolean exit = false;

	        while (!exit) {
	            // Hiển thị menu lựa chọn
	            System.out.println("\n=== Quản Lý Khóa Học===");
	            System.out.println("1. Thêm Khóa học");
	            System.out.println("2. Xóa ");
	            System.out.println("3. Tìm kiếm theo mã");
	            System.out.println("4. Tìm kiếm theo tên ");
	            System.out.println("5. Hiển thị tất cả các khóa học");
	            System.out.println("6. Sắp xếp các khóa học theo tên");
	            System.out.println("7.tìm kiếm các khóa học theo khoa phụ trách ");
	            System.out.println("8.tìm kiếm các khóa học theo khoa phụ trách ");
	            System.out.println("9. tìm các khóa học có số tín chỉ lớn nhất.");
	            System.out.println("10. Exit");
	            System.out.print("Mời bạn chọn: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine();  

	            switch (choice) {
	                case 1:
	                    // Thêm khóa học
	                    System.out.print(" ID: ");
	                    String id = scanner.nextLine();
	                    System.out.print("Tên khóa học: ");
	                    String title = scanner.nextLine();
	                    System.out.print("Số tín chỉ: ");
	                    int credit = scanner.nextInt();
	                    scanner.nextLine();  
	                    System.out.print("Nhập khoa khóa học: ");
	                    String department = scanner.nextLine();
	                    
	                    Course newCourse = new Course(id, title, credit, department);
	                    courseList.addCourse(newCourse);
	                    System.out.println("Thêm Thành Công.");
	                    break;

	                case 2:
	                    // Xóa khóa học
	                    System.out.print("Nhập ID cần xóa: ");
	                    String removeId = scanner.nextLine();
	                    courseList.removeCourse(removeId);
	                    break;

	                case 3:
	                    // Tìm khóa học theo ID
	                    System.out.print("Nhập ID cần tìm: ");
	                    String findId = scanner.nextLine();
	                    Course courseById = courseList.findCourseById(findId);
	                    if (courseById != null) {
	                        System.out.println(courseById);
	                    } else {
	                        System.out.println("Không tìn thấy");
	                    }
	                    break;

	                case 4:
	                    // Tìm khóa học theo tên
	                    System.out.print("Nhập tên khóa học cần tìm: ");
	                    String searchTitle = scanner.nextLine();
	                    Course[] coursesByTitle = courseList.findCoursesByTitle(searchTitle);
	                    if (coursesByTitle.length > 0) {
	                        for (Course c : coursesByTitle) {
	                            System.out.println(c);
	                        }
	                    } else {
	                        System.out.println("Không tìm thấy:");
	                    }
	                    break;

	                case 5:
	                    // Hiển thị tất cả khóa học
	                    System.out.println("Danh sách tất cả các Khóa Học:");
	                    courseList.getAllCourses();
	                    break;

	                case 6:
	                    // Sắp xếp khóa học theo tên
	                    System.out.println("Sắp xếp các khóa học theo tên");
	                    courseList.sortCoursesByTitle();
	                    courseList.getAllCourses();
	                    break;

	                case 7:
	                    // Tìm khoa có nhiều khóa học nhất
	                    System.out.println("Khoa có nhiều khóa học nhất: " + courseList.findCoursesByCredit(10));
	                    break;
	                    
	                case 8:   
	                	System.out.print("Nhập tên khóa học theo khoa phụ trách : ");
                    String searchdepartment = scanner.nextLine();
                    Course[] coursesBydepartment = courseList.findCoursesByTitle(searchdepartment);
                    if (coursesBydepartment.length > 0) {
                        for (Course c : coursesBydepartment) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("Không tìm thấy:");
                    }
                    break;

	                case 9:
	                    // Tìm khoa có nhiều khóa học nhất
	                    System.out.println("Khoá học có số tín chỉ lớn nhất: " + courseList.departmentWithMostCourses());
	                    break;
	                case 10:
	                    // Thoát chương trình
	                    exit = true;
	                    System.out.println("Thoát.");
	                    break;
	                

	                default:
	                    System.out.println("Lựa chọn k hợp lệ.vui lòng nhập lại ^-^!!");
	                    break;
	            }
	        }

	        scanner.close();
	    }
	}



