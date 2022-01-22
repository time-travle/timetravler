package org.joven.consume.client;

import org.joven.consume.entity.ReturnResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * https://www.cnblogs.com/feifuzeng/p/13613732.html
 * <p>
 * https://lovelive.tools/
 * name 调用服务名称，和value属性相同，如果项目使用了 Ribbon，name属性会作为微服务的名称，用于服务发现
 * url  url一般用于调试，可以手动指定@FeignClient调用的地址
 * path 自动给所有方法的requestMapping前加上前缀，类似与controller类上的requestMapping
 * <p>
 * https://www.v2ex.com/t/569853
 * 基础 API
 * GET https://api.lovelive.tools/api/SweetNothings
 * 使用此方法将会返回纯文本的一句随机的内容。
 * 高级 API
 * GET https://api.lovelive.tools/api/SweetNothings/:count/Serialization/:serializationType
 * GET https://api.lovelive.tools/api/SweetNothings/Serialization/:serializationType/:count
 * GET https://api.lovelive.tools/api/SweetNothings/Serialization/:serializationType
 * GET https://api.lovelive.tools/SweetNothings/:count
 * Url 变量说明：
 * serializationType：返回内容的格式，可以选择 Text 或 Json 格式。Text 格式会根据 count 的值以换行为分隔返回内容，Json 格式会在 returnObj 中 包含返回一个字符串类型的数组。
 * count：要获取的数量。如果不在 Url 中使用这个参数 ，将默认获取 1 个句子。
 * Json 格式返回值的示例：
 * GET https://api.lovelive.tools/api/SweetNothings/3/Serialization/Json
 * <p>
 * {
 * code: 200,
 * message: "",
 * returnObj: [
 * "她再也没有对我说过晚安，我的失眠也再没好过。",
 * "从遇见你的那一天起，我所走的每一步都是为了更接近你。"
 * ]
 * }
 */
@FeignClient(name = "badGuy", url = "https://api.lovelive.tools", path = "api")
public interface BadGuyFeignClient {

    /**
     * 随机获取一句甜言蜜语
     *
     * @return
     */
    @GetMapping("SweetNothings")
    String getSweetNothings();

    /**
     * 获取 count 条甜言蜜语
     *
     * @param count 获取甜言蜜语条数
     * @return Json 格式的结果
     */
    @GetMapping("SweetNothings/{count}/Serialization/Json")
    ReturnResult<List<String>> getSweetNothingsJsonByCount(@PathVariable("count") Integer count);
}
