package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class AnaliseDeVendas2 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
			
		System.out.print("Entre com o Caminho do Arquivo: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			Map<String, Double> vendas = new LinkedHashMap<>();
			
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				Integer month = Integer.parseInt(fields[0]);
				Integer year = Integer.parseInt(fields[1]);
				String seller = fields[2];
				Integer items = Integer.parseInt(fields[3]);
				Double total = Double.parseDouble(fields[4]);
				if(vendas.containsKey(seller)) {
					double valor = vendas.get(seller);
					vendas.put(seller, total+valor);
				}else {
					vendas.put(seller, total);
				}
				line = br.readLine();
			}
			
			System.out.println();	
			System.out.println("Total de vendas por vendedor:");
			for(String key: vendas.keySet()) {
				System.out.println(key + " - "+String.format("%.2f", vendas.get(key)));
			}
			
		}catch(IOException e) {
			System.out.println("Erro: "+e.getMessage());
			
		}
		
		sc.close();
		

	}

}
