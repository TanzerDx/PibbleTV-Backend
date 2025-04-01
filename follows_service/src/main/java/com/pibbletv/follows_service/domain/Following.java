package com.pibbletv.follows_service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Following {

    private Long id;

    private Long followerId;

    private Long followedId;
}
