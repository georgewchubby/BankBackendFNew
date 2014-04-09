package dk.cphbusiness.bank.control;

import dk.cphbusiness.bank.contract.dto.AccountSummary;
import dk.cphbusiness.bank.contract.dto.CustomerDetail;
import dk.cphbusiness.bank.contract.dto.CustomerSummary;
import dk.cphbusiness.bank.model.Account;
import dk.cphbusiness.bank.model.Person;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author joachim
 */
public class Assembler {

    public static CustomerSummary createCustomerSummary(Person person) {
        return new CustomerSummary(
                person.getCpr(),
                person.getFirstname() + " " + person.getLastname(),
                person.getStreet() + " " + person.getPostal(),
                person.getPhone(),
                person.getEmail());
    }

    public static Collection<CustomerSummary> createCustomerSummaries(Collection<Person> persons) {
        Collection<CustomerSummary> summaries = new ArrayList<>();
        for (Person person : persons) {
            summaries.add(createCustomerSummary(person));
        }
        return summaries;
    }

    public static Collection<AccountSummary> createAccountSummaries(Collection<Account> accounts) {
        Collection<AccountSummary> summaries = new ArrayList<>();
        for (Account account : accounts) {
            summaries.add(createAccountSummary(account));
        }
        return summaries;
    }

    public static AccountSummary createAccountSummary(Account account) {
        return new AccountSummary(
                account.getAccountnumber(),
                "Checking Account",
                account.getBalance());

    }
    
    public static CustomerDetail createCustomerDetail(Person customer) {
    return new CustomerDetail(
        customer.getCpr(),
        customer.getTitle(),
        customer.getFirstname(),
        customer.getLastname(),
        customer.getStreet(),
        ""+customer.getPostal().getPostalcode(),
        customer.getPostal().getPostaldistrict(),
        customer.getPhone(),
        customer.getEmail()
        );
    }
}
