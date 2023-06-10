package com.example.assemble;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssembleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssembleApplication.class, args);
    }


   /* @Bean
    public CommandLineRunner runner(CategoryService categoryService, IncomeService incomeService){
        return args -> {

            categoryService.saveCategory(new CategoryDto("Salary"));
            categoryService.saveCategory(new CategoryDto("Freelance"));
            categoryService.saveCategory(new CategoryDto("Investment"));
            categoryService.saveCategory(new CategoryDto("Risk Analyst"));

          //  incomeService.saveIncome(new IncomeDto("2022-12-12", "woodcore", 200000));
           // incomeService.saveIncome(new IncomeDto(2020-12-12, "Woodcore", 20000, 1));
        };

        insert into categort value(1, `Salary`);
        insert into categort value(2, `Remote`);
        insert into categort value(3, `Investment`);
        insert into categort value(4, `Fixed Deposi`);
        insert into categort value(5, `Savings`);
        insert into category value (6, `Credit Analyst`);


        insert into income value (1, `2019-06-16T17:00:00.000z`, `Jan salary`, 88000, 1)
        insert into income value (1, `2019-07-16T17:00:00.000z`, `Jan gig`, 70000, 2)
        insert into income value (1, `2019-08-16T17:00:00.000z`, `Feb Sallary`, 98000, 1)
        insert into income value (1, `2019-09-16T17:00:00.000z`, `Feb gig`, 98000, 2)
        insert into income value (1, `2019-08-16T17:00:00.000z`, `returns`, 28000, 3)
        insert into income value (1, `2019-02-16T17:00:00.000z`, `interest on FD`, 28000, 4)
        insert into income value (1, `2019-01-16T17:00:00.000z`, `payment as analyst`, 980000, 6)
        insert into income value (1, `2019-03-16T17:00:00.000z`, `savins intterest`, 88000, 5)
        insert into income value (1, `2020-06-16T17:00:00.000z`, `salary for march`, 128000, 1)
        insert into income value (1, `2020-06-16T17:00:00.000z`, `gig`, 878000, 2)
        insert into income v

    } */

}
