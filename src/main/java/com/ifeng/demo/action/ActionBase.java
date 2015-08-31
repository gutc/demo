package com.ifeng.demo.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public abstract class ActionBase extends ActionSupport implements Preparable,
		ServletRequestAware, ServletContextAware, ServletResponseAware,
		SessionAware {
	private static final long serialVersionUID = 1L;
	protected HttpServletRequest request;
	protected ServletContext context; // application
	protected HttpServletResponse response;
	protected Map<String, Object> session;
	protected String Json(Object data) throws JsonProcessingException {
		if (data.getClass() == String.class) {
			return data.toString();
		} else {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(data);
		}

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;

	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}
