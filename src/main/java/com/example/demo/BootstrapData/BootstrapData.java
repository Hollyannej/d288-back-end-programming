package com.example.demo.BootstrapData;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootstrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootstrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (customerRepository.count() == 1) {

            Division HalDid = divisionRepository.findById(9L).orElse(null);
            Division BenderDid = divisionRepository.findById(2L).orElse(null);
            Division PhilipDid = divisionRepository.findById(3L).orElse(null);
            Division GokuDid = divisionRepository.findById(4L).orElse(null);
            Division ZeldaDid = divisionRepository.findById(5L).orElse(null);


            Customer a = new Customer();
            a.setFirstName("HAL");
            a.setLastName("9000");
            a.setAddress("123 Main St");
            a.setPostal_code("50000");
            a.setPhone("555123456");
            a.setDivision(HalDid);
            customerRepository.save(a);


            Customer b = new Customer();
            b.setFirstName("Bender");
            b.setLastName("Rodrigez");
            b.setAddress("890 Rum Ln");
            b.setPostal_code("80000");
            b.setPhone("5559876543");
            b.setDivision(BenderDid);
            customerRepository.save(b);


            Customer c = new Customer();
            c.setFirstName("Philip");
            c.setLastName("Fry");
            c.setAddress("321 Earth St");
            c.setPostal_code("56823");
            c.setPhone("5557650930");
            c.setDivision(PhilipDid);
            customerRepository.save(c);


            Customer d = new Customer();
            d.setFirstName("Goku");
            d.setLastName("Son");
            d.setAddress("765 Tokyo St");
            d.setPostal_code("90000");
            d.setPhone("5553217654");
            d.setDivision(GokuDid);
            customerRepository.save(d);


            Customer e = new Customer();
            e.setFirstName("Zelda");
            e.setLastName("Princess");
            e.setAddress("789 Hyrule Ln");
            e.setPostal_code("98765");
            e.setPhone("5553459876");
            e.setDivision(ZeldaDid);
            customerRepository.save(e);

            customerRepository.findAll();
        }

    }

    }
