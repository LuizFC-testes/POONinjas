package mc322.trilhadagloria.carta;

import java.awt.Color;

public enum Dominio {
	TERRA(0) {
		@Override
		public Color getCor() {
			return new Color(1f, 0.592f, 0f);
		}
	}, FLORA(1) {
		@Override
		public Color getCor() {
			return new Color(0.031f, 0.659f, 0f);
		}
	}, GELO(2) {
		@Override
		public Color getCor() {
			return new Color(0.62f, 0.824f, 0.933f);
		}
	}, AGUA(3) {
		@Override
		public Color getCor() {
			return new Color(0.259f, 0.259f, 0.89f);
		}
	}, FOGO(4) {
		@Override
		public Color getCor() {
			return new Color(1f, 0f, 0f);
		}
	}, AR(5) {
		@Override
		public Color getCor() {
			return new Color(0f, 0.635f, 1f);
		}
	}, LUZ(6) {
		@Override
		public Color getCor() {
			return new Color(1f, 1f, 0f);
		}
	}, SOMBRA(7) {
		@Override
		public Color getCor() {
			return new Color(0.227f, 0.227f, 0.227f);
		}
	};

	private int value;

	Dominio(int i) {
		this.value = i;
	}
	
	public int getValue() {
		return value;
	}
	
	public abstract Color getCor();
}
