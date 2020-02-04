import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MergeSort {

	public static void main(String[] args) {
		int[] x = abrirArquivo();
		
		mergeSort(x);
		System.out.println("Depois de Ordenado:");
		System.out.println(Arrays.toString(x));

		// Agora chamar o metodo de ordena?ao

	}

	private static void mergeSort(int[] a, int[] vectorTemp, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(a, vectorTemp, left, center);
			mergeSort(a, vectorTemp, center + 1, right);
			merge(a, vectorTemp, left, center + 1, right);
		}
	}

	public static void mergeSort(int[] a) {
		int vectorTemp[];
		vectorTemp = new int[a.length];
		mergeSort(a, vectorTemp, 0, a.length - 1);
	}

	private static void merge(int[] vet, int[] vetortemp, int inicio, int meio,
			int fim) {
		int medio = meio - 1;
		int aux = inicio;
		int size = fim - inicio + 1;

		while (inicio <= medio && meio <= fim) {
			if ((vet[inicio]) < (vet[meio]))
				vetortemp[aux++] = vet[inicio++];
			else
				vetortemp[aux++] = vet[meio++];
		}

		while (inicio <= medio)
			vetortemp[aux++] = vet[inicio++];

		while (meio <= fim)
			vetortemp[aux++] = vet[meio++];

		for (int i = 0; i < size; i++, fim--)
			vet[fim] = vetortemp[fim];
	}

	public static int[] abrirArquivo() {
		int[] vetor = null;

		String num = null, s = "";
		int i;
		//File dir = new File("C:\\Users\\ederson\\Documents\\Estatistica");
		//File arquivo = new File(dir + "\\vetor10.txt");
		File arquivo = new File("vetor10.txt");
		FileReader fileReader;
		try {
			fileReader = new FileReader(arquivo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((num = bufferedReader.readLine()) != null) {

				s += num + " ";
			}
			fileReader.close();
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Vetor Original:");
		System.out.println(s);
		String[] vetorString = s.split(" ");
		i = vetorString.length;
		vetor = new int[i];
		i = 0;
		for (String vs : vetorString) {
			vetor[i] = Integer.parseInt(vs);
			i++;
		}
		return vetor;
	}

}