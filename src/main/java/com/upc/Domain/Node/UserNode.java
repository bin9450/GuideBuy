package com.upc.Domain.Node;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/4 16:54
 * @Description:
 **/


@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = "UserNode")
public class UserNode {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "user_id")
    private int userId;

    @Property(name = "nick_name")
    private String nickName;

    public UserNode(int userId,String nickName){
        this.userId = userId;
        this.nickName = nickName;
    }

/*    @Relationship(type = "Browser",direction = Relationship.OUTGOING)
    private List<PhoneNode> phoneNodes;
    public void addBrowserPhone(PhoneNode phoneNode){
        if(this.phoneNodes == null){
            this.phoneNodes = new ArrayList<>();
        }
        this.phoneNodes.add(phoneNode);
    }
    */
}
