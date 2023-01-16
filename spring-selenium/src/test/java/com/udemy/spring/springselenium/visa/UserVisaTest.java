package com.udemy.spring.springselenium.visa;

import com.udemy.spring.springselenium.SpringBaseTestNGTest;
import com.udemy.spring.springselenium.entity.Customer;
import com.udemy.spring.springselenium.page.visa.VisaRegistrationPage;
import com.udemy.spring.springselenium.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.sql.Date.valueOf;

public class UserVisaTest extends SpringBaseTestNGTest {

    @Autowired
    private VisaRegistrationPage registrationPage;

    @Autowired
    private UserRepository repository;

    @Test
    public void visaTest() {
        List<Customer> users = this.repository.findByFirstNameStartingWith("Mi")
                .stream()
                .limit(3)
                .collect(Collectors.toList());

        users.forEach(u -> {
            this.registrationPage.goTo();
            this.registrationPage.setNames(u.getFirstName(), u.getLastName());
            this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
            this.registrationPage.setBirthDate(u.getDob().toLocalDate());
            this.registrationPage.setContactDetails(u.getEmail(), u.getPhone());
            this.registrationPage.setComments(u.getComments());
            this.registrationPage.submit();

            System.out.println("Confirmation Number: " +
                    this.registrationPage.getConfirmationNumber()
            );
        });
    }

    @Test
    public void visa2Test() {
        List<Customer> users =
                this.repository
                        .findByDobBetween(valueOf("1995-01-01"),
                                valueOf("1999-01-01"))
                .stream()
                .limit(3)
                .collect(Collectors.toList());

        users.forEach(u -> {
            this.registrationPage.goTo();
            this.registrationPage.setNames(u.getFirstName(), u.getLastName());
            this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
            this.registrationPage.setBirthDate(u.getDob().toLocalDate());
            this.registrationPage.setContactDetails(u.getEmail(), u.getPhone());
            this.registrationPage.setComments(u.getComments());
            this.registrationPage.submit();

            System.out.println("Confirmation Number: " +
                    this.registrationPage.getConfirmationNumber()
            );
        });
    }

    @Test(dataProvider = "getData")
    public void visa3Test(Customer u){
        this.registrationPage.goTo();
        this.registrationPage.setNames(u.getFirstName(), u.getLastName());
        this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
        this.registrationPage.setBirthDate(u.getDob().toLocalDate());
        this.registrationPage.setContactDetails(u.getEmail(), u.getPhone());
        this.registrationPage.setComments(u.getComments());
        this.registrationPage.submit();

        logger.info("Request confirmation # INFO : " + this.registrationPage.getConfirmationNumber());
        logger.warn("Request confirmation # WARN : " + this.registrationPage.getConfirmationNumber());

    }

    /**
     * Get test param from testng-suite.xml
     */
    @DataProvider
    public Object[][] getData(ITestContext context){
        return this.repository.findByDobBetween(
                        valueOf(context.getCurrentXmlTest().getParameter("dobFrom")),
                        valueOf(context.getCurrentXmlTest().getParameter("dobTo"))
                )
                .stream()
                .limit(3)
                .map(o -> new Customer[]{o})
                .toArray(Object[][]::new);
    }
}
