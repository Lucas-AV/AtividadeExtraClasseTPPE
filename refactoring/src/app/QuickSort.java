package app;

public class QuickSort {

    private int[] valores;

    private QuickSort(int[] valores) {
        this.valores = valores;
    }

    public static QuickSort getInstancia(int[] valores) {
        return new QuickSort(valores);
    }

    public int getSize() {
        return valores.length;
    }

    // objeto-método
    public int particionamento(int left, int right) {
        Particionador particionador = new Particionador(left, right);
        return particionador.realizarParticionamento();
    }

    // Classe interna que realiza o particionamento
    private class Particionador {
        private int left;
        private int right;

        public Particionador(int left, int right) {
            this.left = left;
            this.right = right;
        }

        // Método que realiza a operação de particionamento
        public int realizarParticionamento() {
            int pivot = inicializarPivo();
            int i = left;

            i = varrerVetor(i, pivot);

            trocarPivo(i);
            return i;
        }

        // Inicialização do pivô
        private int inicializarPivo() {
            return valores[left]; // Pivô é o primeiro elemento
        }

        // Varredura do vetor
        private int varrerVetor(int i, int pivot) {

			// Varre o vetor da esquerda para a direita
            for (int j = i + 1; j <= right; j++) {
                if (valores[j] <= pivot) {
                    i++;
                    swap(i, j);
                }
            }
            return i;
        }
		
		// Troca de elementos
		private void swap(int i, int j) {
			int t = valores[i];
			valores[i] = valores[j];
			valores[j] = t;
		}

        // Trocar o pivô
        private void trocarPivo(int i) {
            swap(left, i);
        }

    }

	// Ordenação
    public int[] ordenar(int left, int right) {
        if (left < right) {
            int indicePivot = particionamento(left, right);
            ordenar(left, indicePivot - 1);
            ordenar(indicePivot + 1, right);
        }
        return valores;
    }
}
