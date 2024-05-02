package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.StatusType.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

import static com.example.demo.entities.StatusType.ordered;


@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CartRepository cartRepository;
    private CustomerRepository customerRepository;
    public CheckoutServiceImpl(CartRepository cartRepository, CustomerRepository customerRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        //Gets cart
        Cart cart = purchase.getCart();

        //Get cart items and put them in cart
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        //Gets customer information & set customer to cart
        Customer customer;
        customer = purchase.getCustomer();
        cart.setCustomer(purchase.getCustomer());


        //Sets cart status
        cart.setStatus(ordered);

        //Save cart
        cartRepository.save(cart);

        //Create and return order tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}

