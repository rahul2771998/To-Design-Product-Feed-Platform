package Service;

import Model.Customer;
import Model.Seller;
import Repository.CustomerRepository;
import Repository.SellerRepository;
import java.util.*;

public class CustomerService {

    public static void createCustomer(String id,String name, String email,long phone,String address)
    {
        Customer customer=new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setAddress(address);
        System.out.println(CustomerRepository.save(customer));
    }
    public static void getSeller()
    {

        for(Seller seller: SellerRepository.findAll())
            System.out.println(seller.getId()+ " "+seller.getName());
    }
    public static void subscribeToSeller(String customerId,String sellerId) {
        if (CustomerRepository.isExist(customerId) && SellerRepository.isExist(sellerId)) {
            Customer customer = CustomerRepository.findById(customerId);
        List<String> sellerIds = CustomerRepository.findById(customerId).getSubSellerId();
        sellerIds.add(sellerId);
        customer.setSubSellerId(sellerIds);
        CustomerRepository.save(customer);
        System.out.println("Customer "+ customerId+" subscribe to seller "+ sellerId+"  successfully");
    }
        else
        {
            System.out.println("Invalid CustomerId or SellerId");
        }

    }
    public static void desubscribeToSeller(String customerId,String sellerId)
    {
        if(CustomerRepository.isExist(customerId)&& SellerRepository.isExist(sellerId)) {
            Customer customer = CustomerRepository.findById(customerId);
            List<String> sellerIds = CustomerRepository.findById(customerId).getSubSellerId();
            List<String> newSellerIds = new ArrayList<>();
            if (SellerRepository.isExist(sellerId)) {

                for (String id : sellerIds) {
                    if (id.equalsIgnoreCase(sellerId))
                        continue;
                    newSellerIds.add(id);
                }
                customer.setSubSellerId(sellerIds);
                CustomerRepository.save(customer);
                System.out.println("Customer "+ customerId+" desubscribe to seller "+ sellerId+"  successfully");
            }

        }
        else
        {
            System.out.println("Invalid CustomerID or SellerId");
        }
    }

}
    Features expected:
        1. Seller
        a. Seller can be created using platform
        b. Seller can publish multiple posts.
        2. Customer
        a. Customers can be created using a platform.
        b. Customers can get a list of existing sellers.
        c. Customers can subscribe to sellers.
        3. Feed
        a. Customer can fetch feeds based on Ranking function.
        4. Seller can delete his multiple posts.
        5. Customer can unsubscribe to sellers.
        6. Bonus(only attempt if time permits):
        Customers can upvote/downvote a product post by a seller.
        Seller’s current rating will be function of total upvotes & downvotes on their posts. For
        simplicity consider rating = Positive of [5 * (total upvotes)/(total upvotes + total downvotes)]. ie.
        Here 5 is beginning rating.