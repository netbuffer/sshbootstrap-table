package cn.com.ttblog.sshbootstrap_table.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.ttblog.sshbootstrap_table.model.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class TestAction extends ActionSupport implements ModelDriven<User>,
		Preparable {
	private static final Logger LOG=LoggerFactory.getLogger(TestAction.class);
	@Override
	public String execute() throws Exception {
		LOG.debug("test");
		return SUCCESS;
	}
	@Override
	public void prepare() throws Exception {
		
	}
	@Override
	public User getModel() {
		return null;
	}
}
