package com.IsefEneyen.Gastropedia.Repositories;

import com.IsefEneyen.Gastropedia.Models.Comment;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;

public interface CommentRepository extends JpaAttributeConverter<Comment, Long> {
}
