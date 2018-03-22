package com.qincloud.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qincloud.common.domain.LogDO;
import com.qincloud.common.domain.PageDO;
import com.qincloud.common.utils.Query;
@Service
public interface LogService {
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
