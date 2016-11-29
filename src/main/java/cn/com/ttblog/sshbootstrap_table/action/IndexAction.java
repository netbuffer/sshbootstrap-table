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
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.ttblog.sshbootstrap_table.model.User;
import cn.com.ttblog.sshbootstrap_table.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@ParentPackage("default")
@Namespace("/")
@Action("userAction")
@Results( { @Result(name = "success", location = "/index.jsp"),  
    @Result(name = "error", location = "/error.jsp") })  
@ExceptionMappings( { @ExceptionMapping(exception = "java.lang.RuntimeException", result = "error") })  
public class IndexAction extends ActionSupport implements ModelDriven<User>,
		Preparable {
	private static final Logger LOG=LoggerFactory.getLogger(IndexAction.class);
	@Autowired
	private IUserService userService;
	
	public IndexAction(){
		LOG.debug("实例化IndexAction:{}",this);
	}
	@Override
	public String execute() throws Exception {
		LOG.debug("首页");
		return SUCCESS;
	}
	
	@Action(value="test")
    public String test(){
        return SUCCESS;
    }
	
	@Action(value="count")
    public Long count(){
        Long count=userService.getUserListCount();
        LOG.debug("查询用户总数:{}",count);
        return count;
    }

	@Override
	public void prepare() throws Exception {
	}

	@Override
	public User getModel() {
		return new User();
	}

}
