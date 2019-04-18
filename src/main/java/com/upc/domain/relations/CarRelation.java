package com.upc.domain.relations;

import com.upc.domain.node.PhoneNode;
import com.upc.domain.node.UserNode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;

/**
 * @Author: Pan
 * @Date: 2019/4/18 16:28
 * @Description:
 **/

@Getter
@Setter
@NoArgsConstructor
@RelationshipEntity(type = "CAR_GOOD")
public class CarRelation {


    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "CarTime")
    private String carTime;

    public CarRelation(String carTime) {
        this.carTime = carTime;
    }

    @StartNode
    private UserNode userNode;
    public void addUser(UserNode userNode){
        if(this.userNode== null){
            this.userNode = new UserNode();
        }
        this.userNode = userNode;
    }

    @EndNode
    private PhoneNode phoneNode;
    public void addPhone(PhoneNode phoneNode){
        if(this.phoneNode== null){
            this.phoneNode = new PhoneNode();
        }
        this.phoneNode = phoneNode;
    }

}
