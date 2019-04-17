package com.upc.Domain.Relations;


import com.upc.Domain.Node.PhoneNode;
import com.upc.Domain.Node.UserNode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Property;
import org.springframework.data.annotation.Id;
import javax.persistence.GeneratedValue;

/**
 * @Author: Pan
 * @Date: 2019/4/15 20:03
 * @Description:
 **/

@Getter
@Setter
@NoArgsConstructor
@RelationshipEntity(type = "BROWSE_GOOD")
public class BrowserRelation {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "BrowseTimes")
    private int browseTimes;
    @Property(name = "LastTime")
    private String lastTime;

    public BrowserRelation(int browseTimes, String lastTime) {
        this.browseTimes = browseTimes;
        this.lastTime = lastTime;
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
