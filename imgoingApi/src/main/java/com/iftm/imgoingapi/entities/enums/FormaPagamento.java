package com.iftm.imgoingapi.entities.enums;

public enum FormaPagamento {
	
	PAGAMENTO_CARTAO(0),
	PAGAMENTO_BOLETO(1);

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