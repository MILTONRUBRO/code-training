package br.com.devmos.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import br.com.devmos.model.Car;
import br.com.devmos.model.Tabela;

public class UtilInterviewQuestions {

	private static final String COMMA_DELIMITER = ";";
	private static long BYTE = 1L;
	private static long KB = BYTE << 10;
	private static long MB = KB << 10;
	private static long GB = MB << 10;
	private static long TB = GB << 10;
	private static long PB = TB << 10;
	private static long EB = PB << 10;
	private static DecimalFormat DEC_FORMAT = new DecimalFormat("#.##");

	/**
	 * Dado um array de inteiros retorne o indice dos dois elementos que a soma seja
	 * igual ao target
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];

			if (map.containsKey(temp)) {
				int[] x = new int[2];
				x[0] = map.get(temp);
				x[1] = i;
				return x;
			}

			map.put(nums[i], i);
		}
		return nums;
	}

	/**
	 * Dado um array de inteiros representado valor de ações deve se encontrar qual
	 * o melhor valor para se vender
	 * 
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		int max = 0;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] <= min)
				min = prices[i];
			if (prices[i] - min >= max)
				max = prices[i] - min;
		}
		return max;
	}

	/**
	 * Dado uma string com paranteses, chaves e colchetes return se é valido com a
	 * abertura e fechamento do mesmo tipo
	 * 
	 * @return
	 */
	public static boolean isValid(String str) {
		Map<Character, Character> map = new HashMap<>();

		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');

		Stack<Character> answer = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (!map.containsKey(c))
				answer.push(c);

			if (map.containsKey(c)) {
				char top = answer.isEmpty() ? '#' : answer.peek();
				if (top != map.get(c))
					return false;
				else
					answer.pop();
			}
		}
		return answer.isEmpty();
	}

	/**
	 * Converte numeros romanos em inteiros
	 * 
	 * @param str
	 * @return
	 */
	public static int romanToInt(String str) {
		int[] map = new int[256];

		map['I'] = 1;
		map['V'] = 5;
		map['X'] = 10;
		map['L'] = 50;
		map['C'] = 100;
		map['D'] = 500;
		map['M'] = 1000;

		int ret = 0;
		int pre = 1;

		for (int i = str.length() - 1; i >= 0; i--) {
			int cur = map[str.charAt(i)];
			if (cur < pre) {
				ret -= cur;
			} else {
				pre = cur;
				ret += cur;
			}
		}

		return ret;
	}

	/**
	 * Dado um array de numeros inteiros retorne o numero faltante na sequencia
	 * 
	 * @param nums
	 * @return
	 */
	public static int missingNumber(int[] nums) {
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		int total = (nums.length * (nums.length + 1)) / 2;

		return total - sum;
	}

	public static char firstNonRepeatingCharacter(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
				return str.charAt(i);
			}
		}
		return '-';
	}

	public static Set<String> intersectionSet(Set<String> set1, Set<String> set2) {
		set1.retainAll(set2);
		return set1;
	}

	/**
	 * Algoritmo de busca binaria
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int binarySearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (target == nums[mid]) {
				return mid;
			} else if (target < nums[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * Aloritmo de insercao no metodo sort
	 * 
	 * @param arr
	 */
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int value = arr[i];
			int j = i;

			while (j > 0 && arr[j - 1] > value) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = value;
		}
	}

	/**
	 * dado um numero nao negativo numRow gere a primeira numRow do triangulo de
	 * Pascal
	 * 
	 * @param numRows
	 * @return
	 */
	public static List<List<Integer>> pascalTriangle(int numRows) {
		List<List<Integer>> integers = new ArrayList<List<Integer>>();

		int c = 1;
		int line = 1;

		for (; line <= numRows; line++) {
			List rows = new ArrayList();
			c = 1;
			for (int i = 1; i <= line; i++) {
				rows.add(c);
				c = c * (line - 1) / i;
			}
			integers.add(rows);
		}
		return integers;
	}

	public static int getContainerWithMostWater(int[] heights) {
		int start = 0;
		int end = heights.length - 1;
		int area = 0;

		while (start < end) {
			area = Math.max(area, Math.min(heights[start], heights[end]) * (end - start));
			if (heights[start] < heights[end])
				start++;
			else
				end--;
		}
		return area;
	}

	public static int[] dailyTemperatures(int[] nums) {
		int size = nums.length;
		int answer[] = new int[size];

		for (int i = 0; i < size - 1; i++) {
			int flag = 0;

			for (int j = i + 1; j < size; j++) {
				if (nums[j] > nums[i]) {
					answer[i] = j - i;
					flag = 1;
					break;
				}
			}

			if (flag == 0) {
				answer[i] = 0;
			}
		}
		answer[size - 1] = 0;
		return answer;
	}

	/**
	 * Usando o algoritmo de Floyd ou algoritmo da lebre e tartaruga para encontrar
	 * valor duplicado no array
	 * 
	 * @return
	 */
	public static int findDuplicate(int[] numbers) {
		int size = numbers.length;

		if (size <= 1)
			return -1;

		int slow = numbers[0];
		int fast = numbers[numbers[0]];

		while (fast != slow) {
			slow = numbers[slow];
			fast = numbers[numbers[fast]];
		}

		fast = 0;

		while (slow != fast) {
			slow = numbers[slow];
			fast = numbers[fast];
		}

		return slow;
	}

	/**
	 * retorna o maximo de ouro que pode ser coletado quando uma jornada starta
	 * 
	 * @param gold
	 * @param m
	 * @param n
	 * @return
	 */
	public static int getMaxGold(int gold[][], int m, int n) {
		int goldTable[][] = new int[m][n];

		for (int[] rows : goldTable) {
			Arrays.fill(rows, 0);
		}

		for (int col = n - 1; col >= 0; col--) {

			for (int row = 0; row < m; row++) {
				int right = (col == n - 1) ? 0 : goldTable[row][col + 1];
				int right_up = (row == 0 || col == n - 1) ? 0 : goldTable[row - 1][col + 1];
				int right_down = (row == m - 1 || col == n - 1) ? 0 : goldTable[row + 1][col + 1];

				goldTable[row][col] = gold[row][col] + Math.max(right, Math.max(right_up, right_down));

			}
		}

		int res = goldTable[0][0];

		for (int i = 1; i < m; i++) {
			res = Math.max(res, goldTable[i][0]);
		}

		return res;
	}

	/**
	 * Add two numbers without using arithmetic operators
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int sumWithoutOperators(int num1, int num2) {
		while (num2 != 0) {
			int carry = num1 & num2;

			num1 = num1 ^ num2;
			num2 = carry << 1;
		}
		return num1;
	}

	/**
	 * Dado uma pilha de meias retorne os pares encontrados na lista
	 * 
	 * @param sockers
	 * @return
	 */
	public static int sockMerchant(List<Integer> sockers) {
		Set<Integer> unmatched = new HashSet<>();
		int pairs = 0;

		for (int i = 0; i < sockers.size(); i++) {
			if (!unmatched.add(sockers.get(i))) {
				unmatched.remove(sockers.get(i));
				pairs++;
			}
		}
		return pairs;
	}

	public static int countWays(int n) {
		if (n == 1)
			return 4;

		int countB = 1;
		int countS = 1;
		int prevCountB;
		int prevCountS;

		for (int i = 2; i <= n; i++) {
			prevCountB = countB;
			prevCountS = countS;

			countS = prevCountB + prevCountS;
			countB = prevCountS;
		}

		int result = countS + countB;

		return (result * result);
	}

	public static long countWays(int s[], int m, int n) {
		long[] table = new long[n + 1];

		Arrays.fill(table, 0);
		table[0] = 1;

		for (int i = 0; i < m; i++) {
			for (int j = s[i]; j <= n; j++) {
				table[j] += table[j - s[i]];
			}
		}

		return table[n];
	}

	public static int calcBinominalCoeficiente(int n, int k) {
		if (k > n)
			return 0;
		if (k == 0 || k == n)
			return 1;

		return calcBinominalCoeficiente(n - 1, k - 1) + calcBinominalCoeficiente(n - 1, k);
	}

	public static int[] reverseArrayInGrups(int arr[], int n, int k) {
		for (int i = 0; i < n; i += k) {

			int left = i;
			int right = Math.min(i + k - 1, n - 1);
			int temp;

			while (left < right) {
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;

				left += 1;
				right -= 1;
			}
		}

		return arr;
	}

	public static int maxSubArraySum(int numbers[]) {
		int size = numbers.length;
		int maxSoFar = Integer.MIN_VALUE;
		int maxEndingHere = 0;

		for (int i = 0; i < size; i++) {
			maxEndingHere = maxEndingHere + numbers[i];

			if (maxSoFar < maxEndingHere)
				maxSoFar = maxEndingHere;
			if (maxEndingHere < 0)
				maxEndingHere = 0;
		}
		return maxSoFar;
	}

	/**
	 * Dado um array de N-1 que só contem inteiros diferentes no range 1 para N
	 * encontre o numero perdido
	 * 
	 * @param numbers
	 * @param n
	 * @return
	 */
	public static int missingNumber(int[] numbers, int n) {
		int sum = 0;

		for (int i = n; i >= 1; i--) {
			sum += i;
		}

		return sum - Arrays.stream(numbers).sum();
	}

	public static String caesarCipher(String frase, int casas) {
		var sb = new StringBuilder();

		for (int i = 0; i < frase.length(); i++) {
			char letra = frase.charAt(i);

			if (Character.isLetter(letra)) {
				if (Character.isUpperCase(letra)) {
					sb.append(avancaLetra(letra, casas));
				} else {
					sb.append(Character.toLowerCase(avancaLetra(Character.toUpperCase(letra), casas)));
				}
			} else {
				sb.append(letra);
			}
		}
		return sb.toString();

	}

	public static Character avancaLetra(Character chr, int pos) {

		var alfabeto = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
				'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');

		int limite = alfabeto.indexOf(chr) + pos;

		if (limite >= 26) {
			limite = limite % 26;
		}

		return alfabeto.get(limite);
	}

	/**
	 * a tesoura corta o papel; o papel embrulha a pedra; a pedra esmaga o lagarto;
	 * o lagarto envenena Spock; Spock destrói a tesoura; a tesoura decapita o
	 * lagarto; o lagarto come o papel; o papel contesta Spock; Spock vaporiza a
	 * pedra; a pedra quebra a tesoura.
	 */

	public static String lizardSpockGame(String player1, String player2) {
		List<Tabela> games = Tabela.getTabelaGames();

		if (player1.equalsIgnoreCase(player2)) {
			return "De novo!";
		}

		return games.stream().filter(g -> g.getJ1().equalsIgnoreCase(player1) && g.getJ2().equalsIgnoreCase(player2))
				.findFirst().orElseThrow(NoSuchElementException::new).getMsg();
	}

	public static String removeNoAlphabet(String frase) {
		String regex = "[^A-Za-z0-9]";
		return frase.replaceAll(regex, "");
	}

	public static String contaLetras(String frase) {
		String str = removeNoAlphabet(frase);
		Set<Character> letras = new HashSet<>();

		for (int i = 0; i < str.length(); i++) {
			letras.add(str.charAt(i));
		}

		int size = letras.size();
		String msg = "";

		if (size == 26) {
			msg = "frase completa";
		} else if (size >= 13) {
			msg = "frase quase completa";
		} else {
			msg = "frase mal elaborada";
		}

		return msg;
	}

	/**
	 * Sherlock considers a string to be valid if all characters of the string
	 * appear the same number of times
	 * 
	 * @param frase
	 * @return
	 */
	public static String sherlockString(String frase) {
		Map<Character, Integer> quantidadeLetras = new HashMap<>();

		for (int i = 0; i < frase.length(); i++) {
			Character letra = frase.charAt(i);

			if (quantidadeLetras.containsKey(letra)) {
				quantidadeLetras.put(letra, quantidadeLetras.get(letra) + 1);
			} else {
				quantidadeLetras.put(letra, 1);
			}
		}

		List<Integer> quantidades = new ArrayList<>(quantidadeLetras.values());
		Integer max = Collections.max(quantidades);
		Integer min = Collections.min(quantidades);

		if (max == min) {
			return "YES";
		}

		int minCount = 0;
		int maxCount = 0;

		for (int i = 0; i < quantidades.size(); i++) {
			if (quantidades.get(i) == max) {
				maxCount++;
			} else if (quantidades.get(i) == min) {
				minCount++;
			}
		}

		return (minCount == 1 || (maxCount == 1 && max == min + 1)) ? "YES" : "NO";
	}

	public static String sundayMorning(String str) {

		String[] relogio = str.split(":");
		int hora = Integer.parseInt(relogio[0]);
		int min = Integer.parseInt(relogio[1]);

		return switch (hora) {
		case 7 -> "Atraso maximo: " + min;
		case 8 -> "Atraso maximo: " + 60 + min;
		case 9 -> "Atraso maximo: " + 120 + min;
		default -> "Atraso maximo: 0";
		};

	}

	public static String fasesLua(int start, int end) {
		String fase = "";

		if (start >= 0 && end <= 2) {
			fase = "nova";
		} else if (end > start && end <= 96) {
			fase = "crescente";
		} else if (start >= end && end <= 96) {
			fase = "minguante";
		} else {
			fase = "cheia";
		}

		return fase;
	}

	public static String getPasswordRa(String frase) {

		StringBuilder crypt = new StringBuilder();

		frase = frase.replaceAll(" ", "").trim();

		var hashRA = getHashRA();

		for (int i = 0; i < frase.length(); i++) {

			char c = frase.charAt(i);

			if (crypt.length() == 12)
				break;

			if (hashRA.containsKey(c))
				crypt.append(hashRA.get(c));

		}
		return crypt.toString();
	}

	public static Map<Character, Character> getHashRA() {

		return new HashMap<Character, Character>() {
			{
				put('G', '0');
				put('Q', '0');
				put('a', '0');
				put('k', '0');
				put('u', '0');
				put('I', '1');
				put('S', '1');
				put('b', '1');
				put('l', '1');
				put('v', '1');
				put('E', '2');
				put('O', '2');
				put('Y', '2');
				put('c', '2');
				put('m', '2');
				put('w', '2');
				put('F', '3');
				put('P', '3');
				put('Z', '3');
				put('d', '3');
				put('n', '3');
				put('x', '3');
				put('J', '4');
				put('T', '4');
				put('e', '4');
				put('o', '4');
				put('y', '4');
				put('D', '5');
				put('N', '5');
				put('X', '5');
				put('f', '5');
				put('p', '5');
				put('z', '5');
				put('A', '6');
				put('K', '6');
				put('U', '6');
				put('g', '6');
				put('q', '6');
				put('C', '7');
				put('M', '7');
				put('W', '7');
				put('h', '7');
				put('r', '7');
				put('B', '8');
				put('L', '8');
				put('V', '8');
				put('i', '8');
				put('s', '8');
				put('H', '9');
				put('R', '9');
				put('j', '9');
				put('t', '9');

			}
		};

	}

	public static String validPassword(String password) {
		if (password.contains(" "))
			return "Senha invalida";

		if (password.length() < 6 || password.length() > 32)
			return "Senha invalida";

		return "Senha valida";
	}

	public static int getAsc(Character c) {
		return c;
	}

	public static void readCsv(List<List<String>> records, String fileName) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(COMMA_DELIMITER);
				records.add(Arrays.asList(values));
			}
		}
	}

	public static int commonChild(String a, String b) {
		int[][] c = new int[a.length() + 1][b.length() + 1];

		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (a.charAt(i) == b.charAt(j)) {
					c[i + 1][j + 1] = c[i][j] + 1;
				} else {
					c[i + 1][j + 1] = Math.max(c[i + 1][j], c[i][j + 1]);
				}
			}
		}

		return c[a.length()][b.length()];
	}

	public List<Integer> findDivisors(int number) {
		return Stream.iterate(1, k -> ++k).limit(number).filter(k -> number % k == 0).collect(Collectors.toList());
	}

	public static <T> Set<T> subtract(Set<T> set1, Set<T> set2) {
		return set1.stream().filter(value -> !set2.contains(value)).collect(Collectors.toSet());
	}

	public static List<Object> removeNulls(List<Object> list) {
		return list.stream().filter(Objects::nonNull).collect(Collectors.toList());
	}

	public static int booleanPrimitiveToIntTernary(boolean foo) {
		return (foo) ? 1 : 0;
	}

	public static String toHumanReadable(long size) {
		if (size < 0) {
			throw new IllegalArgumentException("Invalid file size: " + size);
		}
		if (size >= EB)
			return formatSize(size, EB, "EB");
		if (size >= PB)
			return formatSize(size, PB, "PB");
		if (size >= TB)
			return formatSize(size, TB, "TB");
		if (size >= GB)
			return formatSize(size, GB, "GB");
		if (size >= MB)
			return formatSize(size, MB, "MB");
		if (size >= KB)
			return formatSize(size, KB, "KB");
		return formatSize(size, BYTE, "Bytes");
	}

	private static String formatSize(long size, long divider, String unitName) {
		return DEC_FORMAT.format((double) size / divider) + " " + unitName;
	}

	public static boolean isAutomorphicNumber(int number) {
		int square = number * number;

		while (number > 0) {
			if (number % 10 != square % 10) {
				return false;
			}
			number /= 10;
			square /= 10;
		}

		return true;
	}

	public String convertToCSV(String[] data) {
		return Stream.of(data).map(this::escapeSpecialCharacters).collect(Collectors.joining(","));
	}

	public String escapeSpecialCharacters(String data) {
		String escapedData = data.replaceAll("\\R", " ");
		if (data.contains(",") || data.contains("\"") || data.contains("'")) {
			data = data.replace("\"", "\"\"");
			escapedData = "\"" + data + "\"";
		}
		return escapedData;
	}

	public static List<String> findDistinctStrings(List<String> list) {
		return list.stream().distinct().collect(Collectors.toList());
	}

	public static List<String> toUpper(List<String> list) {
		return list.stream().map(String::toUpperCase).collect(Collectors.toList());
	}

	public static Map<String, Integer> orderMap(Map<String, Integer> unsortMap) {
		return unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors
				.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
	}

	public static List<Car> removeData(List<Car> cars) {
		cars.removeIf(car -> car.getModelo().isBlank());
		return cars;
	}

	public static int sumWithReduce(int[] numbers) {
		return Arrays.stream(numbers).reduce(0, Integer::sum);
	}

	public static int partition(int array[], int low, int high) {

		int pivot = array[high];
		int i = (low - 1);

		for (int j = low; j < high; j++) {
			if (array[j] <= pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}

		}

		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;

		return (i + 1);
	}

	public static void quickSort(int array[], int low, int high) {
		if (low < high) {
			int pi = partition(array, low, high);
			quickSort(array, low, pi - 1);
			quickSort(array, pi + 1, high);
		}
	}

	public int runBinarySearchIteratively(int[] sortedArray, int key, int low, int high) {
		int index = Integer.MAX_VALUE;

		while (low <= high) {
			int mid = low + ((high - low) / 2);
			if (sortedArray[mid] < key) {
				low = mid + 1;
			} else if (sortedArray[mid] > key) {
				high = mid - 1;
			} else if (sortedArray[mid] == key) {
				index = mid;
				break;
			}
		}
		return index;
	}
	
	public static int soma(int[] numeros) {
		int soma = 0;
		
		for(int i = 0; i < numeros.length; i++) {
			soma += numeros[i];
		}
		
		return soma;
	}
	
	/**
	 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
		If the town judge exists, then:
		The town judge trusts nobody.
		Everybody (except for the town judge) trusts the town judge.
		here is exactly one person that satisfies properties 1 and 2.
	 * @param n
	 * @param trust
	 * @return
	 */
    public static int findJudge(int n, int[][] trust){
        int[] count = new int[n+1];
        
        for(int[] t : trust){
            count[t[0]]--;
            count[t[1]]++;
        }
        
        for(int i = 1; i <= n; i++){
            if(count[i] == n-1) return i;
        }
        
        return -1;
    }
    
    public static Map<String, String> arrayToMap(String[][] array) {
        Map<String, String> map = new HashMap<>();

        for (String[] pair : array) {
             if (pair.length > 1) {
                 map.put(pair[0], pair[1]);
             }
        }
        return map;
    }
    
    public static Map<Character, Character> montaTabela(String str) {
    	Map<Character, Character> tabela = new HashMap<>();
    	int count = 97;
    	
    	for(char c : str.toCharArray()) {
    		if(c == ' ') continue;
    		
    		if(!tabela.containsKey(c)) {
        		tabela.put(c, (char) count);
        		count++;
    		}
    	}
    	    	
    	return tabela;
    }
    
    public static String decifraMensagem(String chave, String mensagem) {
    	
    	StringBuilder sb = new StringBuilder();
    	Map<Character, Character> tabela = montaTabela(chave);
    	
    	for(char c : mensagem.toCharArray()) {
    		if(c == ' ')sb.append(" ");
    		
    		if(tabela.containsKey(c)) {
    			sb.append(tabela.get(c));
    		}
    	}
    	return sb.toString();
    }
    
    public static char[] reverseArrayChar(char[] c) {
		char temp;
		for(int i = 0, j = c.length - 1; i <= j; i++, j--) {
			temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
		return c;
    }
    
	public static boolean valueOfCheesBorder(String coordenada ) {
		char letter = coordenada.charAt(0);
		Integer position  = Integer.valueOf(coordenada.charAt(1));
		
		if((letter == 'a' || letter == 'c' || letter == 'e' ||  letter == 'g')) {
			if(position % 2 != 0) return false;
			return true;
		}else if((letter == 'b' || letter == 'd' || letter == 'f' ||  letter == 'h')) {
			if(position % 2 != 0) return true;
			return false;
		}
		return false;
	}
	
	/**
	 * leetcode 102
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                }                
            }    
            
            result.add(level);
        }
        
        return result;
    }
	

    /**
     * iterator a deque
     * @param dq
     */
    public void iteratoArrayDeque(Deque<String> dq) {
        for (Iterator itr = dq.iterator(); itr.hasNext();) {
       	 
            // Print the elements
            System.out.print(itr.next() + " ");
        }
    }
    
    /**
     *  sum of a binary tree
     * @param root
     * @return
     */
    public static int sumBinaryTree(Node root){
        int sum = 0;
 
        Queue<Node> list = new LinkedList<>();
        list.add(root);
 
        while (!list.isEmpty()) {
            Node temp = list.poll();
            sum += temp.key;
 
            if (temp.left != null) {
            	list.add(temp.left);
            }
            if (temp.right != null) {
            	list.add(temp.right);
            }
        }
        return sum;
    }
    
    static class Node {
        int key;
        Node left; 
        Node right;
    }
    
    public boolean isPalindromeUsingStringBuilder(String text) {
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        StringBuilder plain = new StringBuilder(clean);
        StringBuilder reverse = plain.reverse();
        return (reverse.toString()).equals(clean);
    }
    
    public boolean isPalindromeReverseTheString(String text) {
        StringBuilder reverse = new StringBuilder();
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        char[] plain = clean.toCharArray();
        for (int i = plain.length - 1; i >= 0; i--) {
            reverse.append(plain[i]);
        }
        return (reverse.toString()).equals(clean);
    }
    
    public static boolean isPalindrome(String text) {
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        int length = clean.length();
        int forward = 0;
        int backward = length - 1;
        while (backward > forward) {
            char forwardChar = clean.charAt(forward++);
            char backwardChar = clean.charAt(backward--);
            if (forwardChar != backwardChar)
                return false;
        }
        return true;
    }
    
    public static boolean isPalindromeUsingIntStream(String text) {
        String temp  = text.replaceAll("\\s+", "").toLowerCase();
        return IntStream.range(0, temp.length() / 2)
          .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));
    }
    
    public static boolean isPalindromeRecursive(String text){
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        return recursivePalindrome(clean,0,clean.length()-1);
    }

    private static boolean recursivePalindrome(String text, int forward, int backward) {
        if (forward == backward) {
            return true;
        }
        if ((text.charAt(forward)) != (text.charAt(backward))) {
            return false;
        }
        if (forward < backward + 1) {
            return recursivePalindrome(text, forward + 1, backward - 1);
        }
        return true;
    }
    
	public static String printBinary(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
	
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (num > 0) {
			/* Setting a limit on length: 32 characters */
			if (binary.length() > 32) {
				return "ERROR";
			}
			double r = num * 2;
			if (r >= 1) {
				binary.append(1);
				num = r - 1;
			} else {
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	}
	
	public static double runFamilies(int n) {
		int boys = 0;
		int girls = 0;
		
		for(int i = 0; i < n; i++) {
			int[] genders = runOneFamily();
			girls += genders[0];
			boys += genders[1];
		}
		return girls / (double) (boys + girls);
	}

	private static int[] runOneFamily() {
		Random random = new Random();
		int boys = 0;
		int girls = 0;
		
		while(girls == 0) {
			if(random.nextBoolean()) {
				girls += 1;
			}else {
				boys += 1;
			}
		}
		int[] genders = {girls, boys};
		return genders;
	}

}
