package com.scut.fan.Example;

import java.util.Date;
import com.scut.fan.JavaMail.*;

public class AccountActivateEmailInfo extends AbstractEmailInfo {


	@Override
	public void EmailEdit() {
		// TODO Auto-generated method stub
				this.setSubject("账户激活邮件");
				this.setSendDate(new Date());
				this.setFrom("fancanhuade@163.com");
				this.setTo("525921307@qq.com");
				this.setContent("<a href='" + AccountActivateExample.generateActivateLink("userAcc")+"'>您好，这是广东省阳光用药系统邮件，你的账号正在注册流程，请点击激活帐户</a>");
		
	}

}
