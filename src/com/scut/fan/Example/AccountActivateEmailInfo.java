package com.scut.fan.Example;

import java.util.Date;
import com.scut.fan.JavaMail.*;

public class AccountActivateEmailInfo extends AbstractEmailInfo {


	@Override
	public void EmailEdit() {
		// TODO Auto-generated method stub
				this.setSubject("�˻������ʼ�");
				this.setSendDate(new Date());
				this.setFrom("fancanhuade@163.com");
				this.setTo("525921307@qq.com");
				this.setContent("<a href='" + AccountActivateExample.generateActivateLink("userAcc")+"'>���ã����ǹ㶫ʡ������ҩϵͳ�ʼ�������˺�����ע�����̣����������ʻ�</a>");
		
	}

}
