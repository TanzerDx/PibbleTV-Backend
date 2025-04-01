
package com.pibbletv.follows_service.persistance.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("user_following")
public class FollowingEntity {

    @Id
    private Long id;

    private Long followerId;

    private Long followedId;
}