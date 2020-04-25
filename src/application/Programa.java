package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Path do arquivo:");
		String path = sc.nextLine();
		Map<String,Integer>dados = new HashMap<>();
		try(BufferedReader bf = new BufferedReader(new FileReader(path))){
			String linha = bf.readLine();
			while(linha!=null) {
				String []campos = linha.split(",");
				if(!dados.containsKey(campos[0])) {
					dados.put(campos[0],Integer.valueOf(campos[1]));
				}
				else {
					Integer valor = dados.get(campos[0]);
					valor += Integer.valueOf(campos[1]);
					dados.replace(campos[0],valor);
				}
				linha = bf.readLine();
			}
			for(String key:dados.keySet()) {
				System.out.println(key+": "+dados.get(key));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}

}
