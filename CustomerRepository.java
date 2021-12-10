package Repository;

import java.util.*;
import Model.Customer;
import com.sun.deploy.security.SelectableSecurityManager;

public class CustomerRepository {
    public static Map<String, Customer>customerRepo=new HashMap<>();

    public static boolean isExist(String customerId)
    {
        if(customerRepo.containsKey(customerId))
            return true;
        return false;
    }
    public static Customer findById(String customerId)
    {
        if(isExist(customerId))
            return customerRepo.get(customerId);
        return null;
    }
    public static List<Customer> findAll()
    {
        List<Customer>customerList=new ArrayList<>();
            for(Customer cust:customerRepo.values())
            {
                customerList.add(cust);
            }
        return customerList;

    }
    public static String save(Customer customer)
    {
        if(isExist(customer.getId())==false)
        {
            customerRepo.put(customer.getId(),customer);
            return "saved";
        }
        return "Customer Already Registered ";

    }


}
