/**
 * Project Name: blog project
 * File Name: DailyExpensesInfoResp
 * Package Name: org.joven.base.entity
 * Date: 2019/11/5 23:14
 * Copyright (c) 2019,All Rights Reserved.
 */
package org.joven.subscriber.entity;

//import com.github.pagehelper.PageHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joven.base.entity.ResponseBody;

import java.util.List;

/**
 * CreateBy Notebook
 * Date: 2019/11/5 23:14
 * Version: 
 * Remark: 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyExpensesInfoResp {
    private List<DailyExpensesInfoEntity> infos;
    private ResponseBody responseBody;
   // private PageHelper pageInfo;
}
