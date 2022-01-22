package org.joven.subscriber.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.joven.base.entity.ResponseBody;
import org.joven.base.utils.BaseValidateUtil;
import org.joven.subscriber.entity.DailyExpensesInfoEntity;
import org.joven.subscriber.entity.DailyExpensesInfoResp;
import org.joven.subscriber.mapper.DailyExpensesInfoMapper;
import org.joven.subscriber.service.DailyExpensesInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Component
public class DailyExpensesInfoServiceImpl implements DailyExpensesInfoService {

	@Autowired
	private DailyExpensesInfoMapper dailyExpensesInfoMapper;
	@Autowired(required = false)
	private RestTemplate restTemplate;// 跨服务调用

	@Override
	public DailyExpensesInfoResp getAllInfos(Integer begin, Integer pageSize) {
		log.debug("getAllInfos --->req:begin:{}   pageSize:{}", begin, pageSize);
		// 用来分页查询的入参不能为空
		Assert.isTrue(BaseValidateUtil.isNumericByAscill(begin.toString()), "begin is not Numeric");
		Assert.isTrue(BaseValidateUtil.isNumericByAscill(pageSize.toString()), "pageSize is not Numeric");

		DailyExpensesInfoResp resp = new DailyExpensesInfoResp();
		ResponseBody responseBody = new ResponseBody("0", "success");

		try {
			List<DailyExpensesInfoEntity> infos = dailyExpensesInfoMapper.getAllInfos(begin, pageSize);
			resp.setInfos(infos);
		} catch (Exception e) {
			responseBody.setReturnCode("-1");
			responseBody.setReturnMessage("查询失败");
		}

		resp.setResponseBody(responseBody);
		log.debug("getAll res :{}", JSONObject.toJSON(resp));
		return resp;
	}

	@Override
	public DailyExpensesInfoEntity getInfoById(String id) {
		log.debug("DailyExpensesInfoServiceImpl--id-->{}", id);
		Assert.notNull(id, "id is null");
		DailyExpensesInfoEntity res = dailyExpensesInfoMapper.getInfoById(id);
		return res;
	}

	@Override
	public DailyExpensesInfoResp getInfoByIds(List<String> ids) {
		log.debug("getInfoByIds req --ids->:{}", ids);

		dailyExpensesInfoMapper.getInfoByIds(ids);

		return new DailyExpensesInfoResp();

	}

	@Override
	public ResponseBody modifyInfoById(DailyExpensesInfoEntity targetInfo) {
		log.debug("modifyInfoById -- req:{}", JSONObject.toJSON(targetInfo));
		dailyExpensesInfoMapper.modifyInfoById(targetInfo);
		return new ResponseBody("0", "success");
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResponseBody deleteInfoByIds(List<String> ids) {
		dailyExpensesInfoMapper.deleteInfoByIds(ids);
		return new ResponseBody("0", "success");
	}

	@Override
	public ResponseBody bathModifyInfoById(List<DailyExpensesInfoEntity> lists) {
		dailyExpensesInfoMapper.bathModifyInfoById(lists);
		return new ResponseBody("0", "success");
	}

	@Override
	public ResponseBody bathInsertInfos(List<DailyExpensesInfoEntity> lists) {
		dailyExpensesInfoMapper.bathInsertInfos(lists);
		return new ResponseBody("0", "success");
	}


}
