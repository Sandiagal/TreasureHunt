
public class BasicTool {

	/**
	 * һά������ͣ�������ֵ��
	 * 
	 * @param Set
	 *            ����͵�һά���顣
	 * @return �ܺ͡�
	 */
	public static long sum(long[] Set) {
		long sum = 0;
		for (int i = 0; i < Set.length; i++) {
			sum = sum + Set[i];
		}
		return sum;
	}

	/**
	 * һά������ͣ�������ֵ��
	 * 
	 * @param Set
	 *            ����͵�һά���顣
	 * @return �ܺ͡�
	 */
	public static int sum(int[] Set) {
		int sum = 0;
		for (int i = 0; i < Set.length; i++) {
			sum = sum + Set[i];
		}
		return sum;
	}

	/**
	 * ��ά������ͣ�����һά���顣
	 * 
	 * @param Set
	 *            ����͵�һά���顣
	 * @return �ܺ����顣
	 */
	public static long[] sum(long[][] Set) {
		long[] sum = new long[Set.length];
		for (int i = 0; i < Set.length; i++) {
			for (int j = 0; j < Set[i].length; j++) {
				sum[i] = sum[i] + Set[i][j];
			}
		}
		return sum;
	}

	/**
	 * ��ά������ͣ�����һά���顣
	 * 
	 * @param Set
	 *            ����͵�һά���顣
	 * @return �ܺ����顣
	 */
	public static int[] sum(int[][] Set) {
		int[] sum = new int[Set.length];
		for (int i = 0; i < Set.length; i++) {
			for (int j = 0; j < Set[i].length; j++) {
				sum[i] = sum[i] + Set[i][j];
			}
		}
		return sum;
	}

	/**
	 * ����һά�������һ����������λ�ã�����Ч���ȡ�
	 * 
	 * @param Set
	 *            Ҫ���ҵ����顣
	 * @return ��Ч���ȡ�������ȫΪ0�򷵻�-1��
	 */
	public static int effectiveLength(int[] Set) {
		for (int i = Set.length - 1; i > -1; i--) {
			if (Set[i] != 0) {
				return i + 1;
			}
		}
		return -1;
	}

	/**
	 * ����һά�������һ����������λ�ã�����Ч���ȡ�
	 * 
	 * @param Set
	 *            Ҫ���ҵ����顣
	 * @return ��Ч���ȡ�������ȫΪ0�򷵻�-1��
	 */
	public static int effectiveLength(long[] Set) {
		for (int i = Set.length - 1; i > -1; i--) {
			if (Set[i] != 0) {
				return i + 1;
			}
		}
		return -1;
	}

	/**
	 * ����һά�������һ����������λ�ã�����Ч���ȡ�
	 * 
	 * @param Set
	 *            Ҫ���ҵ����顣
	 * @return ��Ч���ȡ�������ȫΪ0�򷵻�1��
	 */
	public static int effectiveLength2(int[] Set) {
		for (int i = Set.length - 1; i > -1; i--) {
			if (Set[i] != 0) {
				return i + 1;
			}
		}
		return 1;
	}

	/**
	 * ���Ҷ�ά������ÿһά����Ч���ȡ�
	 * 
	 * @param Set
	 *            Ҫ���ҵ����顣
	 * @return ��Ч���ȡ�������ȫΪ0�򷵻�1��
	 */
	public static int[] effectiveLength2(int[][] Set) {
		int[] rslt = new int[Set.length];
		for (int i = 0; i < Set.length; i++) {
			rslt[i] = effectiveLength2(Set[i]);
		}
		return rslt;
	}

	/**
	 * ����һ��һά�������һ��������
	 * 
	 * @param intSet
	 *            �����ҵĶ�ά����
	 * @return ���ҽ��
	 */
	public static int lastNonzero(int[] intSet) {
		for (int i = intSet.length - 1; i > -1; i--) {
			if (intSet[i] != 0) {
				return intSet[i];
			}
		}
		return -1;
	}

	/**
	 * ��ӡ��һά�ַ����顣
	 * 
	 * @param Set
	 *            ����ӡ��һά�ַ����顣
	 */
	public static void show(String[] Set) {
		for (int i = 0; Set[i] != null; i++) {
			if (Set[i].length() != 0) {
				System.out.println(i + ":" + Set[i]);
			}
		}
	}

