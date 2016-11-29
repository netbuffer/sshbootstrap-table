package cn.com.ttblog.sshbootstrap_table.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.ttblog.sshbootstrap_table.model.User;
import cn.com.ttblog.sshbootstrap_table.service.IUserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

@ParentPackage("default")
@Namespace("/")
@Action("user")
@Results({  
    @Result(name = "json",type="json", params={"root","data"})  
})
//展示 错误
@InterceptorRefs(value={@InterceptorRef(value="defaultStack",params={"exception.logEnabled","true"})})
@ExceptionMappings( { @ExceptionMapping(exception = "java.lang.Exception", result = "error") })  
public class UserAction extends BaseAction implements Preparable {
	private static final Logger LOG=LoggerFactory.getLogger(UserAction.class);
	@Autowired
	private IUserService userService;
	
	public UserAction(){
		LOG.debug("实例化UserAction:{}",this);
	}
	
	@Override
	public String execute() throws Exception {
		LOG.debug("user 控制器");
		return SUCCESS;
	}
	
	@Action(value="userlist")
    public String userlist(){
//		ServletActionContext.getRequest()
//		ServletActionContext.getResponse()
//		ServletActionContext.getContext()
		Map<String, Object> data=new HashMap<String, Object>();
		Map<String, Object> param=super.getRequest();
		ActionContext context=ActionContext.getContext();
		Map  parameterMap=context.getParameters(); 
		ServletRequest request=super.getServletRequest();
		LOG.debug("查询条件ServletRequest,limit:{},offset:{},order:{}",request.getParameter("limit"),request.getParameter("offset"),request.getParameter("order"));
		LOG.debug("查询条件parameterMap,limit:{},offset:{},order:{}",parameterMap.get("limit"),parameterMap.get("offset"),parameterMap.get("order"));
		LOG.debug("查询条件param,limit:{},offset:{},order:{}",param.get("limit"),param.get("offset"),param.get("order"));
		List<User> rows=userService.getUserList(request.getParameter("order"),
				Integer.parseInt(request.getParameter("limit")),
				Integer.parseInt(request.getParameter("offset")));
		Long count=userService.getUserListCount();
		data.put("total", count);
		data.put("rows", rows);
		super.writeJson(data);
		return null;
//		return "json";
    }
	
	@Action(value="count")
    public String count(){
		Map<String, Object> data=new HashMap<String, Object>();
		Long count=userService.getUserListCount();
		data.put("count", count);
		data.put("success", true);
        LOG.debug("查询用户总数:{}",count);
        return "json";
    }

	@Override
	public void prepare() throws Exception {
		LOG.debug("prepare execute");
	}

}
