package com.anidev.pushalert.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author sza
 */
@Data
@TableName("pushalert")
public class Pushalert implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private Long articleId;

    private String author;

    private String title;

    private LocalDateTime updateTime;

    private String label;

    private Long favorites;

    private String content;

    private Integer viewsCount;

    private Integer commentsCount;

    private Integer likesCount;

    private Integer sharesCount;

    private String authorAvatarUrl;

    @TableField("is_published")
    private Boolean published;


}
