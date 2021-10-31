package com.example.userservice.vo;

import com.example.userservice.entity.Order;
import com.example.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReponseTemplateVO {
    private User user;
    private Order order;
}
