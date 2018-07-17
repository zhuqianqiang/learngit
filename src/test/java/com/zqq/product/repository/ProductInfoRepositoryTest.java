package com.zqq.product.repository;

import com.zqq.product.dataobject.ProductInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = productInfoRepository.findByProductStatus(0);
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void send() {
        amqpTemplate.convertAndSend("MyQueue","now:"+new Date());
    }
}