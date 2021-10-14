#include <bits/stdc++.h>
typedef long long ll;
using namespace std;
int n, k;
int getNum(int p, vector<ll> &vt)
{
    int i = 0;
    for (int j = 0; j < k; j++)
    {
        ll s = 0;
        while (s + vt[i] <= p)
        {
            s += vt[i];
            i++;
            if (i == n)
                return n;
        }
    }
    return i;
}
int solve(vector<ll> &vt)
{
    ll left = 0;
    ll right = 100000 * 10000;
    ll mid;
    while (right - left > 1)
    {
        mid = (left + right) / 2;
        int v = getNum(mid, vt);
        if (v >= n)
            right = mid;
        else
            left = mid;
    }
    return right;
}
int main()
{
    cin >> n >> k;
    vector<ll> vt(n);
    for (int i = 0; i < n; i++)
    {
        cin >> vt[i];
    }
    int ans = solve(vt);
    cout << ans << endl;
}