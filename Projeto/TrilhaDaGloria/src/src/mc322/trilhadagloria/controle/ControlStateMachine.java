package mc322.trilhadagloria.controle;

public enum ControlStateMachine {
	AguardandoCompra {
		
		public ControlStateMachine proximoEstado() {
			return Invocacao;
		}
	},
 
	Invocacao {
		
		public ControlStateMachine proximoEstado() {
			return RevelarArmadilhas;
		}
	},
	RevelarArmadilhas {
		
		public ControlStateMachine proximoEstado() {
			return AtivarArmadilhas;
		}
	},
	AtivarArmadilhas {
		
		public ControlStateMachine proximoEstado() {
			return RevelarCombate;
		}
	},
	RevelarCombate {
		
		public ControlStateMachine proximoEstado() {
			return Combate;
		}
	},
	Combate {
		
		public ControlStateMachine proximoEstado() {
			return AguardandoCompra;
		}
	},
	
	FimDeJogo {
		public ControlStateMachine proximoEstado() {
			return FimDeJogo;
		}
	};
	
	public abstract ControlStateMachine proximoEstado();
}
