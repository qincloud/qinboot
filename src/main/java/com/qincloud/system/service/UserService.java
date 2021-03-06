package com.qincloud.system.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.qincloud.common.domain.Tree;
import com.qincloud.system.domain.DeptDO;
import com.qincloud.system.domain.UserDO;

@Service
public interface UserService {
	UserDO get(Long id);

	List<UserDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(UserDO user);

	int update(UserDO user);

	int remove(Long userId);

	int batchremove(Long[] userIds);

	boolean exit(Map<String, Object> params);

	Set<String> listRoles(Long userId);

	int resetPwd(UserDO user);

	Tree<DeptDO> getTree();

}
