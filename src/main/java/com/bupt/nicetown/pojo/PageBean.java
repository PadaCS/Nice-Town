package com.bupt.nicetown.pojo;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageBean<T> {
    private Long total;
    private List<T> items;
}
