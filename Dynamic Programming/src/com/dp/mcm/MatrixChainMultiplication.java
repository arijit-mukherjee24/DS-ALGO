package com.dp.mcm;

import java.util.Arrays;

// Aditya Verma : DP + Memoization Approach

// Techdose : Recursion + Tabulation Approach
// GFG : https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
public class MatrixChainMultiplication {

	static int[][] dp = new int[100][100];

	// Function for matrix chain multiplication
	static int matrixChainMemoised(int[] p, int i, int j) {
		if (i == j) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		dp[i][j] = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			dp[i][j] = Math.min(dp[i][j],
					matrixChainMemoised(p, i, k) + matrixChainMemoised(p, k + 1, j) + p[i - 1] * p[k] * p[j]);
		}
		return dp[i][j];
	}

	static int MatrixChainOrder(int[] p, int n) {
		int i = 1, j = n - 1;
		return matrixChainMemoised(p, i, j);
	}

	// Driver Code
	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4 };
		int n = arr.length;

		for (int[] row : dp)
			Arrays.fill(row, -1);

		System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, n));
	}

}


// Tabulation: GFG Solution and Techdose approach

/*
 *  // Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
    static int MatrixChainOrder(int p[], int n)
    {
        /* For simplicity of the
        program, one extra row and
        one extra column are allocated in m[][].  0th row
        and 0th column of m[][] are not used */
        
        /*int m[][] = new int[n][n];
 
        int i, j, k, L, q;
 
        /* m[i, j] = Minimum number of scalar
        multiplications needed to compute the matrix
        A[i]A[i+1]...A[j] = A[i..j] where
        dimension of A[i] is p[i-1] x p[i] */
 
        // cost is zero when multiplying one matrix.
        /*for (i = 1; i < n; i++)
            m[i][i] = 0;
 
        // L is chain length.
        /*for (L = 2; L < n; L++)
        {
            for (i = 1; i < n - L + 1; i++)
            {
                j = i + L - 1;
                if (j == n)
                    continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++)
                {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k + 1][j]
                        + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }
 
        return m[1][n - 1];
    }
    */
