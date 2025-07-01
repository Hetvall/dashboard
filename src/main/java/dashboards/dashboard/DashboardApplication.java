////package dashboards.dashboard;
////
////import org.springframework.boot.SpringApplication;
////import org.springframework.boot.autoconfigure.SpringBootApplication;
////
////@SpringBootApplication
////public class DashboardApplication {
////
////	public static void main(String[] args) {
////		SpringApplication.run(DashboardApplication.class, args);
////	}
////
////}
//
//package dashboards.dashboard;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//@SpringBootApplication
//@ComponentScan(basePackages = "dashboards.dashboard.contentmanagement")
//@EntityScan(basePackages = "dashboards.dashboard.contentmanagement.model")
//@EnableJpaRepositories(basePackages = "dashboards.dashboard.contentmanagement.repositories")
//public class DashboardApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(DashboardApplication.class, args);
//	}
//}
//
package dashboards.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardApplication.class, args);
	}
}