package com.anidev.content.dto;

import lombok.Data;

/**
 * @author suzhengang
 * @create 2023-05-27
 */
@Data
public class PostDto {

    private String label;
    private String title;
    private String author;
    private String updateTime;
    private Long favorites;
}