	/**
	 * ��ӡ����ά�ַ����顣
	 * 
	 * @param Set
	 *            ����ӡ��һά�ַ����顣
	 */
	public static void show(String[][] Set) {
		for (int i = 0; Set[i][0] != null; i++) {
			for (int j = 0; Set[i][j] != null; j++) {
				if (Set[i][j].length() != 0) {
					System.out.println(i + ". " + j + ": " + Set[i][j]);
				}
			}
			System.out.println("");
		}
	}

	/**
	 * ��ӡ��һά���顣
	 * 
	 * @param Set
	 *            ����ӡ��һά���顣
	 */
	public static void show(int[] Set) {
		for (int i = 0; i < effectiveLength(Set); i++) {
			System.out.print(Set[i] + " ");
		}
		System.out.println("");
	}

	/**
	 * ��ӡ����ά���顣
	 * 
	 * @param Set
	 *            ����ӡ�Ķ�ά���顣
	 */
	public static void show(long[][] Set) {
		for (int i = 0; i < effectiveLength(sum(Set)); i++) {
			System.out.print(i + ":");
			for (int j = 0; j < effectiveLength(Set[i]); j++) {
				System.out.print(Set[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	/**
	 * ��ӡ����ά���顣
	 * 
	 * @param Set
	 *            ����ӡ�Ķ�ά���顣
	 */
	public static void show(int[][] Set) {
		for (int i = 0; i < effectiveLength(sum(Set)); i++) {
			System.out.print(i + ":");
			for (int j = 0; j < effectiveLength(Set[i]); j++) {
				System.out.print(Set[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	/**
	 * ��һά���������ֵ��
	 * 
	 * @param Set
	 *            ����ӡ��һά���顣
	 * @return ���ֵ��
	 */
	public static int max(int[] Set) {
		int max = Set[0];
		for (int i = 1; i < Set.length; i++) {
			if (max < Set[i]) {
				max = Set[i];
			}
		}
		return max;
	}

	/**
	 * ����������ֵ�����ֵ���ѷ���ֵ����1.
	 * 
	 * @param value1
	 *            ��ֵ1
	 * @param value2
	 *            ��ֵ2
	 * @return ���ֵ
	 */
	public static int xor(int value1, int value2) {
		if (value1 * value2 == 0 && value1 + value2 != 0) {
			return 1;
		}
		return 0;
	}

	/**
	 * �����ַ��������к�ָ���ַ���������λ�ã���һά���鷵��λ��
	 * 
	 * @param string
	 *            ���ַ���
	 * @param aimString
	 *            Ҫ���ַ���
	 * @return ָ���ַ�λ��
	 */
	public static int[] findAll(String string, String aimString) {
		int[] rslt = new int[string.length()];
		int i = -2, j = 0;
		while ((i = string.indexOf(aimString, i + 1)) != -1) {
			rslt[j] = i;
			j++;
		}
		return rslt;
	}

	/**
	 * ����һ����Χ���Ƿ����һ�������е����֣������򷵻ظ������������е�λ�ã����򷵻�-1
	 * 
	 * @param lowEdge
	 *            �����½�
	 * @param upEdge
	 *            �����Ͻ�
	 * @param eare
	 *            ���ҵ���
	 * @return ��������������λ��
	 */
	public static int eareFind(int lowEdge, int upEdge, int[] eare) {
		for (int i = 0; i < eare.length; i++) {
			if (lowEdge < eare[i] && eare[i] < upEdge) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * ��a�ַ�����tλ�����b�ַ���
	 * 
	 * @param a
	 *            ������ַ���
	 * @param b
	 *            ����ַ���
	 * @param t
	 *            ���λ��
	 * @return ���ؽ��
	 */
	public static String stringInsert(String a, String b, int t) {
		return a.substring(0, t) + b + a.substring(t, a.length());
	}

	public void main(String[] args) {
		long[] a = { 1, 2, 6, 0, 5, 4, 0, 0 };
		System.out.println(effectiveLength(a));

		int b[] = { 1, 2, 5, 3, 7, 234, 214, 1342432421, 4, 2 };
		System.out.println(max(b));
		System.out.println(10 ^ 20);
	}
}
