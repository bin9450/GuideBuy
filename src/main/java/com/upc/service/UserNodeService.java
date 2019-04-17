package com.upc.service;

import com.upc.domain.node.UserNode;
import com.upc.repository.UserNodeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @Author: Pan
 * @Date: 2019/4/11 17:30
 * @Description:
 **/

@Service
public class UserNodeService {

    private final UserNodeRepository userNodeRepository;
    public UserNodeService(UserNodeRepository userNodeRepository) {
        this.userNodeRepository = userNodeRepository;
    }


    @Transactional(readOnly = true)
    public UserNode findByNickName(String nickName){
        UserNode result = userNodeRepository.findByNickName(nickName);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<UserNode> findByNickNameLike(String nickName){
        Collection<UserNode> result = userNodeRepository.findByNickNameLike(nickName);
        return  result;
    }

    @Transactional(readOnly = true)
    public UserNode findByUserId(int userId){
        UserNode userNode = userNodeRepository.findByUserId(userId);
        return userNode;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void createUserNode(int userId,String nickName){
        userNodeRepository.createUserNode(userId,nickName);
    }


}
