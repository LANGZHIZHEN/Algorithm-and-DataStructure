// #include <bits/stdc++.h>
// using namespace std;
// bool binarySearch(int A[], int key, int n)
// {
//     int left = 0;
//     int right = n;
//     while (left < right)
//     {
//         int mid = (left + right) / 2;
//         if (key == A[mid])
//             return true;
//         else if (key < A[mid])
//             right = mid;
//         else
//             left = mid + 1;
//     }
//     return false;
// }
// int main()
// {
//     int n, m;
//     int A[100010];
//     int B[50005];
//     cin >> n;
//     for (int i = 0; i < n; i++)
//     {
//         cin >> A[i];
//     }
//     cin >> m;
//     for (int i = 0; i < m; i++)
//     {
//         cin >> B[i];
//     }
//     int sum = 0;
//     for (int i = 0; i < m; i++)
//     {
//         int key = B[i];
//         if (binarySearch(A, key, n))
//             sum++;
//     }
//     cout << sum << endl;
// }
#include <bits/stdc++.h>
using namespace std;
int main()
{
    int n, m;
    cin >> n;
    vector<int> vt(n);
    for (int i = 0; i < n; i++)
    {
        cin >> vt[i];
    }
    vector<int>::iterator it;
    cin>>m;
    int k;
    int sum = 0;
    for (int i = 0;i<m;i++)
    {
        scanf("%d", &k);
        if(*(lower_bound(vt.begin(),vt.end(),k)) == k)
            sum++;
    }
    cout << sum << endl;
}