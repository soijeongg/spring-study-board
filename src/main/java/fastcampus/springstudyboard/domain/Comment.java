package fastcampus.springstudyboard.domain;

import java.time.LocalDateTime;

public class Comment {
    private Long id;
    private Article article_title;
    private String content;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private  String modifiedBy;
    private  LocalDateTime updatedAt;
    private  String updatedBy;
}
