package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QreviewImage is a Querydsl query type for reviewImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QreviewImage extends EntityPathBase<reviewImage> {

    private static final long serialVersionUID = 1154764481L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QreviewImage reviewImage = new QreviewImage("reviewImage");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image_url = createString("image_url");

    public final QReview review;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QreviewImage(String variable) {
        this(reviewImage.class, forVariable(variable), INITS);
    }

    public QreviewImage(Path<? extends reviewImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QreviewImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QreviewImage(PathMetadata metadata, PathInits inits) {
        this(reviewImage.class, metadata, inits);
    }

    public QreviewImage(Class<? extends reviewImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new QReview(forProperty("review"), inits.get("review")) : null;
    }

}

