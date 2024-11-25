package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QfoodCategory is a Querydsl query type for foodCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QfoodCategory extends EntityPathBase<foodCategory> {

    private static final long serialVersionUID = 674887006L;

    public static final QfoodCategory foodCategory = new QfoodCategory("foodCategory");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.study.domain.mapping.MemberPrefer, umc.study.domain.mapping.QMemberPrefer> memberPrefers = this.<umc.study.domain.mapping.MemberPrefer, umc.study.domain.mapping.QMemberPrefer>createList("memberPrefers", umc.study.domain.mapping.MemberPrefer.class, umc.study.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QfoodCategory(String variable) {
        super(foodCategory.class, forVariable(variable));
    }

    public QfoodCategory(Path<? extends foodCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QfoodCategory(PathMetadata metadata) {
        super(foodCategory.class, metadata);
    }

}

