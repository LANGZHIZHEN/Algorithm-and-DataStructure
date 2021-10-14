#include <bits/stdc++.h>
using namespace std;

int n;
int A[2020];
int use[2020];
int isFind(int index, int m)
{
    if (m == 0)
        return 1;
    if (index >= n)
        return 0;
    int res = isFind(index + 1, m) || isFind(index + 1, m - A[index]);
    return res;
}
int main()
{
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> A[i];
    }
    int q;
    cin >> q;
    for (int i = 0; i < q; i++)
    {
        int m;
        scanf("%d", &m);
        if (isFind(0, m))
            cout << "yes" << endl;
        else
            cout << "no" << endl;
    }
}
