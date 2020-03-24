package com.local.crowd.util;

import javax.servlet.http.HttpServletRequest;

public class CrowdUtil {
    /**
     * 判断当前判断是否是ajax请求。
     * @param request
     * @return
     */
    public static boolean judgeRequestType(HttpServletRequest request) {
        String accept = request.getHeader("Accept");
        String xRequestHeader = request.getHeader("X-Requested-With");
        boolean isAccept = accept != null && accept.contains("application/json");
        return isAccept || (xRequestHeader != null && xRequestHeader.contains("XMLHttpRequest"));
    }
}
