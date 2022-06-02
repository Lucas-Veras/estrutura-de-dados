package pilhaRubroNegra;

public class PilhaArray implements IPilha {
	private Object[] a;
	private int capacidade;

	private int tamanhoVermelho;
	private int tamanhoPreto;

	public PilhaArray(int capacidade) {
		this.capacidade = capacidade;
		tamanhoVermelho = -1;
		tamanhoPreto = capacidade;

		a = new Object[capacidade];
	}

	@Override
	public void pushVermelho(Object o) {
		if (tamanhoVermelho >= tamanhoPreto - 1) {
			int capacidadeAntiga = capacidade;
			int tamanhoPretoAntigo = tamanhoPreto;
			this.capacidade = capacidade * 2;
			tamanhoPreto = capacidade;
			Object[] b = new Object[capacidade];

			for (int i = 0; i <= tamanhoVermelho; i++) {
				b[i] = a[i];
			}

			for (int j = capacidadeAntiga - 1; j >= tamanhoPretoAntigo; j--) {
				b[--tamanhoPreto] = a[j];
			}
			a = b;
		}
		a[++tamanhoVermelho] = o;
	}

	@Override
	public void pushPreto(Object o) {
		if (tamanhoVermelho >= tamanhoPreto - 1) {
			int capacidadeAntiga = capacidade;
			int tamanhoPretoAntigo = tamanhoPreto;
			this.capacidade = capacidade * 2;
			tamanhoPreto = capacidade;
			Object[] b = new Object[capacidade];

			for (int j = capacidadeAntiga - 1; j >= tamanhoPretoAntigo; j--) {
				b[--tamanhoPreto] = a[j];
			}

			for (int i = 0; i <= tamanhoVermelho; i++) {
				b[i] = a[i];
			}
			a = b;
		}
		a[--tamanhoPreto] = o;
	}

	@Override
	public Object popVermelho() throws PilhaVaziaException {
		if (isEmptyAll()) {
			throw new PilhaVaziaException("A pilha está vazia");
		}
		Object elemento = a[tamanhoVermelho];
		a[tamanhoVermelho] = null;
		tamanhoVermelho--;
		return elemento;
	}

	@Override
	public Object popPreto() throws PilhaVaziaException {
		if (isEmptyAll()) {
			throw new PilhaVaziaException("A pilha está vazia");
		}
		Object elemento = a[tamanhoPreto];
		a[tamanhoPreto] = null;
		tamanhoPreto++;
		return elemento;
	}

	@Override
	public Object topVermelho() throws PilhaVaziaException {
		if (isEmptyAll()) {
			throw new PilhaVaziaException("A pilha está vazia");
		}
		return a[tamanhoVermelho];
	}

	@Override
	public Object topPreto() throws PilhaVaziaException {
		if (isEmptyAll()) {
			throw new PilhaVaziaException("A pilha está vazia");
		}
		return a[tamanhoPreto];
	}

	@Override
	public boolean isEmptyAll() {
		return tamanhoVermelho == -1 && tamanhoPreto == capacidade;
	}

	@Override
	public boolean isEmptyVermelho() {
		return tamanhoVermelho == -1;
	}

	@Override
	public boolean isEmptyPreto() {
		return tamanhoPreto == capacidade;
	}

	@Override
	public int sizeAll() {
		int size = 0;
		if (!isEmptyAll()) {
			for (int i = 0; i < a.length; i++) {
				if (a[i] != null) {
					size++;
				}
			}
		}
		return size;
	}

	@Override
	public int sizeVermelho() {
		return tamanhoVermelho + 1;
	}

	@Override
	public int sizePreto() {
		return capacidade - tamanhoPreto;
	}

	@Override
	public void mostrarAll() {
		System.out.println("### Array Total ###");
		System.out.printf("%s%10s\n", " _______", " ________ ");
		System.out.printf("%s%10s\n", "|Indice", " |Valores |");
		System.out.printf("%s%10s\n", "|-------", "|--------|");
		for (int i = 0; i < a.length; i++) {
			System.out.printf("|%5d%3s%7d |\n", i, " |", a[i]);
		}
		System.out.printf("%s%10s\n", "|-------", "|--------|");
		System.out.println("Quantidade total de elementos no array: " + sizeAll());
		System.out.println("Quantidade de elementos na pilha vermelha: " + sizeVermelho());
		System.out.println("Quantidade de elementos na pilha preta: " + sizePreto());
	}

	@Override
	public void mostrarVermelho() {
		System.out.println("### Pilha Vermelha ###");
		System.out.printf("%s%10s\n", " _______", " ________ ");
		System.out.printf("%s%10s\n", "|Indice", " |Valores |");
		System.out.printf("%s%10s\n", "|-------", "|--------|");
		for (int i = 0; i < sizeVermelho(); i++) {
			System.out.printf("|%5d%3s%7d |\n", i, " |", a[i]);
		}
		System.out.printf("%s%10s\n", "|-------", "|--------|");
		System.out.println("Quantidade de elementos na pilha vermelha: " + sizeVermelho());
	}

	@Override
	public void mostrarPreto() {
		System.out.println("### Pilha Preta ###");
		System.out.printf("%s%10s\n", " _______", " ________ ");
		System.out.printf("%s%10s\n", "|Indice", " |Valores |");
		System.out.printf("%s%10s\n", "|-------", "|--------|");
		int cont = 0;
		for (int i = capacidade - 1; i >= tamanhoPreto; i--) {
			System.out.printf("|%5d%3s%7d |\n", cont, " |", a[i]);
			cont++;
		}
		System.out.printf("%s%10s\n", "|-------", "|--------|");
		System.out.println("Quantidade de elementos na pilha preta: " + sizePreto());
	}
}
