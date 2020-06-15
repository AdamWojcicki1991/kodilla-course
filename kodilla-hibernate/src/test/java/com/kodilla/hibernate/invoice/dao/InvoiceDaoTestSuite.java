package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;

    @Test
    public void testInvoiceDaoSave() {
        //GIVEN
        Item item = new Item(new BigDecimal(20), 20, new BigDecimal(20));
        Item item2 = new Item(new BigDecimal(30), 30, new BigDecimal(30));
        Item item3 = new Item(new BigDecimal(40), 40, new BigDecimal(40));
        Invoice invoice = new Invoice("FV-T/2020/3035939/04/000139");
        Product product = new Product("Car Leasing");
        item.setProduct(product);
        item2.setProduct(product);
        item3.setProduct(product);
        invoice.getItems().add(item);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        item.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        //WHEN
        productDao.save(product);
        invoiceDao.save(invoice);
        int id_invoice = invoice.getId();
        int id_product = product.getId();
        //THEN
        assertNotEquals(0, id_invoice);
        assertNotEquals(0, id_product);
        //CleanUp
        invoiceDao.deleteById(id_invoice);
        productDao.deleteById(id_product);
    }
}
