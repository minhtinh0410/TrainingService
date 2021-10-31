package com.example.userservice.service;

import com.example.userservice.entity.Order;
import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.vo.ReponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user){ return  userRepository.save(user);}

    public ReponseTemplateVO getUserWithOrder(Long userId){
        ReponseTemplateVO vo = new ReponseTemplateVO();
        User user = userRepository.findById(userId).get();
        vo.setUser(user);
        Order order = restTemplate.getForObject("http://localhost:9003/order/" + user.getOrderId(),
                                                Order.class);
        vo.setOrder(order);
        return vo;
    }
}
