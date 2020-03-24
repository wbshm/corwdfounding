package com.local.crowd.mvc.config;

import com.google.gson.Gson;
import com.local.crowd.constant.CrowdConstant;
import com.local.crowd.util.CrowdUtil;
import com.local.crowd.util.ResultEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ControllerAdvice 表示当前的类是一个异常处理器
 */
@ControllerAdvice
public class CrowdExceptionResolver {

    @ExceptionHandler(value = ArithmeticException.class)
    public ModelAndView resolveArithmeticException(NullPointerException exception,
                                                   HttpServletRequest request,
                                                   HttpServletResponse response) throws IOException {
        return getModelAndView(exception, request, response, "system-error");
    }

    /**
     * @param exception
     * @return
     * @ExceptionHandler 将一个具体的异常类型he已改方法关联起来
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView resolveNullPointerException(NullPointerException exception,
                                                    HttpServletRequest request,
                                                    HttpServletResponse response) throws IOException {
        return getModelAndView(exception, request, response, "system-error");
    }

    private ModelAndView getModelAndView(NullPointerException exception,
                                         HttpServletRequest request,
                                         HttpServletResponse response,
                                         String viewName) throws IOException {
        String msg = exception.getMessage();
        if (CrowdUtil.judgeRequestType(request)) {
            // 创建ResultEntity 对象
            ResultEntity<Object> failed = ResultEntity.failed(exception.getMessage());
            // 转为Json字符串
            Gson gson = new Gson();
            String json = gson.toJson(failed);
            // 将json字符串作为响应体返回给前端
            response.getWriter().write(json);
            // 由于上面已经通过原生的response对象返回了响应，所以不提供modelAndView对象
            return null;
        } else {
            //非Ajax请求
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject(CrowdConstant.ATTR_NAME_EXCEPTION, exception);
            // 设置对应的视图名称
            modelAndView.setViewName(viewName);
            //返回ModelAndView
            return modelAndView;
        }
    }
}
