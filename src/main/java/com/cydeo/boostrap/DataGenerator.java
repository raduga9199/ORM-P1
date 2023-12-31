package com.cydeo.boostrap;

import com.cydeo.repository.CourseRepository;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    public DataGenerator(RegionRepository regionRepository,
                         DepartmentRepository departmentRepository,
                         EmployeeRepository employeeRepository,
                         CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("-------------------REGION START--------------------");
        System.out.println("findByCountry" + regionRepository.findByCountry("Canada"));
        System.out.println("Find unique" + regionRepository.findDistinctByCountry("United States"));
        System.out.println("find by country contains united" + regionRepository.findByCountryContaining("United"));
        System.out.println("find by country contains United and Order by Country" +
                regionRepository.findByCountryContainingOrderByCountry("United"));
        System.out.println("Find top 2 of Canada" + regionRepository.findTop2ByCountry("Canada"));
        System.out.println("-------------------REGION END--------------------");


        System.out.println("-------------------DEPARTMENT START--------------------");
        System.out.println("find by department" + departmentRepository.findByDepartment("Toys"));
        System.out.println("find by division is" + departmentRepository.findByDivisionIs("Outdoors"));
        System.out.println("find by division equals" + departmentRepository.findByDivisionEquals("Outdoors"));
        System.out.println("findDistinctTop3ByDivisionContains" + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));
        System.out.println("-------------------DEPARTMENT END--------------------");


        System.out.println("-------------------EMPLOYEE START--------------------");
        System.out.println("employeeRepository.getEmployeeDetail() = " + employeeRepository.getEmployeeDetail());
        System.out.println("employeeRepository.getEmployeeSalary() = " + employeeRepository.getEmployeeSalary());
        System.out.println("-------------------EMPLOYEE END--------------------");

        System.out.println("-------------------COURSE START--------------------");
        courseRepository.findByCategory("Spring").forEach(System.out::println);
        courseRepository.findByCategoryOrderByName("Spring").forEach(System.out::println);
        System.out.println("courseRepository.existsByName(\"JavaScript for All\") = " + courseRepository.existsByName("JavaScript for All"));
        System.out.println("courseRepository.countByCategory(\"Spring\") = " + courseRepository.countByCategory("Spring"));
        courseRepository.findByNameStartingWith("S").forEach(System.out::println);
        //courseRepository.streamByCategory("Spring").forEach(System.out::println);
        System.out.println("-------------------COURSE END--------------------");

    }
}
