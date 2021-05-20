package com.guigu;

/**
 * 响应码：0表示成功，其他表示错误或失败
 *
 */
public enum ResultCode {

	Success("200", "操作成功"), 
	ERROR("500", "系统内部异常"), 
	Fail("400", "操作失败"), 
	Param_Error("400", "参数异常"), 
	Format_Error("415", "格式错误"), 
	METHOD_NO_SUPPORT("405", "不支持当前请求方法"), 
	No_Exist("410", "记录不存在或已被删除"),
	
	Chinese_Cannot_Be_Null("403","中文不能为空"),
	
	Account_Permission_denied("403", "没有操作权限"),
	Account_No_Login("401", "没有登录,或登录已过期"),
	
	DATABASE_LENGTH_ERROR("403","输入的参数长度超标"),
	DATABASE_PARSE_ERROR("403","输入的参数类型或格式有误"),
	DATABASE_OPERATE_ERROR("403","数据库操作异常"),
	
	
	Account_Create_Fail("403","创建账号失败"),
	Account_Expired("403", "帐号已过期"),
	Account_Disabled("403", "帐号已禁用"),
	Account_Locked("403", "帐号已锁定"),
	The_Same_Account("403","已经存在相同的登录账号"),
	Accouont_Password_Expired("403", "密码过期"),
	Account_Password_Worng("403", "用户名或密码错误"),
	Account_Username_Not_Found("401", "找不到该帐号"),
	Account_Sessioin_Expired("403", "session会话异常"),
	Account_Captcha_Not_Found("403","验证码异常"),
	Account_Captcha_Worng("403","验证码有误"),
	User_Not_Found("403","找不到该用户，无法操作"),
	Can_Not_Be_Null("403","不能为空"),
	Is_Exists("403","已存在,不可重复"),
	Admin_Not_Allow_Oper("403","管理员,不允许操作"),
	Id_Is_Blank("403","id为空，操作失败"),
	Unable_System("403","无法匹配系统"),
	Illegal_Opertion("400","不合法操作"),
	Donot_Exists("403","不存在,无法操作"),
	Data_Error("403","数据异常"),
	Unable_To_Parse("403","参数格式,无法解析"),
	Query_Condition_Cannot_Be_Empty("403","查询条件不能为空"),
	Parameter_Incomplete("403","参数不完整"),
	Must_Be_Unique("403","必须唯一"),
	Unrecognized("400","无法识别"),
	IsNull("403","为空,无法操作"),
	Has_Be_Confirm("403","已经确认,无法再修改"),
	Already_In_Use("403","已被使用"),
	Achieve_Fail("403","获取失败");
	
	private String httpCode;
	private String msg;

	private ResultCode(String httpCode,String msg) {
		this.httpCode = httpCode;
		this.msg = msg;
	}

	
	public String getCode() {
		return httpCode;
	}

	public String getMsg() {
		return msg;
	}

}
