package com.makersacademy.acebook.dto;



import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private String content;
    private String displayName;
    private LocalDateTime createdAt;
    private long likesCount;
    private List<String> likers;
    private String profilePic;
    private Long commenterId;

    public CommentDto(Long id, String content, String displayName,
                      LocalDateTime createdAt, long likesCount, List<String> likers, String profilePic, Long commenterId) {
        this.id = id;
        this.content = content;
        this.displayName = displayName;
        this.createdAt = createdAt;
        this.likesCount = likesCount;
        this.likers = likers;
        this.profilePic = profilePic;
        this.commenterId = commenterId;
    }
}


