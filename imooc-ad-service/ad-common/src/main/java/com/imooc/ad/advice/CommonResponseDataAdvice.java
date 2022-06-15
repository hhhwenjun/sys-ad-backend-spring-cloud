package com.imooc.ad.advice;

import com.imooc.ad.annotation.IgnoreResponseAdvice;
import com.imooc.ad.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 对响应的统一拦截和处理
 */
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {
    // 是否应当拦截，是否支持拦截
    @Override
    @SuppressWarnings("all")
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> aClass) {
        // 如果当前方法所在的类标识了 IgnoreResponseAdvice 注解, 则不需要处理
        if (methodParameter.getDeclaringClass().isAnnotationPresent(
                IgnoreResponseAdvice.class
        )){
            return false;
        }
        // 如果当前方法标识了 IgnoreResponseAdvice 注解, 则不需要处理
        if (methodParameter.getMethod().isAnnotationPresent(
                IgnoreResponseAdvice.class
        )){
           return false;
        }
        // 对响应进行处理, 执行 beforeBodyWrite 方法
        return true;
    }
    // 响应之前的操作
    @Override
    @SuppressWarnings("all")
    @Nullable
    public Object beforeBodyWrite(@Nullable Object o,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        // 定义最终的返回对象
        CommonResponse<Object> response = new CommonResponse<>(0, "");
        // o is response object, 如果 o 是 null, response 不需要设置 data
        if (null == o){
            return response;
            // 如果 o 已经是 CommonResponse 类型, 强转即可
        } else if (o instanceof CommonResponse){
            response = (CommonResponse<Object>) o;
            // 否则, 把响应对象作为 CommonResponse 的 data 部分
        } else {
            response.setData(o);
        }
        return null;
    }
}
