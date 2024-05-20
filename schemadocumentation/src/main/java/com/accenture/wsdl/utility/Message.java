package com.accenture.wsdl.utility;

import java.util.List;

import com.accenture.odata.utility.PartData;

public interface Message {
	
	public String getName();
	public String getMessage();
	public List<PartData> getPartDatas();
	
}
