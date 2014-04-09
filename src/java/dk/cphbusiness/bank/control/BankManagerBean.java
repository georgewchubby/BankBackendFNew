package dk.cphbusiness.bank.control;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountDetail;
import dk.cphbusiness.bank.contract.dto.AccountIdentifier;
import dk.cphbusiness.bank.contract.dto.AccountSummary;
import dk.cphbusiness.bank.contract.dto.CustomerDetail;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.dto.CustomerSummary;
import dk.cphbusiness.bank.contract.eto.CustomerBannedException;
import dk.cphbusiness.bank.contract.eto.InsufficientFundsException;
import dk.cphbusiness.bank.contract.eto.NoSuchAccountException;
import dk.cphbusiness.bank.contract.eto.NoSuchCustomerException;
import dk.cphbusiness.bank.contract.eto.TransferNotAcceptedException;
import static dk.cphbusiness.bank.control.Assembler.*;
import dk.cphbusiness.bank.model.Account;
import dk.cphbusiness.bank.model.Person;
import dk.cphbusiness.bank.model.Postal;
import java.math.BigDecimal;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Saleh
 */
@Stateless
public class BankManagerBean implements BankManager {

    @PersistenceContext(unitName = "BankBackendEPU")
    private EntityManager em;

    @Override
    public String sayHello(String name) {

        return "hello backend" + name;
    }

    @Override
    public Collection<CustomerSummary> listCustomers() {
        Query query = em.createNamedQuery("Person.findAll");
        Collection<Person> persons = query.getResultList();
        return createCustomerSummaries(persons);
    }

    @Override
    public Collection<AccountSummary> listAccounts() {
        Query query = em.createNamedQuery("Account.findAll");
        Collection<Account> accounts = query.getResultList();
        return createAccountSummaries(accounts);
    }

    @Override
    public Collection<AccountSummary> listCustomerAccounts(CustomerIdentifier customer) {
        Person person = em.find(Person.class, customer.getCpr());
        Collection<Account> accounts = person.getAccountCollection();
        return createAccountSummaries(accounts);
    }

    @Override
    public Collection<String> listAccountTypes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AccountDetail transferAmount(BigDecimal amount, AccountIdentifier source, AccountIdentifier target) throws NoSuchAccountException, TransferNotAcceptedException, InsufficientFundsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AccountDetail showAccountHistory(AccountIdentifier account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerDetail saveCustomer(CustomerDetail customer) {
        CustomerDetail cd = null;
        Person p1 = em.find(Person.class, customer.getCpr());
        if (p1 == null) {
            Person p = new Person(customer.getCpr(), customer.getFirstName(), customer.getLastName(), "dtype");
            p.setDtype("Person");
            p.setPostal(new Postal(Integer.parseInt(customer.getPostalCode())));
            p.setEmail(customer.getEmail());
            em.persist(p);
            cd = createCustomerDetail(p);
        }
        if (em.find(Person.class, customer.getCpr()) != null) {
            Person p = em.find(Person.class, customer.getCpr());
            p.setTitle(customer.getTitle());
            p.setFirstname(customer.getFirstName());
            p.setLastname(customer.getLastName());
            p.setStreet(customer.getStreet());
            p.setPhone(customer.getPhone());
            p.setPostal(new Postal(Integer.parseInt(customer.getPostalCode())));
            p.setEmail(customer.getEmail());
            em.persist(p);
            cd = createCustomerDetail(p);
        }
        return cd;
    }

    @Override
    public CustomerDetail showCustomer(CustomerIdentifier customerid) throws NoSuchCustomerException {
        Person customer = em.find(Person.class, customerid.getCpr());
        if (customer == null) {
            throw new NoSuchCustomerException(customerid);
        }
        return createCustomerDetail(customer);
    }

    @Override
    public AccountDetail createAccount(CustomerIdentifier customer, AccountDetail account) throws NoSuchCustomerException, CustomerBannedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean doesUserExist(CustomerIdentifier ci) {
        boolean res = true;
        Person customer = em.find(Person.class, ci.getCpr());
        if (customer != null) {
            res = false;
        }
        return res;
    }
}
