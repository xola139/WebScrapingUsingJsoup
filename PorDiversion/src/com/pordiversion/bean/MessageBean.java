package com.pordiversion.bean;

public class MessageBean {
	private String flujo;
	private String javascriptFunctionName;
	private Object[] args;
	
	public String getFlujo() {
		return flujo;
	}
	public void setFlujo(String flujo) {
		this.flujo = flujo;
	}
	public String getJavascriptFunctionName() {
		return javascriptFunctionName;
	}
	public void setJavascriptFunctionName(String javascriptFunctionName) {
		this.javascriptFunctionName = javascriptFunctionName;
	}
	public Object[] getArgs() {
		return args;
	}
	public void setArgs(Object[] args) {
		this.args = args;
	}
	public String getPage() {
		if (getFlujo().equals("aCentral")) {
			return "/KardumenLectura/cajeros.html";
		} else {
			return "/KardumenLectura/flujoACliente.html";
		}
	}
}
