package dashboard.config

import org.springframework.context.annotation.Configuration

@Configuration
class GeneralConfig { //    @Value("${database.username}")
    //    private String username;
    //
    //    @Value("${database.password}")
    //    private String password;
    //
    //    @Value("${database.classURL}")
    //    private String driverClassURL;
    //
    //
    //    @Profile("PROD")
    //    @Bean
    //    public DataSource postgresDataSource(){
    //        DriverManagerDataSource datasource = new DriverManagerDataSource();
    //        datasource.setDriverClassName(driverClassURL);
    //        datasource.setUsername(username);
    //        datasource.setPassword(password);
    //        return datasource;
    //    }
    //
    //    @Profile("PROD")
    //    @Bean
    //    public DataSource h2DataSource(){
    //        DriverManagerDataSource datasource = new DriverManagerDataSource();
    //        datasource.setDriverClassName(driverClassURL);
    //        datasource.setUsername(username);
    //        datasource.setPassword(password);
    //        return datasource;
    //    }
    //    @Bean
    //    MultipartConfigElement multipartConfigElement() {
    //        return new MultipartConfigElement("");
    //    }
    //    @Bean
    //    ResourceAssembler<Employee, Resource<Employee>> userResourceAssembler() {
    //        return (u) -> {
    //            try {
    //                String customersRel = "customers", photoRel = "photo";
    //                Employee user = new Employee(u);
    //                user.setPassword(null);
    //                long userId = user.getId();
    //                Collection<Link> links = new ArrayList<>();
    //                links.add(linkTo(methodOn(EmployeeController.class).loadUser(userId)).withSelfRel());
    //                links.add(linkTo(methodOn(EmployeeController.class).loadUserCustomers(userId)).withRel(customersRel));
    //                return new Resource<>(user, links);
    //            } catch (Exception e) {
    //                throw new RuntimeException(e);
    //            }
    //        };
}