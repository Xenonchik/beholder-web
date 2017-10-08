package sharnyk.beholderweb;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HeaderLogInterceptor extends HandlerInterceptorAdapter {

  private static final Logger logg = Logger.getLogger(HeaderLogInterceptor.class);

  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    Enumeration<String> headerNames = request.getHeaderNames();

    if (headerNames != null) {
      while (headerNames.hasMoreElements()) {
        logg.warn("Header: " + request.getHeader(headerNames.nextElement()));
      }
    }

    return true;
  }
}
