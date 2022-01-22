基础部分 上一个文件 [mapperfile1.md](./mapperfile1.md)

#视图
    把视图当普通的表，用select  字段  from 视图 where 的形式。
    如：
    <select id="getListByName" parameterType="java.util.Map" resultMap="Country">
        SELECT DISTINCT countryname FROM `idc_cmdb`.view_city  
            <where>
                <if test="countryname != null">
                    countryname LIKE  CONCAT('%', '${countryname}', '%')
                </if>
            </where>
    </select>
    备注： mapper.xml中where后面的参数条件一定是在视图中返回的，不然会报错。

#存储过程
    demo1:
     <!-- 调用存储过程查询 -->
     <select id="testProcedure" parameterType="java.util.Map" statementType="CALLABLE" resultType="java.util.HashMap">  
        {
            call loginandreg(
                #{out_ret,mode=OUT,javaType=java.lang.Integer,jdbcType=INTEGER},
                #{out_desc,mode=OUT,javaType=java.lang.String,jdbcType=VARCHAR},
                #{userId,jdbcType=VARCHAR,mode=OUT},
                #{user_pwd,jdbcType=VARCHAR,mode=IN},
                #{nickname,jdbcType=VARCHAR,mode=IN}
            )
        }
      </select>
      
     demo2:
     有返回结果集
     如存储过程结构如下：
         p_my_wallet(IN var_user_id INT)；
         参数是用户id
         revenue_today   今日收益
         revenue_contacts  人脉收益
         balance   可用余额
     sql部分如下：
         <!-- 获取钱包信息 -->
         <select id="getMyWallet" parameterType="java.lang.Integer" resultType="java.util.Map" statementType="CALLABLE">
         {
         　　call p_my_wallet(
         　　　　#{userId,jdbcType=INTEGER,mode=IN}
         　　)
         }
         </select>
#序列
    oracle的写法：
        <selectKey keyProperty="id" resultType="long" order="BEFORE">
          SELECT user_id_sequence.nextval from dual
        </selectKey>


#事务




###insert all
    demo1：
     <insert id="batchInsertArriveInfo" parameterType="java.util.List" useGeneratedKeys="false">
        insert all
        <foreach collection="list" item="info" index="index">
          into
          T_ARRIVAL_STATION_INFORMATION
          (BUS_PATH_ID,STATION_SN,TASK_STATUS,ARR_TIME,BUS_PATH_NAME,RUN_FLAG,VEHICLE_ID,station_name,station_id)
          values
          (
          #{info.busPathId},#{info.stationSn},#{info.taskStatus},
          #{info.arrTime},#{info.busPathName},#{info.runFlag},
          #{info.vehicleId},#{info.stationName},#{info.stationId}
          )
        </foreach>
        select 1 from dual
      </insert>