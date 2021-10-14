#include <bits/stdc++.h>
using namespace std;
long long sum = 0;
void merge(int A[], int left, int mid, int right)
{
    int l1 = mid - left + 1;
    int l2 = right - mid;
    int *L1 = new int[l1];
    int *L2 = new int[l2];
    for (int i = 0; i < l1; i++)
    {
        L1[i] = A[i + left];
    }
    for (int i = 0; i < l2; i++)
    {
        L2[i] = A[i + mid + 1];
    }
    int i = 0, j = 0;
    int k = left;
    while (i < l1 && j < l2)
    {
        if (L1[i] <= L2[j])
        {
            A[k] = L1[i];
            i++;
            k++;
        }
        else
        {
            A[k] = L2[j];
            j++;
            k++;
            sum += l1 - i;
        }
    }
    while (i < l1)
    {
        A[k] = L1[i];
        i++;
        k++;
    }
    while (j < l2)
    {
        A[k] = L2[j];
        j++;
        k++;
    }
    // for (int k = left; k < right; k++)
    // {
    //     if (L1[i] <= L2[j])
    //     {
    //         A[k] = L1[i];
    //         i++;
    //     }
    //     else
    //     {
    //         A[k] = L2[j];
    //         j++;
    //     }
    // }
}
void mergeSort(int A[], int left, int right)
{
    if (right > left)
    {
        int mid = (left + right) / 2;
        mergeSort(A, left, mid);
        mergeSort(A, mid + 1, right);
        merge(A, left, mid, right);
    }
}
int main()
{
    int n;
    int *A;
    cin >> n;
    A = new int[n];
    for (int i = 0; i < n; i++)
    {
        cin >> A[i];
    }
    mergeSort(A, 0, n - 1);
    // for (int i = 0; i < n; i++)
    // {
    //     cout << A[i] << " ";
    // }
    // cout << endl;
    cout << sum << endl;
}