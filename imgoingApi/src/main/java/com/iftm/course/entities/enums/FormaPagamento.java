package com.iftm.course.entities.enums;

public enum FormaPagamento {
	
	
	PAGAMENTO_CARTAO(1),
	PAGAMENTO_BOLETO(2);

	
	private int code;
	
	private FormaPagamento(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static FormaPagamento valueOf(int code) {
		for(FormaPagamento value : FormaPagamento.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}