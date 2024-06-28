package challenge;

import challenge.pojo.ProductSales;
import challenge.pojo.ProductStock;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.*;

/*
/ Author: Hidalgo Renteria Rolando E.
/ Date: 28/06/2024
*/
public class Solution {

	public static List<Long> sortProductsByScores(int stockWeight, int salesWeight,
												  List<ProductStock> productsStock, List<ProductSales> productsSales) throws Exception {

		// Validacion 1: Lista esta vacia
		if (productsStock.isEmpty()) {
			throw new Exception("Error la lista de stock esta vacia");
		}

		// Validacion 2: Lista Stock y ventas debe contenter misma longitud
		int listStockSize = productsStock.size();
		int listSalesSize = productsStock.size();
		if (listStockSize != listSalesSize) {
			throw new Exception("Error no tiene la misma longitud");
		}

		// Validacion 3: Ninguna de las dos listas no deben contener nulos
		boolean stockListNull = productsStock.stream().anyMatch(x -> x == null);
		boolean salesListNull = productsSales.stream().anyMatch(x -> x == null);
		if (stockListNull || salesListNull) {
			throw new Exception("Error contienen nulos");
		}

		// Validacion 4: El id de cada producto y ventas deben ser identico
		List<Long> listStockindex = productsStock.stream()
				.map(stock -> stock.getProductId()).sorted().collect(Collectors.toList());
		List<Long> listSalesindex = productsSales.stream()
				.map(stock -> stock.getProductId()).sorted().collect(Collectors.toList());

		if (!listStockindex.equals(listSalesindex)) { // O(nlogn)
			throw new Exception("Error los ids de stock y ventas son diferentes.");
		}

		// Validacion 5: identificador unico
		boolean containsDuplicateProduct = listStockindex.stream().distinct().count() == listStockSize;
		if (!containsDuplicateProduct) {
			throw new Exception("Error la lista productos stock contiene duplicados, debe ser unico.");
		}

		// Validacion 6:  El peso (%) de las ventas y stocks deben sumar en total 100
		int totalWeight = stockWeight + salesWeight;
		final int TOTAL_WEIGHT = 100;
		if (TOTAL_WEIGHT != totalWeight) {
			throw new Exception("Error la suma de pesos no es 100.");
		}

		// Logica Principal:

		// lambda para buscar el producto por identificación y devolver su stock
		BiFunction<List<ProductStock>, Long, Long> findStock = (list, id) -> list.stream()
				.filter(stock -> stock.getProductId().equals(id))
				.findFirst()
				.get()
				.getAvailableStock();

		// lambda para buscar el producto por identificación y devolver sus ventas
		BiFunction<List<ProductSales>, Long, Double> findSales = (list, id) -> list.stream()
				.filter(stock -> stock.getProductId().equals(id))
				.findFirst()
				.get()
				.getSalesAmount();

		// parse de peso porcentual a peso decimal
		double factorStock = (double) stockWeight / 100;
		double factorSales = (double) salesWeight / 100;

		// calcular el peso total de cada producto
		Map<Long, Double> productsWeight = productsStock.stream()
				.map(ProductStock::getProductId)
				.collect(Collectors.toMap(id -> id,
						id -> (findStock.apply(productsStock, id) * factorStock) +
								(findSales.apply(productsSales, id) * factorSales)));

		// Productos en orden inverso comparando su peso de mayor a menor.
		List<Long> orderProductsWeight = productsWeight.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());

		return orderProductsWeight;
	}
}
